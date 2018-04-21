package interviewPickings;

public class CountAndSay {
    public static void main(String[] args) {
        CountAndSay a = new CountAndSay();
        System.out.println(a.countAndSay(15));
    }

    public String countAndSay(int n) {
        String currentResult = "1";
        for (int i = 0; i < n - 1; i++) {
            currentResult = countAndSayDecode(currentResult);
        }
        return currentResult;
    }

    public String countAndSayDecode(String string) {
        if (string.isEmpty())
            return "";
        StringBuilder outString = new StringBuilder();
        Character currentChar = string.charAt(0);
        int currentCount = 1;
        int currentIndex = 0;
        while (currentIndex <= string.length() - 1) {
            if (currentIndex == string.length() - 1) {
                outString.append(currentCount).append("").append(currentChar);
                break;
            }
            char c = string.charAt(currentIndex + 1);
            if (c == currentChar) {
                currentCount++;
            } else {
                outString.append(currentCount).append("").append(currentChar);
                currentCount = 1;
                currentChar = c;
            }
            currentIndex++;
        }
        return outString.toString();
    }
}
