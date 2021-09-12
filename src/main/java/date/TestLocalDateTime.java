package date;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class TestLocalDateTime {

    public static void main(String[] args) {
//        LocalDateTime ldt = LocalDateTime.now();
//        System.out.println(ldt);
//
//        LocalDateTime ldt2 = ldt.withDayOfMonth(10);
//        System.out.println(ldt2);
//
//        LocalDateTime ldt3 = ldt.with(TemporalAdjusters.next(DayOfWeek.SUNDAY));
//        System.out.println(ldt3);

        DateTimeFormatter dtf = DateTimeFormatter.ISO_DATE;
        LocalDateTime ldt = LocalDateTime.now();
        String format = dtf.format(ldt);
        System.out.println(format);

        System.out.println("----------------------------------");

        DateTimeFormatter dtf2 = DateTimeFormatter.ofPattern("yyyy年MM月dd日 HH:mm:ss");
        String format1 = dtf2.format(ldt);
        System.out.println(format1);


    }
}
