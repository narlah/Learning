package archive;

import java.util.Stack;

public class BracketValidator {
    private static final String textToValidate = "{ [ ](  ) |}|";

    public static void main(String[] args) {
        boolean flag = true;
        Stack<Character> stack = new Stack<Character>();
        for (char c : textToValidate.toCharArray()) {
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
                default:
                    System.out.println("Skipping this char, irrelevant for this checking : '" + c + "'");
                    break;
            }
        }
        System.out.println(stack.isEmpty());
    }
}
