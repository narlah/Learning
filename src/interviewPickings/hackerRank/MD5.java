package interviewPickings.hackerRank;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

public class MD5 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String myString = scanner.next();

        scanner.close();
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            //MessageDigest md = MessageDigest.getInstance("SHA-256");
            md.update(myString.getBytes());
            byte[] digest = md.digest();
            for (byte b : digest) {
                System.out.printf("%02x", b);
            }


        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }


    }
}
