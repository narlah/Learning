package interviewPickings.testDome;

public class Username {
    public static boolean validate(String username) {
        //return username.matches("^[A-Za-z][a-zA-Z0-9.]*-?[a-zA-Z0-9.][^-$]{6,16}$"); //*[]
        return username.matches("^(?=.{6,16}$)[a-zA-Z][a-zA-Z\\d]*-?[A-Za-z\\d]+$"); //correct one
    }

    public static void main(String[] args) {
        System.out.println(validate("Mike-Standish")); // Valid username
        System.out.println(validate("Mike--Standish"));
        System.out.println(validate("Mike-Standish-"));
        System.out.println(validate("Mike"));
        System.out.println(validate("Aabcde"));
        System.out.println(validate("1Aabcde"));
        System.out.println(validate("Mikeaaaaaaaaaaaaaaaaaaazzzzaaaaaaa"));
        System.out.println(validate("M123zkl-"));
        System.out.println(validate("M123-zkl"));
        System.out.println(validate("Mike Standish"));
    }
}