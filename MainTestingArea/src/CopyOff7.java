
public class CopyOff7 {
    // ***************************f6**********************************

    // ***************************f6**********************************
    public static void main(String[] args) {
        // ***************************f6**********************************
        String s1 = new String("abc");
        s1.intern();
        String s2 = "abc";
        String s3 = new String("abc");
        s3.intern();
        String temp = "c";
        String s4 = "ab" + temp;
        String s5 = s4.intern();

        System.out.println(s2 == "abc");
        System.out.println(s2 == s4);
        System.out.println(s1 == s3);
        System.out.println(s1 == s4);
        System.out.println(s3 == s4);
        System.out.println(s5 == s2);

        // ***************************************************************
    }

}