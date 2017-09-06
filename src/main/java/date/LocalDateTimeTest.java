package date;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.ZonedDateTime;
import java.util.Date;

/**
 * Created by liqiulin on 2016/6/13.
 */
public class LocalDateTimeTest {
    public static void main(String[] args) {
        System.out.println(getDefaultDataEndTime());

        long epochImlli = LocalDate.now().atStartOfDay().minusSeconds(1).toInstant(ZonedDateTime.now().getOffset()).toEpochMilli();

        System.out.println(epochImlli);
        System.out.println(new Date(epochImlli));

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


        localDateTime = LocalDateTime.of(2017, Month.AUGUST, 7, 0, 0, 0);
        m = getLocalDateTimeMills(localDateTime);
        System.out.println(new Date(m)   +  "  "+ m);

        localDateTime = LocalDateTime.of(2017, Month.AUGUST, 13, 23, 59, 59);
        m = getLocalDateTimeMills(localDateTime);
        System.out.println(new Date(m)   +  "  "+ m);localDateTime = LocalDateTime.of(2017, Month.AUGUST, 13, 23, 59, 59);


        m = getLocalDateTimeMills(localDateTime);
        System.out.println(new Date(m)   +  "  "+ m);localDateTime = LocalDateTime.of(2017, Month.JULY, 15, 23, 59, 59);
        m = getLocalDateTimeMills(localDateTime);
        System.out.println(new Date(m)   +  "  "+ m);localDateTime = LocalDateTime.of(2017, Month.AUGUST, 15, 23, 59, 59);
        m = getLocalDateTimeMills(localDateTime);
        System.out.println(new Date(m)   +  "  "+ m);


    }

    /**
     * 默认时间取当前时间昨天晚上23：59：59秒.
     * @return
     */
    public static long getDefaultDataEndTime() {
        LocalDateTime defaultDateTime = LocalDate.now().atStartOfDay().minusSeconds(1);
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