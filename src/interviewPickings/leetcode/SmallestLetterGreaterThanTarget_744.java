package interviewPickings.leetcode;

public class SmallestLetterGreaterThanTarget_744 {
    public static void main(String[] args) {
        SmallestLetterGreaterThanTarget_744 sm = new SmallestLetterGreaterThanTarget_744();
        char[] c = new char[]{'c', 'f', 'j'};
        System.out.println("Should be 'c' and is : " + sm.nextGreatestLetter(c, 'a'));
        System.out.println("Should be 'j' and is : " + sm.nextGreatestLetter(c, 'g'));
        System.out.println("Should be 'c' and is : " + sm.nextGreatestLetter(c, 'k'));
        System.out.println("Should be 'f' and is : " + sm.nextGreatestLetter(c, 'd'));
        System.out.println("Should be 'b' and is : " + sm.nextGreatestLetter("aaaaaaabbbbbbbbbbccccccccccccccccccccccccccccccccccccccccccccccccccd".toCharArray(), 'c'));

    }

    public char nextGreatestLetter(char[] letters, char target) {
        int lo = 0, hi = letters.length;
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (letters[mid] <= target) lo = mid+1;
            else
                hi = mid;
        }
        return letters[lo % letters.length];
    }

}
