package codeGeneratorParserDiffLang;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class BatchProcessorTest {
	private static String dir = "c:\\Programing\\";

	public static void main(String[] args) throws FileNotFoundException, IOException {
		parseLanguage("Java", new JavaParser());
		parseLanguage("C", new CParser());
	}

	private static void parseLanguage(String Language, LanguageParser parser) throws IOException {
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
