package interviewPickings;

import java.util.HashMap;
import java.util.StringTokenizer;

/**
 * Created by n on 8/26/17.
 */
public class WordCloud {
    private HashMap<String, Integer> storageMap = new HashMap<>();

    public void clearCloud() {
        storageMap.clear();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (String keyWord : storageMap.keySet()) {
            sb.append(" " + keyWord + " : " + storageMap.get(keyWord) + "\n");
        }
        return "WordCloud{ \n" +
                sb.toString() +
                "} \n\n";
    }

    public void addTextToCloud(String text) {
        StringTokenizer tokenizer = new StringTokenizer(text, " \t\n\r\f,.:;?![]()-=+");
        String word;
        while (tokenizer.hasMoreElements()) {
            word = tokenizer.nextToken().toLowerCase();
            if (!storageMap.containsKey(word)) {
                storageMap.put(word, 1);
            } else {
                storageMap.put(word, storageMap.get(word) + 1);
            }
        }
    }

    public static void main(String[] args) {
        WordCloud wc = new WordCloud();
        String[] texts = {
                "We came, we saw, we conquered...then we ate Bill's (Mille-Feuille) cake.",
                "The bill came to five dollars.",
                "After beating the eggs, Dana read the next step:",
                "Add milk and eggs, then add flour and sugar."
        };
        for (String t : texts) {
            wc.addTextToCloud(t);
            System.out.println(wc.toString());
            wc.clearCloud();
        }
    }
}
