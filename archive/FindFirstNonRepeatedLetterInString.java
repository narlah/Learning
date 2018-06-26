package archive;

import java.util.LinkedHashMap;
import java.util.Map.Entry;

public class FindFirstNonRepeatedLetterInString {
    public static char getFirstNonRepeatedChar(String inputStr) {
        LinkedHashMap<Character, Integer> linkedHashMap = new LinkedHashMap<Character, Integer>();
        for (int i = 0; i < inputStr.length(); i++) {
            char c = inputStr.charAt(i);
            linkedHashMap.put(c, linkedHashMap.containsKey(c) ? linkedHashMap.get(c) + 1 : 1);
        }
        for (Entry<Character, Integer> entry : linkedHashMap.entrySet()) {
            if (entry.getValue() == 1) {
                return entry.getKey();
            }
        }
        return new Character('@');
    }

    public static void main(String[] args) {
        System.out.println(getFirstNonRepeatedChar("this is lovelv h k   m!tko me!"));

    }

}
