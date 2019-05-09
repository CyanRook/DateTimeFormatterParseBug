import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.temporal.ChronoField;
import java.time.temporal.TemporalAccessor;
import java.util.Locale;

public class Main {

    public static void main(String[] args) {
        // Expected DateTimeParse Error - Got Midnight of Next Day
        String input = "2007-10-22 12:00 PM";
        DateTimeFormatterBuilder builder = new DateTimeFormatterBuilder()
                .parseStrict()
                .appendValue(ChronoField.YEAR_OF_ERA)
                .appendLiteral('-')
                .appendValue(ChronoField.MONTH_OF_YEAR)
                .appendLiteral('-')
                .appendValue(ChronoField.DAY_OF_MONTH)
                .appendLiteral(' ')
                .appendValue(ChronoField.HOUR_OF_AMPM,2)
                .appendLiteral(':')
                .appendValue(ChronoField.MINUTE_OF_HOUR,2)
                .appendLiteral(' ')
                .appendText(ChronoField.AMPM_OF_DAY);
        DateTimeFormatter formatter = builder.toFormatter(Locale.US);
        TemporalAccessor accessor = formatter.parse(input);
        LocalDateTime localDateTime = LocalDateTime.from(accessor);
        System.out.println(localDateTime.toString());

        // Expected Noon - Got Noon
        input = "2007-10-22 12:00 PM";
        builder = new DateTimeFormatterBuilder()
                .parseStrict()
                .appendValue(ChronoField.YEAR_OF_ERA)
                .appendLiteral('-')
                .appendValue(ChronoField.MONTH_OF_YEAR)
                .appendLiteral('-')
                .appendValue(ChronoField.DAY_OF_MONTH)
                .appendLiteral(' ')
                .appendValue(ChronoField.CLOCK_HOUR_OF_AMPM,2)
                .appendLiteral(':')
                .appendValue(ChronoField.MINUTE_OF_HOUR,2)
                .appendLiteral(' ')
                .appendText(ChronoField.AMPM_OF_DAY);
        formatter = builder.toFormatter(Locale.US);
        accessor = formatter.parse(input);
        localDateTime = LocalDateTime.from(accessor);
        System.out.println(localDateTime.toString());



        // Expected Noon - Got Noon
        input = "2007-10-22 00:00 PM";
        builder = new DateTimeFormatterBuilder()
                .parseStrict()
                .appendValue(ChronoField.YEAR_OF_ERA)
                .appendLiteral('-')
                .appendValue(ChronoField.MONTH_OF_YEAR)
                .appendLiteral('-')
                .appendValue(ChronoField.DAY_OF_MONTH)
                .appendLiteral(' ')
                .appendValue(ChronoField.HOUR_OF_AMPM)
                .appendLiteral(':')
                .appendValue(ChronoField.MINUTE_OF_HOUR)
                .appendLiteral(' ')
                .appendText(ChronoField.AMPM_OF_DAY);
        formatter = builder.toFormatter(Locale.US);
        accessor = formatter.parse(input);
        localDateTime = LocalDateTime.from(accessor);
        System.out.println(localDateTime.toString());



        // Expected DateTimeParse Error - Got Noon
        input = "2007-10-22 00:00 PM";
        builder = new DateTimeFormatterBuilder()
                .parseStrict()
                .appendValue(ChronoField.YEAR_OF_ERA)
                .appendLiteral('-')
                .appendValue(ChronoField.MONTH_OF_YEAR)
                .appendLiteral('-')
                .appendValue(ChronoField.DAY_OF_MONTH)
                .appendLiteral(' ')
                .appendValue(ChronoField.CLOCK_HOUR_OF_AMPM)
                .appendLiteral(':')
                .appendValue(ChronoField.MINUTE_OF_HOUR)
                .appendLiteral(' ')
                .appendText(ChronoField.AMPM_OF_DAY);
        formatter = builder.toFormatter(Locale.US);
        accessor = formatter.parse(input);
        localDateTime = LocalDateTime.from(accessor);
        System.out.println(localDateTime.toString());
    }
}
