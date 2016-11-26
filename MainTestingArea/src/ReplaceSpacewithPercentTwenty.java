public class ReplaceSpacewithPercentTwenty {

    public static void main(String[] args) {
        ReplaceSpacewithPercentTwenty main = new ReplaceSpacewithPercentTwenty();
        String in = "Mr John Smith    ";
        System.out.println(main.replaceSpaceWith20(in.toCharArray()));
    }

    private String replaceSpaceWith20(char[] ch) {
        int indexBackwards = ch.length - 1;
        int lettersStartFromThisPosition = ch.length - 1;
        for (int j = ch.length - 1; j > 0; j--) {
            if (Character.isAlphabetic(ch[j])) {
                lettersStartFromThisPosition = j;
                break;
            }
        }
        for (int i = lettersStartFromThisPosition; i > 0; i--) {
            if (Character.isAlphabetic(ch[i])) {
                ch[indexBackwards] = ch[i];
                indexBackwards--;

            } else if (ch[i] == ' ') {
                ch[--indexBackwards] = '0';
                ch[--indexBackwards] = '2';
                ch[--indexBackwards] = '%';
            }

        }
        return String.valueOf(ch);
    }
}
