package interviewPickings.codeFights;

import java.util.Stack;

public class DecodeString {
    public static void main(String[] args) {
        DecodeString ds = new DecodeString();
        System.out.println(ds.decodeString("sd2[f2[e]g]i"));
        //s: "3[a]2[b2[z]c]"
    }

    String decodeString(String s) {
        char[] cArr = s.toCharArray();
        Stack<String> st = new Stack<>();
        int i = 0;
        while (i < cArr.length) {
            if (Character.isDigit(cArr[i])) {
                String z = "";
                while (i < cArr.length && Character.isDigit(cArr[i])) {
                    z += cArr[i];
                    i++;
                }
                st.push(z);
                continue;
            }
            if (cArr[i] == '[') {
                st.push(cArr[i] + "");
                i++;
                continue;
            }
            if (Character.isAlphabetic(cArr[i])) {
                String z = "";
                while (i < cArr.length && Character.isAlphabetic(cArr[i])) {
                    z += cArr[i];
                    i++;
                }
                if (i < cArr.length && st.size() > 0 && Character.isAlphabetic(st.peek().charAt(0))) {
                    z = st.pop() + z;
                }
                st.push(z);
                continue;
            }
            if (cArr[i] == ']') {
                String sb = "";
                String val = st.pop();
                st.pop();
                int times = Integer.valueOf(st.pop());
                for (int j = 0; j < times; j++) {
                    sb += val;
                }
                while (st.size() > 0 && Character.isAlphabetic(st.peek().charAt(0))) {
                    sb = st.pop() + sb;
                }
                st.push(sb);
                i++;
            }

        }
        StringBuilder sb = new StringBuilder();
        for (int l = 0; l < st.size(); l++) {
            sb.append(st.get(l));
        }
        return sb.toString();
    }


    String decodeStringShal2Answer(String s) {
        Stack<Integer> intStack = new Stack();
        Stack<StringBuilder> strStack = new Stack();
        StringBuilder curr = new StringBuilder();
        int k = 0;

        for (char ch : s.toCharArray()) {
            if (Character.isDigit(ch)) {
                k = k * 10 + ch - '0';
            } else if (ch == '[') {
                intStack.push(k);
                strStack.push(curr);
                curr = new StringBuilder();
                k = 0;
            } else if (ch == ']') {
                StringBuilder tmp = curr;
                curr = strStack.pop();
                for (int i = intStack.pop(); i > 0; i--) {
                    curr.append(tmp);
                }
            } else {
                curr.append(ch);
            }
        }
        return curr.toString();
    }

}
