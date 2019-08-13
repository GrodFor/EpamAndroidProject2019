package sitsko.vlad.epamandroidproject.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Locale;

public class DiffUtil {

    public static String dateFormat(String originDate) throws ParseException {
        final String subDate = (originDate).substring(0, originDate.indexOf("T"));
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
        final Date date = formatter.parse(subDate);
        formatter = new SimpleDateFormat("dd MMM, yyyy", Locale.ENGLISH);

        return formatter.format(date);
    }
}
