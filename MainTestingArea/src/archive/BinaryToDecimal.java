package archive;

public class BinaryToDecimal {

    public static void main(String a[]) {
        BinaryToDecimal bd = new BinaryToDecimal();
        System.out.println("11 ===> " + bd.getDecimalFromBinary(11));
        System.out.println("110 ===> " + bd.getDecimalFromBinary(110));
        System.out.println("100110011 ===> " + bd.getDecimalFromBinary(100110101));
    }

    public int getDecimalFromBinary(int binary) {

        int decimal = 0;
        int power = 0;
        while (true) {
            if (binary == 0) {
                break;
            } else {
                int tmp = binary % 10;
                decimal += tmp * Math.pow(2, power);
                System.out.println(decimal + " " + tmp + " " + Math.pow(2, power) * tmp);
                binary = binary / 10;
                power++;
            }
        }
        return decimal;
    }
}
