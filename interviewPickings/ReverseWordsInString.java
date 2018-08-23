package interviewPickings;

import java.util.StringTokenizer;

public class ReverseWordsInString {
    public static void main(String[] args) {
        ReverseWordsInString r = new ReverseWordsInString();
        System.out.println(r.reverseWordsInString("баба яга бързо бяга хейййй 1231! 50 бири"));

    }

    private String reverseWordsInString(String in) {
        StringTokenizer s = new StringTokenizer(in, " ");
        StringBuilder res = new StringBuilder();
        while (s.hasMoreTokens()) {
            res.append(reverseString(s.nextToken())).append(" ");
        }
        return reverseString(res.toString());
    }

    private String reverseString(String in) {
        return new StringBuilder(in).reverse().toString();
        //        int begin = 0, end = in.length()-1;
//        char[] chars = in.toCharArray();
//
//        while (begin<end){
//            char tmp = chars[begin];
//            chars[begin] = chars[end];
//            chars[end]= tmp;
//            begin++;
//            end--;
//        }
//        return new String(chars);
    }

}
