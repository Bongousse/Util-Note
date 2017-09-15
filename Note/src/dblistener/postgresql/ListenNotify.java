package dblistener.postgresql;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

import com.impossibl.postgres.api.jdbc.PGConnection;
import com.impossibl.postgres.api.jdbc.PGNotificationListener;
import com.impossibl.postgres.jdbc.PGDataSource;

/**
 * This program uses the pgjdbc_ng driver which has an asynchronous
 * implementation for blocking on the Postgres NOTIFY/LISTEN events.
 *
 * No polling is done using this driver. You will see a forever loop
 * "while(true)" in the main(). This is done to keep the program running and
 * listening to multiple events happening in Postgres. Normally you would just
 * take one event and then do something with it.
 *
 */
@SuppressWarnings({ "unchecked", "rawtypes" })
public class ListenNotify {
	// Create the queue that will be shared by the producer and consumer

	private BlockingQueue queue = new ArrayBlockingQueue(10);

	// Database connection
	PGConnection connection;

	public ListenNotify() {
		// Get database info from environment variables
		String DBHost = "182.162.100.120";
		String DBName = "bxt_db";
		String DBUserName = "bxt";
		String DBPassword = "bxt";

		// Create the listener callback
		PGNotificationListener listener = new PGNotificationListener() {
			@Override
			public void notification(int processId, String channelName, String payload) {
				// Add event and payload to the queue
				queue.add("/channels/" + channelName + " " + payload);
			}
		};

		try {
			// Create a data source for logging into the db
			PGDataSource dataSource = new PGDataSource();
			dataSource.setHost(DBHost);
			dataSource.setPort(7349);
			dataSource.setDatabase(DBName);
			dataSource.setUser(DBUserName);
			dataSource.setPassword(DBPassword);

			// Log into the db
			connection = (PGConnection) dataSource.getConnection();

			// add the callback listener created earlier to the connection
			connection.addNotificationListener(listener);

			// Tell Postgres to send NOTIFY q_event to our connection and
			// listener
			Statement statement = connection.createStatement();
			statement.execute("LISTEN q_event");
			statement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * @return shared queue
	 */
	public BlockingQueue getQueue() {
		return queue;
	}

	/**
	 *
	 * main entry point
	 *
	 * @param args
	 */
	public static void main(String[] args) {
		// Create a new listener
		ListenNotify ln = new ListenNotify();

		// Get the shared queue
		BlockingQueue queue = ln.getQueue();

		// Loop forever pulling messages off the queue
		while (true) {
			try {
				// queue blocks until something is placed on it
				String msg = (String) queue.take();

				// Do something with the event
				System.out.println(msg);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}