package archive;

import java.io.*;
import java.util.*;
import java.util.Map.Entry;

public class MaxDuplicatedWordCount {

    public static void main(String a[]) {
        MaxDuplicatedWordCount mdc = new MaxDuplicatedWordCount();
        Map<String, Integer> wordMap = mdc.getWordCount("C:/MyTestFile.txt");
        List<Entry<String, Integer>> list = mdc.sortByValue(wordMap);
        for (Map.Entry<String, Integer> entry : list) {
            System.out.println(entry.getKey() + " ==== " + entry.getValue());
        }
    }

    private Map<String, Integer> getWordCount(String fileName) {

        FileInputStream fis;
        DataInputStream dis;
        BufferedReader br = null;
        Map<String, Integer> wordMap = new HashMap<>();
        try {
            fis = new FileInputStream(fileName);
            dis = new DataInputStream(fis);
            br = new BufferedReader(new InputStreamReader(dis));
            String line;
            while ((line = br.readLine()) != null) {
                StringTokenizer st = new StringTokenizer(line, " ");
                while (st.hasMoreTokens()) {
                    String tmp = st.nextToken().toLowerCase();
                    if (wordMap.containsKey(tmp)) {
                        wordMap.put(tmp, wordMap.get(tmp) + 1);
                    } else {
                        wordMap.put(tmp, 1);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (br != null)
                    br.close();
            } catch (Exception ignored) {
            }
        }
        return wordMap;
    }

    private List<Entry<String, Integer>> sortByValue(Map<String, Integer> wordMap) {

        Set<Entry<String, Integer>> set = wordMap.entrySet();
        List<Entry<String, Integer>> list = new ArrayList<>(set);
        list.sort((o1, o2) -> (o2.getValue()).compareTo(o1.getValue()));
        return list;
    }
}
