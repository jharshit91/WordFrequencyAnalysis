package FIleCreate;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;

public class OperatingSystemBasedTextFile {

	public static void main(String arg[]) throws IOException {
		String lineSeperator = System.getProperty("line.separator");
		Writer out = new BufferedWriter(new OutputStreamWriter(
				new FileOutputStream("Sample.txt"), "UTF-8"));
		try {
			out.write("a" + lineSeperator);

		} finally {
			out.close();
		}

	}

}
