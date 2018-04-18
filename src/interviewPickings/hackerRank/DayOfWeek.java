package interviewPickings.hackerRank;

import java.time.LocalDate;

public class DayOfWeek {

    public static void main(String[] args) {
//            Scanner in = new Scanner(System.in);
        int month = Integer.parseInt("08"); //in.next();
        int day = Integer.parseInt("05"); //in.next();
        int year = Integer.parseInt("2015"); //in.next();
        LocalDate dt = LocalDate.of(year, month, day);
        System.out.print(dt.getDayOfWeek());
    }
}
