import java.io.*;
import java.util.*;
import java.util.regex.*;

class Spelling {
    //https://raelcunha.com/spell-correct/
    private final HashMap<String, Integer> nWords = new HashMap<String, Integer>();

    public Spelling(String file) throws IOException {
        BufferedReader in = new BufferedReader(new FileReader(file));
        Pattern p = Pattern.compile("\\w+");
        for (String temp = ""; temp != null; temp = in.readLine()) {
            Matcher m = p.matcher(temp.toLowerCase());
            while (m.find()) nWords.put((temp = m.group()), nWords.containsKey(temp) ? nWords.get(temp) + 1 : 1);
        }
        in.close();
    }

    private final ArrayList<String> edits(String word) {
        ArrayList<String> result = new ArrayList<String>();
        for (int i = 0; i < word.length(); ++i) result.add(word.substring(0, i) + word.substring(i + 1));
        for (int i = 0; i < word.length() - 1; ++i)
            result.add(word.substring(0, i) + word.substring(i + 1, i + 2) + word.substring(i, i + 1) + word.substring(i + 2));
        for (int i = 0; i < word.length(); ++i)
            for (char c = 'a'; c <= 'z'; ++c)
                result.add(word.substring(0, i) + String.valueOf(c) + word.substring(i + 1));
        for (int i = 0; i <= word.length(); ++i)
            for (char c = 'a'; c <= 'z'; ++c) result.add(word.substring(0, i) + String.valueOf(c) + word.substring(i));
        return result;
    }

    public final String correct(String word) {
        if (nWords.containsKey(word))
            return word;

        ArrayList<String> list = edits(word);

        HashMap<Integer, String> candidates = new HashMap<Integer, String>();

        for (String s : list) {
            if (nWords.containsKey(s))
                candidates.put(nWords.get(s), s);
        }

        if (candidates.size() > 0)
            return compilePossibilities(candidates);

        for (String s : list)
            for (String w : edits(s))
                if (nWords.containsKey(w))
                    candidates.put(nWords.get(w), w);

        //candidates.get(Collections.max(candidates.keySet()))
        return candidates.size() > 0 ? compilePossibilities(candidates) : word;
    }

    public String compilePossibilities(HashMap<Integer, String> candidates) {
        int n = 5;
        List<Integer> keySet = new ArrayList<>(candidates.keySet());
        Collections.sort(keySet);
        int size = keySet.size();
        int beginIndex = 0;
        if (size >= n) {
            beginIndex = size - n;
        }
        List<Integer> subList = keySet.subList(beginIndex, size);
        StringBuilder result = new StringBuilder();

        for (Integer key : subList) {
            result.append(candidates.get(key)).append(", ");
        }
        return result.toString();
    }

    public static void main(String args[]) throws IOException {
        String message = "Enter word:";

        Spelling spelling = new Spelling("big.txt");

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = "";
        while (!s.equals("exit")) {
            System.out.print(message);
            s = br.readLine();
            if (s.length() > 0) {
                System.out.println("Possible : " + spelling.correct(s));
            }
            System.out.println("-----");
        }
    }
}
