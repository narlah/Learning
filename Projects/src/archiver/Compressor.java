package archiver;

import java.io.IOException;
import java.util.HashMap;

public abstract class Compressor extends Base_o_mpressor {

	public Compressor(String inFile, String outFile) {
		this.inFile = inFile;
		this.outFile = outFile;
	}

	public abstract void encode() throws IOException;
	public abstract HashMap<?,?> getDataStructure();
}
