package interviewPickings.interviewBit;

import java.util.ArrayList;
import java.util.Arrays;

public class MaxSet {

    public ArrayList<Integer> maxset(ArrayList<Integer> a) {
        Res current = new Res();
        Res result = new Res();

        for (int pos = 0; pos < a.size(); pos++) {
            int elem = a.get(pos);
            if (elem < 0) {
                if (current.size() > 0) {
                    if (current.compareTo(result) == 1) {
                        result = current;
                    }
                    current = new Res();
                }
            } else {
                if (current.starting_index == -1)
                    current.starting_index = pos;
                current.add(elem);
                current.addToSum(elem);

            }
        }
        return current.compareTo(result) == 1 ? current.data : result.data;
    }


    class Res implements Comparable {
        int starting_index = -1;
        ArrayList<Integer> data = new ArrayList<>();
        long sum = 0;

        public int size() {
            return data.size();
        }

        public void add(int e) {
            data.add(e);
        }

        public long getSum() {
            return sum;
        }

        public void addToSum(long s) {
            this.sum += s;
        }

        @Override
        public int compareTo(Object o) {
            Res in = (Res) o;
            if (in.starting_index == -1) return 1;

            if (in.sum == this.sum) {
                if (in.size() == this.size()) {
                    return this.starting_index > in.starting_index ? 1 : -1;
                }

                return in.size() < this.size() ? 1 : -1;
            } else {
                return this.sum > in.sum ? 1 : -1;
            }
        }
    }

    public static void main(String[] args) {
        MaxSet m = new MaxSet();
        //Integer[] arr = new Integer[]{336465782, -278722862, -2145174067, 1101513929, 1315634022, -1369133069, 1059961393, 628175011, -1131176229, -859484421};
        Integer[] arr = new Integer[]{24115, -75629, -46517, 30105, 19451, -82188, 99505, 6752, -36716, 54438, -51501, 83871, 11137, -53177, 22294, -21609, -59745, 53635, -98142, 27968, -260, 41594, 16395, 19113, 71006, -97942, 42082, -30767, 85695, -73671};
        //Integer[] arr = new Integer[]{756898537, -1973594324, -2038664370, -184803526, 1424268980};
        //Integer[] arr = new Integer[]{ 1, 2, 5, -7, 2, 5};
        ArrayList<Integer> arr2 = new ArrayList(Arrays.asList(arr));
        System.out.println("41594, 16395, 19113, 71006      <-> " + m.maxset(arr2));
    }

    public ArrayList<Integer> maxsetEditorial(ArrayList<Integer> a) {
        long maxSum = 0;
        long newSum = 0;
        ArrayList<Integer> maxArray = new ArrayList<>();
        ArrayList<Integer> newArray = new ArrayList<>();
        for (Integer i : a) {
            if (i >= 0) {
                newSum += i;
                newArray.add(i);
            } else {
                newSum = 0;
                newArray = new ArrayList<>();
            }
            if ((maxSum < newSum) || ((maxSum == newSum) && (newArray.size() > maxArray.size()))) {
                maxSum = newSum;
                maxArray = newArray;
            }
        }
        return maxArray;
    }
}
