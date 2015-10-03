package kosev;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.zip.GZIPOutputStream;

public class GzipInputStreamTEst {
	private final static int BUFFER_SIZE = 2048;

	public static void main(String[] args) {
		try {

			InputStream fis = new FileInputStream(new File("c:\\test.xml"));
			GZIPOutputStream gzip = new GZIPOutputStream(new FileOutputStream(new File("c:\\test.zip")));

			byte[] b = new byte[BUFFER_SIZE];
			int count = 0;
			while ((count = fis.read(b)) > 0) {
				gzip.write(b, 0, count);
			}
			fis.close();
			gzip.close();

		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
