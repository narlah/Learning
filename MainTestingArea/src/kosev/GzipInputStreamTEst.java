package kosev;

import java.io.*;
import java.util.zip.GZIPOutputStream;

public class GzipInputStreamTEst {
    private final static int BUFFER_SIZE = 2048;

    public static void main(String[] args) {
        try {

            InputStream fis = new FileInputStream(new File("c:\\test.xml"));
            GZIPOutputStream gzip = new GZIPOutputStream(new FileOutputStream(new File("c:\\test.zip")));

            byte[] b = new byte[BUFFER_SIZE];
            int count;
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
