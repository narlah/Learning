package interviewPickings.leetcode;

import java.util.Stack;

/**
 * Created by narlah on 3/2/18.
 */
public class ValidParentheses {
    public static void main(String[] args) {
        ValidParentheses v = new ValidParentheses();
        System.out.printf("should be false : %b\n", v.isValid("()(({}"));
        System.out.printf("should be false : %b\n", v.isValid(")("));
        System.out.printf("should be true : %b\n", v.isValid("({[]})"));
        System.out.printf("should be true : %b\n", v.isValid("[](){}"));

    }

    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            switch (c) {
                case '[':
                    stack.push(']');
                    break;
                case '{':
                    stack.push('}');
                    break;
                case '(':
                    stack.push(')');
                    break;

                case ']':
                case '}':
                case ')':
                    if (stack.isEmpty() || stack.pop() != c) return false;
            }

        }
        return stack.isEmpty();
    }
}
