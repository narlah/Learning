package interviewPickings.leetcode;

public class LemonadeChange {

    public boolean lemonadeChange(int[] bills) {
        int fives = 0, tens = 0, twenties = 0;
        for (int i = 0; i < bills.length; i++) {
            switch (bills[i]) {
                case 5:
                    fives++;
                    break;
                case 10:
                    if (fives < 1)
                        return false;
                    fives--;
                    tens++;
                    break;
                case 20:
                    if (fives < 1 || (tens < 1 && fives < 3)) return false;
                    else if (tens >= 1) {
                        tens--;
                        fives--;

                    } else {
                        fives -= 3;
                    }

            }
        }
        return true;
    }
}
