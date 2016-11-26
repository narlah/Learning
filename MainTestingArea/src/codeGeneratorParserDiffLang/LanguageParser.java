package codeGeneratorParserDiffLang;

public abstract class LanguageParser {
    public String receiveLine(char Flag, String line) {
        switch (Flag) {
            case ('#'): {
                return generateComment(line);
            }
            case ('M'): {
                return generateMessageStart(line);
            }

            case ('F'): {
                return generateField(line);
            }

            case ('E'): {
                return generateMessageEnd();
            }
            default:
                return "ungenerated" + Flag + line;
        }
    }

    abstract String generateComment(String line);

    abstract String generateMessageStart(String line);

    abstract String generateMessageEnd();

    abstract String generateField(String line);
}
