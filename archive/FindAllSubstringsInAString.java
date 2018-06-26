package archive;
//import java.util.Arrays;
//import java.math.BigInteger;

public class FindAllSubstringsInAString {

    public static void main(String[] args) {
        // ***************************f6**********************************
        String str =
                "We are living in a yellow submarine. We don't have anything else. Inside the submarine is very tight. So we are drinking all the day. We will move out of it in 5 days.".toLowerCase();
        String searchFor = "in";
        int index = 0;
        int count = 0;
        while (index < str.length()) {
            int pos = str.substring(index).indexOf(searchFor);
            if (pos != -1) {
                count++;
                index = pos + index + searchFor.length();
            } else {
                break;
            }
        }
        System.out.println("Times seen : " + count);
    }

    // ***************************************************************
}

// ***************************************************************

// ***************************************************************
