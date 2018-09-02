package interviewPickings.codeFights;

import java.util.Stack;

public class SimplifyPath {
    public static void main(String[] args) {
        SimplifyPath ss = new SimplifyPath();
        System.out.println(ss.simplifyPath("/////..///K/BruP/RMplU/././"));

    }

    String simplifyPath(String path) {
        Stack<String> stack = new Stack<>();
        String[] arr = path.split("/");
        for (String p : arr) {
            if (p.equals("."))
                continue;
            if (p.equals("..")) {
                if (stack.size() > 0)
                    stack.pop();
                continue;
            }
            if (p.length() < 1)
                continue;
            stack.push(p);
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < stack.size(); i++) {
            sb.append("/").append(stack.get(i));
        }
        if (sb.length() == 0)
            sb.append("/");
        return sb.toString();
    }


}
