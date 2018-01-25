package interviewPickings.leetcode;

import java.util.Arrays;
import java.util.PriorityQueue;

public class ReorganizeString_767 {
    public static void main(String[] args) {
        ReorganizeString_767 reorg = new ReorganizeString_767();
        System.out.println(reorg.reorganizeStringSolution("aaaaaaaaaaaaaaaabbbbbccccczzzzz"));
        System.out.println(reorg.reorganizeStringHeap("aaaaaaaaaaaaaaaabbbbbccccczzzzz"));
        System.out.println(reorg.reorganizeString("aaaaaaaaaaaaaaaabbbbbccccczzzzz"));
        System.out.println(reorg.reorganizeStringMyHeap("aaab"));
    }


    public String reorganizeString(String S) {
        int N = S.length();
        int[] alphabet = new int[26];
        for (char c : S.toCharArray()) alphabet[c - 'a'] += 100;
        for (int i = 0; i <= 25; i++) alphabet[i] += i;
        Arrays.sort(alphabet);
        char[] ans = new char[N];

        int t = 1;
        for (int i = 0; i <= 25; i++) {
            int occurrences = alphabet[i] / 100;
            char ch = (char) (alphabet[i] % 100 + 'a');
            if (occurrences > (N + 1) / 2) return "";
            for (int j = 0; j < occurrences; j++) {
                if (t >= N) t = 0;
                ans[t] = ch;
                t += 2;
            }
        }
        return String.valueOf(ans);
    }

    public String reorganizeStringMyHeap(String S) {
        int N = S.length();
        int[] count = new int[26];
        for (char c : S.toCharArray()) count[c - 'a']++;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[1] - a[1]);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i <= 25; i++) {
            if (count[i]> ((N+1)/2)) return "";
            if (count[i] > 0)
                pq.add(new int[]{i + 'a', count[i]});
        }
        while (!pq.isEmpty()) {
            int[] f = pq.poll();
            char c = (char) f[0];
            if (sb.length() == 0 || sb.charAt(sb.length() - 1) != c) {
                sb.append(c);
                if (--f[1]>0)
                    pq.add(f);
            } else {
                int[] s = pq.poll();
                sb.append((char) s[0]);
                if (--s[1]>0)
                    pq.add(s);
                pq.add(f);
            }
        }
        return sb.toString();
    }


    public String reorganizeStringSolution(String S) {
        int N = S.length();
        int[] counts = new int[26];
        for (char c : S.toCharArray()) counts[c - 'a'] += 100;
        for (int i = 0; i < 26; ++i) counts[i] += i;
        //Encoded counts[i] = 100*(actual count) + (i)
        Arrays.sort(counts);

        char[] ans = new char[N];
        int t = 1;
        for (int code : counts) {
            int ct = code / 100;
            char ch = (char) ('a' + (code % 100));
            if (ct > (N + 1) / 2) return "";
            for (int i = 0; i < ct; ++i) {
                if (t >= N) t = 0;
                ans[t] = ch;
                t += 2;
            }
        }
        return String.valueOf(ans);
    }

    public String reorganizeStringHeap(String S) {
        int N = S.length();
        int[] count = new int[26];
        for (char c : S.toCharArray()) count[c - 'a']++;
        PriorityQueue<MultiChar> pq = new PriorityQueue<>((a, b) ->
                a.count == b.count ? a.letter - b.letter : b.count - a.count);

        for (int i = 0; i < 26; ++i)
            if (count[i] > 0) {
                if (count[i] > (N + 1) / 2) return "";
                pq.add(new MultiChar(count[i], (char) ('a' + i)));
            }

        StringBuilder ans = new StringBuilder();
        while (pq.size() >= 2) {
            MultiChar mc1 = pq.poll();
            MultiChar mc2 = pq.poll();
            if (ans.length() == 0 || mc1.letter != ans.charAt(ans.length() - 1)) {
                ans.append(mc1.letter);
                ans.append(mc2.letter);
                if (--mc1.count > 0) pq.add(mc1);
                if (--mc2.count > 0) pq.add(mc2);
            }
        }

        if (pq.size() > 0) ans.append(pq.poll().letter);
        return ans.toString();
    }

    class MultiChar {
        int count;
        char letter;

        MultiChar(int ct, char ch) {
            count = ct;
            letter = ch;
        }
    }
}
