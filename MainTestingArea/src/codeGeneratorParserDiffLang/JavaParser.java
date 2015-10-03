package codeGeneratorParserDiffLang;

import java.util.StringTokenizer;

public class JavaParser extends LanguageParser {

	@Override
	String generateComment(String line) {
		return "# " + line;
	}

	@Override
	String generateMessageStart(String className) {
		return "public class " + className + "Msg {";
	}

	@Override
	String generateMessageEnd() {
		return "}";
	}

	@Override
	String generateField(String line) {
		StringTokenizer tokenizerLine = new StringTokenizer(line);
		String fieldName = tokenizerLine.nextToken();
		String fieldType = tokenizerLine.nextToken();
		return "	" + fieldType + " " + fieldName + ";";
	}

}
