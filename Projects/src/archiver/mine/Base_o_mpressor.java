package archiver.mine;

public abstract class Base_o_mpressor {
	protected String inFile;
	protected String outFile;

	public String getInFileName() {
		return String.valueOf(inFile); // defensive copy
	}

	public String getOutFileName() {
		return String.valueOf(outFile); // defensive copy
	}

	public abstract String toString(); // provide more information about the
										// type of the compression used
}
