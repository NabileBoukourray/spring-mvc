package nl.springMvc;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class Utils {

    public static int roundDoubleToInt(double d) {
        if ((d % 1) != 0) {
            if ((int) Math.round(d) == 0) {
                return 1;
            }
            return (int) Math.round(d);
        }
        return (int) d;
    }

    public static String parseDateDMY(Date date) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDate localDate = LocalDate.parse( new SimpleDateFormat("yyyy-MM-dd").format(date));
        return localDate.format(formatter).toString();
    }
}
