package archive;

import java.io.File;
import java.util.LinkedList;

public class BFSQueueScanner {

    private static void printDelimiters(int c) {
        for (int j = 0; j < c; j++)
            System.out.print("-");

    }

    public static void main(String[] args) {

        LinkedList<File> queue = new LinkedList<File>();
        File rootDir = new File("C:\\Music\\");
        queue.add(rootDir);
        int c = 0;
        while (!queue.isEmpty()) {
            File currentFolder = queue.getFirst();
            queue.removeFirst();
            String[] directories = currentFolder.list((current, name) -> new File(current, name).isDirectory());
            if (directories != null) {
                for (String directory : directories) {
                    printDelimiters(c);
                    System.out.println(directory);
                    queue.addLast(new File(currentFolder.getAbsolutePath() + "\\" + directory));
                }
            }
        }
    }
}
