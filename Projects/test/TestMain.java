import java.io.File;
import junit.framework.TestCase;

public class TestMain extends TestCase {
	public void testCompresDecompress() {
		File source = new File("Shakespeare.txt");
		File compressed = new File("Shakespeare.out");
		File compressedParallel = new File("Shakespeare.p.out");
		File decompressed = new File("Shakespeare_out.txt");
		File decompressedParallel = new File("Shakespeare_out.p.txt");

		assertTrue(source.exists());
		compressed.delete();
		decompressed.delete();
		compressedParallel.delete();
		decompressedParallel.delete();
		try {
			Main.compress(source, compressed);
			Main.compressParallel(2, source, compressedParallel);
			Main.compressParallel(3, source, compressedParallel);
			Main.compressParallel(4, source, compressedParallel);
			Main.compressParallel(8, source, compressedParallel);
			Main.decompress(compressed, decompressed);
			Main.decompress(compressedParallel, decompressedParallel);

			// check content of files
		} finally {
			// compressed.delete();
			// decompressed.delete();
			// compressedParallel.delete();
			// decompressedParallel.delete();
		}
	}
}
