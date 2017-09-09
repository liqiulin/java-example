package date.jkd8time;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by qiulin on 2017-9-8.
 */
public class DateUtil {
    public static void main(String[] args) {
        Instant instant = Instant.now();
        System.out.println(instant);

        instant = toInstant(new Date());
        System.out.println(instant);

        instant = Instant.ofEpochMilli(System.currentTimeMillis());
        System.out.println(instant);

        System.out.println(toDate(instant));

        System.out.println(instant.atOffset(ZoneOffset.MAX));

        // LocalDateTime to Instant
        System.out.println("LocalDateTime to Instant:  " + toBeijingInstant(LocalDateTime.now()));

        // LocalDate/LocalTime
        LocalDate ld = LocalDate.of(2017, 7, 11);
        System.out.println(ld );

        // 格式化
        DateTimeFormatter dateTimeFormatter =
                DateTimeFormatter.ofPattern("MM-dd-yyyy");
        System.out.println(dateTimeFormatter.format(LocalDateTime.now()));


        System.out.println("localDateTime to Date: " + toDate(LocalDateTime.now()));


        System.out.println(toLocalDateTime(new Date()));
    }

    public static Instant toInstant(Date date) {
        return Instant.ofEpochMilli(date.getTime());
    }

    public static Date toDate(Instant instant) {
        return new Date(instant.toEpochMilli());
    }

    public static Date toDate(LocalDateTime localDateTime) {
        Instant instant = localDateTime.atZone(ZoneId.systemDefault()).toInstant();
        return new Date(instant.toEpochMilli());
    }

    public static Instant toBeijingInstant(LocalDateTime ldt) {
        return ldt.toInstant(ZoneOffset.of("+08:00"));
    }

    // Date按默认时区转为LocalDateTime
    public static LocalDateTime toLocalDateTime(Date date) {
        Instant instant = date.toInstant();
        return LocalDateTime.ofInstant(instant, ZoneId.systemDefault());
    }

    public static ZonedDateTime toZonedDateTime(Calendar calendar) {
        ZonedDateTime zdt = ZonedDateTime.ofInstant(
                Instant.ofEpochMilli(calendar.getTimeInMillis()),
                calendar.getTimeZone().toZoneId());
        return zdt;
    }

}
