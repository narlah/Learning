package archive;

public class LongestRun {
    public static int indexOfLongestRun(String str) {
        if (str.length() == 0) return -1;
        int currentMaxPositionIndex = 0;
        int currentMaxLenghtIndex = 0;

        int tmpPositionIndex = 0;
        int tmpLenght = 0;

        char[] charArray = str.toCharArray();
        char currentChar = charArray[0];

        for (int i = 0; i < charArray.length; i++) {
            if (i == (charArray.length - 1) && tmpPositionIndex < charArray.length - 1
                    && tmpLenght > currentMaxLenghtIndex) {
                currentMaxPositionIndex = tmpPositionIndex;
            }
            if (currentChar == charArray[i]) {
                tmpLenght++;
            } else {
                if (tmpLenght > currentMaxLenghtIndex) {
                    System.out.print(tmpLenght + " " + tmpPositionIndex + " " + currentChar + " -> " + charArray[i]);
                    currentMaxPositionIndex = tmpPositionIndex;
                    currentMaxLenghtIndex = tmpLenght;
                    System.out.println(" " + currentMaxLenghtIndex + " " + currentMaxPositionIndex);
                }
                tmpLenght = 1;
                tmpPositionIndex = i;
                currentChar = charArray[i];
            }
        }
        return currentMaxPositionIndex;
    }

    public static void main(String[] args) {
        // System.out.println(indexOfLongestRun("abbcccddddcccbba"));
        System.out.println(indexOfLongestRun("cccccccccc   zzzzzzzzzzzzzzzzzzzzzzzz a "));
    }
}