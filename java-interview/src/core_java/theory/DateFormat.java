package core_java.theory;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.Date;

public class DateFormat {
    public static void main(String[] args) {

//        //java.util.Date – Lớp cũ (Trước Java 8)
//        Date now = new Date();
//        System.out.println(now);
//
//        //java.util.Calendar – Lớp cũ (Trước Java 8)
//        Calendar calendar = Calendar.getInstance();
//        System.out.println(calendar.getTime());

        //java.time.LocalDate – Thời gian không có múi giờ (Java 8+)
        //Chỉ lưu trữ ngày tháng (không có thời gian).
        LocalDate date = LocalDate.now();
        System.out.println(date); // In ngày hiện tại (yyyy-MM-dd)

        //java.time.LocalTime – Thời gian không có ngày tháng (Java 8+)
        LocalTime time = LocalTime.now();
        System.out.println(time); // In thời gian hiện tại (hh:mm:ss.nnnnnn)

        LocalDateTime now = LocalDateTime.now();
        System.out.println(now); // System.out.println(calendar.getTime());

        //java.time.ZonedDateTime – Thời gian có múi giờ (Java 8+)
        ZonedDateTime zonedNow = ZonedDateTime.now();
        System.out.println(zonedNow); // In thời gian có múi giờ

        //7. java.time.Instant – Mốc thời gian (Java 8+)
        //Mô tả: Đại diện cho mốc thời gian tính từ epoch (1970-01-01T00:00:00Z) (UTC).
        Instant instant = Instant.now();
        System.out.println(instant); // In mốc thời gian hiện tại (epoch time)

        //ava.time.Duration – Khoảng thời gian (Java 8+)
        //Mô tả: Đại diện cho khoảng thời gian giữa hai thời điểm.


        //java.time.Period – Khoảng thời gian theo đơn vị năm, tháng, ngày (Java 8+)
        LocalDate start = LocalDate.of(2022, 4, 10);
        LocalDate end = LocalDate.of(2023, 1, 1);

        Period period = Period.between(start, end);
        System.out.println(period.getDays()); // In khoảng thời gian (P1Y)
        System.out.println(period.getMonths()); // In khoảng thời gian (P1Y)
        System.out.println(period.getYears()); // In khoảng thời gian (P1Y)


        LocalDate start1 = LocalDate.of(2022, 4, 10);
        LocalDate end1 = LocalDate.of(2023, 1, 1);

        long totalDays = ChronoUnit.DAYS.between(start1, end1);
        System.out.println("Total days: " + totalDays);

        ////////////////////////////////////
        String dateString = "2022-04-10";
        LocalDate dateF = LocalDate.parse(dateString, DateTimeFormatter.ISO_DATE);
        System.out.println("Converted Date: " + dateF);

        Instant now1 = Instant.now();
        System.out.println("Current time in epoch seconds: " + now1.getEpochSecond());

        ZonedDateTime zone = ZonedDateTime.now();

        // Định dạng ISO 8601
        DateTimeFormatter formatter = DateTimeFormatter.ISO_DATE_TIME;
        System.out.println("ISO 8601 Format: " + zone.format(formatter)); // Ví dụ: 2023-05-10T10:30:00+07:00



    }
}
