package date;

import java.time.*;
import java.util.Date;

/**
 * <a href="http://www.cnblogs.com/swiftma/p/7424888.html" >计算机程序的思维逻辑 (95) - Java 8的日期和时间API</a>
 * <a href="https://github.com/swiftma/program-logic" >git address</a>
 *
 * Created by liqiulin on 2016/6/13.
 */
public class LocalDateTimeTest {
    public static void main(String[] args) {
        // 当前最后一刻
        long lastTimeOfToday = getDefaultDataEndTime();
        System.out.println("今天最后一刻 " + lastTimeOfToday);
        System.out.println("今天最后一刻 " + new Date(lastTimeOfToday));
        System.out.println("今天最后一刻 " + Instant.ofEpochMilli(lastTimeOfToday).toEpochMilli());

        LocalDateTime localDateTime;
        long m;

        localDateTime = LocalDateTime.of(2017, Month.JULY, 31, 0, 0, 0);
        m = getLocalDateTimeMills(localDateTime);
        System.out.println(m);
        System.out.println(new Date(m));
        System.out.println(new Date(1501430400000L));

        localDateTime = LocalDateTime.of(2017, Month.AUGUST, 4, 23, 59, 59);
        m = getLocalDateTimeMills(localDateTime);
        System.out.println(m);
        System.out.println(new Date(m));
        System.out.println(new Date(1501862399000L));


        System.out.println(Instant.now());  // instant 是绝对时间（GMT）, ZoneDateTime是时区时间
        ZonedDateTime zdt = ZonedDateTime.ofInstant(Instant.now(), ZoneId.systemDefault());
        System.out.println(zdt);
        System.out.println(zdt.toInstant());


    }

    /**
     * 默认时间取当前时间昨天晚上23：59：59秒.
     * @return
     */
    public static long getDefaultDataEndTime() {
        LocalDateTime defaultDateTime = LocalDateTime.of(LocalDate.now(), LocalTime.MAX);
        return defaultDateTime.toInstant(ZonedDateTime.now().getOffset()).toEpochMilli();
    }

    /**
     * 获取LocalDateTime的毫秒数
     * @param localDateTime
     * @return
     */
    public static long getLocalDateTimeMills(LocalDateTime localDateTime) {
        return localDateTime.toInstant(ZonedDateTime.now().getOffset()).toEpochMilli();
    }



}