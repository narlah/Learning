package network;

import java.io.*;
import java.net.Socket;

public class FileClient {

	public static void main(String[] args) throws IOException {
		Socket socket;
		String host = "127.0.0.1";
		final int PORT = 4412;
		File file = new File("c:\\test.xml");
		byte[] b = new byte[1024];
		int count;
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
