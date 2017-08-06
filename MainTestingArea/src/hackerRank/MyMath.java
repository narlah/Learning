package hackerRank;

import java.io.*;
import java.util.*;

interface PerformOperation {
    boolean check(int a);
}

class MyMath {
    static boolean checker(PerformOperation p, int num) {
        return p.check(num);
    }

    PerformOperation is_odd() {
        return new PerformOperation() {
            @Override
            public boolean check(int a) {
                return a % 2 != 0;
            }
        };
    }

    PerformOperation is_prime() {
        return new PerformOperation() {
            @Override
            public boolean check(int a) {
                if (a==2) return true;
                if (a%2==0) return false;
                for(int i=3;i*i<=a;i+=2) {
                    if(a%i==0)
                        return false;
                }
                return true;
            }
        };
    }

    PerformOperation is_palindrome() {
        return new PerformOperation() {
            @Override
            public boolean check(int a) {
                char[] charArray = Integer.toString(a).toCharArray();
                int length = charArray.length;
                if (length==0) return true;
                for (int i =0;i<length/2;i++){
                    if (charArray[i]!=charArray[length-1-i]) return false;
                }
                return true;
            }
        };
    }
}
// Write your code here


class Solution {

    public static void main(String[] args) throws IOException {
        MyMath ob = new MyMath();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        PerformOperation op;
        boolean ret = false;
        String ans = null;
        while (T-- > 0) {
            String s = br.readLine().trim();
            StringTokenizer st = new StringTokenizer(s);
            int ch = Integer.parseInt(st.nextToken());
            int num = Integer.parseInt(st.nextToken());
            if (ch == 1) {
                op = ob.is_odd();
                ret = MyMath.checker(op, num);
                ans = (ret) ? "ODD" : "EVEN";
            } else if (ch == 2) {
                op = ob.is_prime();
                ret = MyMath.checker(op, num);
                ans = (ret) ? "PRIME" : "COMPOSITE";
            } else if (ch == 3) {
                op = ob.is_palindrome();
                ret = MyMath.checker(op, num);
                ans = (ret) ? "PALINDROME" : "NOT PALINDROME";

            }
            System.out.println(ans);
        }
    }
}