package examples1200.chapter4_String;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * Created by zjm on 2016/12/22.
 */
public class FormatDate {

    public static void main(String[] args) {
        Date date = new Date();
        DateFormat format = DateFormat.getDateInstance(DateFormat.MEDIUM, Locale.CHINA);
        System.out.println("中国日期: " + format.format(date));
        format = DateFormat.getDateInstance(DateFormat.FULL, Locale.GERMAN);
        System.out.println("德国日期: " + format.format(date));
        System.out.println(String.format(Locale.CANADA, "%tM", date));
    }
}
