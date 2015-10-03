package network;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class FileServer {

	/**
	 * @param args
	 *            the command line arguments
	 */
	public static void main(String[] args) throws IOException {
		ServerSocket serverSocket = null;

		serverSocket = new ServerSocket(4412);
		serverSocket.setSoTimeout(3000);
		Socket localSocket = serverSocket.accept();

		File file = new File("c:\\test2.xml");
		BufferedOutputStream bof = new BufferedOutputStream(new FileOutputStream(file));
		InputStream is = localSocket.getInputStream();

		int count;
		int bufferSize = serverSocket.getReceiveBufferSize();
		byte[] b = new byte[bufferSize];

		while ((count = is.read(b)) > 0) {
			bof.write(b, 0, count);
		}

		serverSocket.close();
		bof.close();
	}

}
