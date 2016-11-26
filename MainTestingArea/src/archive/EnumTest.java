package archive;
//import java.util.Arrays;

public class EnumTest {
    public enum Months {
        January(31), February(28), March(30), April(30), May(30), June(30), July(30), August(30), September(30), October(
                30), November(30), December(29);

        Months(int days) {
            this.days = days;
        }

        private final int days;

        int getNumberOfDays() {
            return days;
        }

        int middleOfMonthDay() {
            return days / 2;
        }

    }

    public static void main(String[] args) {
        Months j = Months.January;
        System.out.println(j);
        for (Months i : Months.values()) {
            System.out.println(i.name() + "-" + i.getNumberOfDays() + " middle day : " + i.middleOfMonthDay());
        }
    }
}
