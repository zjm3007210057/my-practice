package examples1200.chapter4_String;

import java.text.NumberFormat;
import java.util.Locale;

/**
 * Created by zjm on 2016/12/22.
 */
public class FormatNumber {

    public static void main(String[] args) {
        double n = 2.4;
        NumberFormat format = NumberFormat.getCurrencyInstance(Locale.CHINA);
        String s = format.format(n);
        System.out.println(s);
    }
}
