package archive;

import java.util.Stack;
import java.io.FilenameFilter;
import java.io.File;

public class DFSStackScanner {

	private static void printDelimiters(int c) {
		for (int j = 0; j < c; j++)
			System.out.print("-");

	}

	public static void main(String[] args) {

		Stack<File> queue = new Stack<File>();
		File rootDir = new File("C:\\Music\\");
		queue.add(rootDir);
		int c = 0;
		while (!queue.isEmpty()) {
			File currentFolder = queue.pop();
			String[] directories = currentFolder.list(new FilenameFilter() {
				@Override
				public boolean accept(File current, String name) {
					return new File(current, name).isDirectory();
				}
			});
			c++;
			if (directories != null) {
				for (int i = 0; i < directories.length; i++) {
					printDelimiters(c);
					System.out.println(directories[i]);
					queue.push(new File(currentFolder.getAbsolutePath() + "\\" + directories[i]));
				}
			}
		}
	}
}
