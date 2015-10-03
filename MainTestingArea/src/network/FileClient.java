package network;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.Socket;

public class FileClient {

	/**
	 * @param args
	 *            the command line arguments
	 */
	public static void main(String[] args) throws IOException {
		Socket socket = null;
		String host = "127.0.0.1";
		final int PORT = 4412;
		File file = new File("c:\\test.xml");
		byte[] b = new byte[1024];
		int count = 0;
		socket = new Socket(host, PORT);
		BufferedOutputStream bfo = new BufferedOutputStream(socket.getOutputStream());
		BufferedInputStream bfi = new BufferedInputStream(new FileInputStream(file));
		while ((count = bfi.read(b)) > 0) {
			bfo.write(b, 0, count);
		}
		bfo.flush();
		bfi.close();
		socket.close();

	}

}
