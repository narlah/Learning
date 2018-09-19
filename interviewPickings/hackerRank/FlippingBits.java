package interviewPickings.hackerRank;

public class FlippingBits {
    static long flippingBits(long n) {
        //return ~n + 0x0000000100000000L;
        //return n^ 0xFFFFFFFFL;
        //return 0x00000000FFFFFFFF&(int)(~n);
        return n ^ (((long) Integer.MAX_VALUE << 1) + 1);
    }

    public static void main(String[] args) {
        System.out.println(flippingBits(2147483647));
    }
}


/*
2147483647
1
0

expected:
2147483648
4294967294
4294967295

actual:
0
4294967292
4294967294
 */