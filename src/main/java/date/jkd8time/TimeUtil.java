package date.jkd8time;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Date;

/**
 *  <a href="http://www.cnblogs.com/swiftma/p/7424888.html">老马说编程</a>
 *<br/>
 * Created by qiulin on 2017-9-7.
 */
public final class TimeUtil {

    public static void main(String[] args) {
        Instant instant = Instant.now();
        System.out.println(instant);
        Date date = toDate(instant);
        System.out.println(date);

        instant = Instant.ofEpochMilli(System.currentTimeMillis());
        System.out.println(instant);
        date = toDate(instant);
        System.out.println(date);

        Instant baijingInsance = toBeiJingInstant(LocalDateTime.now());
        System.out.println("to BeiJingInstant");

    }
    public static Instant toInstant(Date date) {
        return Instant.ofEpochMilli(date.getTime());
    }

    public static Date toDate(Instant instant) {
        return new Date(instant.toEpochMilli());
    }

    public static Instant toBeiJingInstant(LocalDateTime ldt) {
        return ldt.toInstant(ZoneOffset.of("+8:00"));
    }

}
