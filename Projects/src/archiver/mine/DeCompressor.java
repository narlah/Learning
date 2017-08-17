package archiver.mine;

import java.io.IOException;

public abstract class DeCompressor extends Base_o_mpressor {

	public DeCompressor(String inFile, String outFile) {
		this.inFile = inFile;
		this.outFile = outFile;
	}

	public abstract void decode() throws IOException;
}
