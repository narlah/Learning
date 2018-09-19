package interviewPickings.codeFights;

import java.util.*;

public class DNASequenceRollingHash {
    public static void main(String[] args) {
        DNASequenceRollingHash dna = new DNASequenceRollingHash();
        System.out.println(Arrays.toString(dna.repeatedDNASequences("AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT")));
    }

    String[] repeatedDNASequences(String s) {
        long[] ppow = new long[]{1,7,49,343,2401,16807,117649, 823543, 5764801, 40353607};
        char[] arr = s.toCharArray();
        int k = arr.length;
        if (k <= 10)
            return new String[]{};
        HashMap<Long, String> map = new HashMap<>();
        HashSet<String> set = new HashSet<>();
        long currentHash = 0;
        StringBuilder strBld = new StringBuilder();
        for (int i = 0; i < 10; i++) {
            currentHash += ppow[i] * arr[i];
            strBld.append(arr[i]);
        }
        map.put(currentHash, strBld.toString());
        int c = 10;
        while (c < k) {
            currentHash = (currentHash - strBld.charAt(0)) / 7;
            currentHash += ppow[9]*arr[c];
            strBld.deleteCharAt(0).append(arr[c]);
            c++;
            if (set.contains(currentHash))
                continue;
            if (map.containsKey(currentHash)){
                set.add(strBld.toString());
            } else
                map.put(currentHash, strBld.toString());
        }
        String[] res = new String[set.size()];
        set.toArray(res);
        Arrays.sort(res);
        return res;
    }

}
