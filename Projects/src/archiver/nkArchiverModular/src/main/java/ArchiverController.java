import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;

class ArchiverController {

    private Compressor compressor;

    private String compressorName;
    private String inFile;
    private String outFile;

    void changeCompressor(String compressorNameNew) {
        if (!this.compressorName.equals(compressorNameNew)) {
            this.compressorName = compressorNameNew;
            compressor = null;
        }
    }

    void compress() throws IllegalArgumentException, IOException {
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

    String getInFile() {
        return inFile;
    }

    /**
     * @param inFile the inFile to set
     */
    void setInFile(String inFile) {
        this.inFile = inFile;
    }

    /**
     * @param extention File Extention
     */
    String updateOutFileExtention(String extention) {
        if (outFile != null) {
            outFile = outFile.substring(0, outFile.lastIndexOf('.')) + "." + extention;
        }
        return outFile;
    }

    public String getOutFile() {
        return outFile;
    }

    String setOutFileFromIn(String inFileFullPath) {
        Path p = Paths.get(inFileFullPath);
        Path folder = p.getParent();
        String InFileName = p.getFileName().toString();
        int pos = InFileName.lastIndexOf(".");
        String newName = folder + InFileName.substring(0, pos) + ".nik";
        this.outFile = newName;
        return newName;
    }

    HashMap<?, ?> getDataStructure() {
        return compressor.getDataStructure();

    }

    String getCompressorName() {
        return compressorName;
    }

    /**
     * @param compressorName the compressorName to set
     */
    void setCompressorName(String compressorName) {
        this.compressorName = compressorName;
    }
}
