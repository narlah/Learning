package codeGeneratorParserDiffLang;

import java.io.*;

public class BatchProcessorTest {

    public static void main(String[] args) throws IOException {
        parseLanguage("Java", new JavaParser());
        parseLanguage("C", new CParser());
    }

    private static void parseLanguage(String Language, LanguageParser parser) throws IOException {
        String dir = "c:\\Programing\\";
        BufferedReader br = new BufferedReader(new FileReader(new File(dir + "generateThis.txt")));
        BufferedWriter wr = new BufferedWriter(new FileWriter(new File(dir + Language + ".txt")));

        try {
            String line = br.readLine();
            while (line != null) {
                char Flag = line.charAt(0);
                String substringLine = line.substring(1, line.length());
                wr.write(parser.receiveLine(Flag, substringLine) + "\n");
                line = br.readLine();
            }
        } finally {
            if (br.ready()) {
                br.close();
            }
            wr.flush();
            wr.close();
        }
    }
}
