package interviewPickings.codility;

public class Longest0SequenceInIntAsBinary {
    public static void main(String[] args) {
        Longest0SequenceInIntAsBinary loInB = new Longest0SequenceInIntAsBinary();
        int inty = 6;
        System.out.println(loInB.convertToBinary(inty) + " " + loInB.findLongestSequence(inty));
        inty = 76757;
        System.out.println(loInB.convertToBinary(inty) + " " + loInB.findLongestSequence(inty));
        inty = 89761;
        System.out.println(loInB.convertToBinary(inty) + " " + loInB.findLongestSequence(inty));
        inty = Integer.MAX_VALUE - 1;
        System.out.println(loInB.convertToBinary(inty) + " " + loInB.findLongestSequence(inty));
    }

    private int findLongestSequence(int i) {
        String representation = Integer.toBinaryString(i);
        int first = representation.indexOf('1');
        int last = representation.lastIndexOf('1');
        if (first == -1 || last == -1 || first == last)
            return 0;
        representation = representation.substring(first, last);
        int max = 0, tempMax = 0;
        for (char c : representation.toCharArray()) {
            if (c == '1') {
                if (tempMax > max) max = tempMax;
                tempMax = 0;
            } else {
                tempMax += 1;
            }
        }
        return Math.max(max, tempMax);
    }

    private String convertToBinary(int i) {
        String s = "";
        int z = i;
        while (z > 0) {
            s = z % 2 + s;
            z = z / 2;
        }
        return s;

    }

}
