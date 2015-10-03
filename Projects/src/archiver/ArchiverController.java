package archiver;

import java.io.IOException;
import java.nio.file.Paths;
import java.nio.file.Path;
import java.util.HashMap;

public class ArchiverController {

	private Compressor compressor;

	private String compressorName;
	private String inFile;
	private String outFile;

	public void changeCompressor(String compressorNameNew) {
		if (!this.compressorName.equals(compressorNameNew)) {
			this.compressorName = compressorNameNew;
			compressor = null;
		}
	}

	public void compress() throws IllegalArgumentException, IOException {
		if (compressorName != null && inFile != null && outFile != null) {
			switch (compressorName) {
			case "Huffman":
				compressor = new HuffmanCompresor(inFile, outFile);
				break;
			case "GZiPStream":
				compressor = new GZipStreamCompresor(inFile, outFile);
				break;
			// case "SomethingOther":
			// compressor = new HuffmanCompresor();
			// break;

			default:
				compressor = new HuffmanCompresor(inFile, outFile);
				break;
			}
			compressor.encode();
		} else {
			throw new IllegalArgumentException("One is null -> Name : " + compressorName + " in " + inFile
					+ " or Out is " + outFile);
		}
	}

	/**
	 * @param compressorName
	 *            the compressorName to set
	 */
	public void setCompressorName(String compressorName) {
		this.compressorName = compressorName;
	}

	/**
	 * @param inFile
	 *            the inFile to set
	 */
	public void setInFile(String inFile) {
		this.inFile = inFile;
	}

	public String getInFile() {
		return inFile;
	}

	/**
	 * @param outFile
	 *            the outFile to set
	 */
	public String updateOutFileExtention(String extention) {
		if (outFile != null) {
			outFile = outFile.substring(0, outFile.lastIndexOf('.')) + "." + extention;
		}
		return outFile;
	}

	public String getOutFile() {
		return outFile;
	}

	public String setOutFileFromIn(String inFileFullPath) {
		Path p = Paths.get(inFileFullPath);
		Path folder = p.getParent();
		String InFileName = p.getFileName().toString();
		int pos = InFileName.lastIndexOf(".");
		String newName = folder + InFileName.substring(0, pos) + ".nik";
		this.outFile = newName;
		return newName;
	}

	public HashMap<?, ?> getDataStructure() {
		return compressor.getDataStructure();

	}

	public String getCompressorName() {
		return compressorName;
	}
}
