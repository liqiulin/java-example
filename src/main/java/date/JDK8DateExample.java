package date;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * <p>
 * <a href="http://www.importnew.com/14140.html">Java8 日期/时间（Date Time）API指南</a>
 * </p>
 * Created by liqiulin on 2017/7/21.
 */
public class JDK8DateExample {
    public static void main(String[] args) {
        String dateString = "2017-07-01";
        String dateString2 = translateDateString(dateString);
        System.out.println(translateDateString(dateString2));
    }

    public static String translateDateString(String dateString) {
        LocalDate localDate = LocalDate.parse(dateString, DateTimeFormatter.ofPattern("uuuu-MM-dd"));
        return localDate.format(DateTimeFormatter.ofPattern("uuuu-MM"));
    }
}
