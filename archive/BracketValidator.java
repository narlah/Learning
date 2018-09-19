package archive;

import java.util.Stack;

public class BracketValidator {
    private static final String textToValidate = "{ [ ]( a{}} ) |}|";

    public static void main(String[] args) {
        boolean flag = true;
        Stack<Character> stack = new Stack<Character>();
        for (char c : textToValidate.toCharArray()) {
            if (!flag) {
                System.out.println("Not valid!");
                return;
            }
            switch (c) {
                case '{':
                case '[':
                case '(':
                    stack.push(c);
                    break;

                case '}':
                    if (stack.isEmpty() || stack.pop() != '{')
                        flag = false;
                    break;
                case ']':
                    if (stack.isEmpty() || stack.pop() != '[')
                        flag = false;
                    break;
                case ')':
                    if (stack.isEmpty() || stack.pop() != '(')
                        flag = false;
                    break;
//                default:
//                    System.out.println("Skipping this char, irrelevant for this checking : '" + c + "'");
//                    break;
            }
        }
        System.out.println(stack.isEmpty() ? "Valid!" : "NOT Valid!");
    }
}
