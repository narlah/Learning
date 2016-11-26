package junitLearning;

import archive.MyBigInteger;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestBigInteger {
    @Test
    public void testBigIntegerMultiply() {
        MyBigInteger smallestBigInteger = new MyBigInteger(1);
        MyBigInteger longBigInteger = new MyBigInteger("123456789123456789123456789123456789");
        MyBigInteger bigIntFirst = new MyBigInteger(123456789);
        MyBigInteger bigIntSecond = new MyBigInteger(987654321);

        String resultM = bigIntFirst.multiply(bigIntSecond).toString();
        //System.out.println(resultM);

        String resultA = bigIntFirst.adition(bigIntSecond).toString();
        //System.out.println(resultA);

        String resultSmallest = smallestBigInteger.adition(smallestBigInteger).toString();
        //System.out.println(resultSmallest);
        String resultLongest = longBigInteger.adition(longBigInteger).toString();
        //System.out.println(resultLongest);

        assertEquals("121932631112635269", resultM);
        assertEquals("1111111110", resultA);
        assertEquals("2", resultSmallest);
        assertEquals("246913578246913578246913578246913578", resultLongest);

    }
}