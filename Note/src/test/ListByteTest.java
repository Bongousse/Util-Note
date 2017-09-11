package test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class ListByteTest {
	@SuppressWarnings({ "unchecked" })
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		List<UiHttpHeaderItem> list = new ArrayList<UiHttpHeaderItem>();

		UiHttpHeaderItem a = new UiHttpHeaderItem();
		a.setKey("A");
		a.setValue("B");

		UiHttpHeaderItem b = new UiHttpHeaderItem();
		b.setKey("C");
		b.setValue("D");
		list.add(a);
		list.add(b);
		byte[] yourBytes = null;

		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		ObjectOutput out = null;
		try {
			out = new ObjectOutputStream(bos);
			out.writeObject(list);
			out.flush();
			yourBytes = bos.toByteArray();
		} finally {
			try {
				bos.close();
			} catch (IOException ex) {
				// ignore close exception
			}
		}

		ByteArrayInputStream bis = new ByteArrayInputStream(yourBytes);
		ObjectInput in = null;
		try {
			in = new ObjectInputStream(bis);
			Object o = in.readObject();

			List<UiHttpHeaderItem> l = (ArrayList<UiHttpHeaderItem>) o;
			for (UiHttpHeaderItem item : l) {
				System.out.println(item);
			}
		} finally {
			try {
				if (in != null) {
					in.close();
				}
			} catch (IOException ex) {
				// ignore close exception
			}
		}
	}
}
