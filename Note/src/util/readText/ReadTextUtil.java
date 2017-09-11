package util.readText;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ReadTextUtil {
	public StringBuffer readText(String textFilePath) {
		StringBuffer strBuffer = new StringBuffer();

		BufferedReader in = null;
		try {
			in = new BufferedReader(new FileReader(textFilePath));
			String s;
			while ((s = in.readLine()) != null) {
				strBuffer.append(s);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				in.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		return strBuffer;
	}
}
