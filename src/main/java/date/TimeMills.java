package date;

import java.time.LocalDate;

/**
 * Created by liqiulin on 2017/9/4.
 */
public class TimeMills {
    public static void main(String[] args) {
        LocalDate localDate = LocalDate.now();
        LocalDate yesterday = localDate.minusDays(1);

        System.out.println();
    }
}
