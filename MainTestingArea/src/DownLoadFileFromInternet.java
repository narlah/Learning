import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;

public class DownLoadFileFromInternet {
    public static void main(String[] args) throws IOException {
        URL website = new URL("http://www.saab-club.com/forum/search.php");
        ReadableByteChannel rbc = Channels.newChannel(website.openStream());
        FileOutputStream fos = new FileOutputStream("c:\\search.html");
        fos.getChannel().transferFrom(rbc, 0, Long.MAX_VALUE);
    }

}
