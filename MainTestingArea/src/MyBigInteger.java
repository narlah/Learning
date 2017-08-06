

import java.util.ArrayList;

//import java.math.BigInteger;
class MyBigInteger {

    //storage
    private ArrayList<Integer> array = new ArrayList<Integer>();

    //Constructors 3
    public MyBigInteger(String s) {
        for (int i = 0; i < s.length(); i++) {
            array.add(Character.getNumericValue(s.charAt(i)));
        }
    }

    public MyBigInteger(Number number) {
        String s = number.toString();
        for (int i = 0; i < s.length(); i++) {
            array.add(Character.getNumericValue(s.charAt(i)));
        }
    }

    private MyBigInteger(int size, int fill) {
        for (int i = 0; i < size; i++) {
            array.add(fill);
        }
    }

    //behaviour
    public int size() {
        return array.size();
    }

    private int getIndex(int i) {
        return array.get(i);
    }

    private int setIndex(int i, int value) {
        return array.set(i, value);
    }

    public String toString() {
        StringBuilder strB = new StringBuilder();

        //for (Iterator<Integer> iterator = array.iterator(); iterator.hasNext();) {
        //strB.append(iterator.next());
        int flag = 0;
        while (array.get(flag) == 0) {
            flag++;
        }
        for (int i = flag; i < array.size(); i++) {
            strB.append(array.get(i));
        }

        return strB.toString();
    }

    //-----------------------------------------------------------------------------
    private void carryNumber(int index, int carry, MyBigInteger result) {
        int multPlus, singlePlus;
        do {
            multPlus = carry + result.getIndex(index);
            if (multPlus > 9 && index >= 0) {
                singlePlus = multPlus % 10;
                carry = (multPlus - singlePlus) / 10;
                result.setIndex(index, singlePlus);
                index--;
            } else {
                result.setIndex(index, multPlus);
                break;
            }
        } while (true);

    }

    public MyBigInteger adition(MyBigInteger second) {
        int secondSize = second.size();
        int localSize = array.size();
        MyBigInteger result = new MyBigInteger(Math.max(secondSize, localSize) + 1, 0);
        int index = result.size();

        for (int i = index - 2; i >= 0; i--) {
            int addFirst = 0;
            if (localSize > i) {
                addFirst = array.get(i);
            }
            int addSecond = 0;
            if (secondSize > i) {
                addSecond = second.getIndex(i);
            }
            int carry = (addFirst + addSecond);
            carryNumber(i + 1, carry, result);
        }
        return result;
    }

    public MyBigInteger multiply(MyBigInteger second) {
        int secondSize = second.size();
        int localSize = array.size();
        MyBigInteger result = new MyBigInteger(secondSize + localSize, 0);
        int index = result.size();
        for (int i = localSize - 1; i >= 0; i--) {
            int multiplyFirst = array.get(i);
            int indexSecond = --index;
            for (int j = secondSize - 1; j >= 0; j--) {
                int multiplySecond = second.getIndex(j);
                int carry = (multiplyFirst * multiplySecond);
                carryNumber(indexSecond, carry, result);
                indexSecond--;
            }
        }
        return result;
    }

}
//MyBigInteger myFirst = new MyBigInteger(99999); //132 //27675
//MyBigInteger mySecond= new MyBigInteger(112);
//System.out.println(myFirst.multiply(mySecond).toString());