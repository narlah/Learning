package archive;
//import java.util.Arrays;

public class ReturnBackwards {
    private static int returnBackwards(int forward) {
        String str = Integer.toString(forward);
        StringBuilder build = new StringBuilder();
        for (int i = str.length() - 1; i >= 0; i--) {
            build.append(str.charAt(i));
        }

        return new Integer(build.toString());
    }

    public static void main(String[] args) {
        // ***************************f6**********************************
        int forward = 123456;
        System.out.println("Backwards of " + forward + " is : " + returnBackwards(forward));
        // ***************************************************************
    }

}
