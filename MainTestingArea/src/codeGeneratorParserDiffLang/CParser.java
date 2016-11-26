package codeGeneratorParserDiffLang;

import java.util.StringTokenizer;

public class CParser extends LanguageParser {
    private String structName;

    @Override
    String generateComment(String line) {
        return "/*  " + line + "*/";
    }

    @Override
    String generateMessageStart(String structName) {
        this.structName = structName;
        return "typedef struct { ";

    }

    @Override
    String generateMessageEnd() {
        return "}" + this.structName + "Msg";
    }

    @Override
    String generateField(String line) {
        StringTokenizer tokenizerLine = new StringTokenizer(line);
        String fieldName = tokenizerLine.nextToken();
        String fieldType = tokenizerLine.nextToken();
        return "	" + fieldType + " " + fieldName + ";";
    }

}
