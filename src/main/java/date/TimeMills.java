package date;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;

/**
 * Created by liqiulin on 2017/9/4.
 */
public class TimeMills {
    public static void main(String[] args) {
        long startTime = 0;
        long endTime = 0;
        LocalDate now = LocalDate.now();
        LocalDate yesterday = now.minusDays(1);

        startTime = getLocalDateTimeMills(now.atStartOfDay());
        endTime = getLocalDateTimeMills(yesterday.atStartOfDay());

        System.out.println(startTime);
        System.out.println(endTime);

        LocalDate lastWeek = now.minusDays(7);
        endTime = getLocalDateTimeMills(lastWeek.atStartOfDay());
        System.out.println(endTime);

        LocalDate lastMonth = now.minusDays(30);
        endTime = getLocalDateTimeMills(lastMonth.atStartOfDay());
        System.out.println(endTime);
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
