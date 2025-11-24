import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class ParseDate {
    public static LocalDateTime parseIsoFormat(String stringDate) {
        if (stringDate == null) {
            return null;
        }
        return LocalDateTime.parse(stringDate);
    }

    public static LocalDate parseFullTextFormat(String stringDate) {
        if (stringDate == null) {
            return null;
        }
        String[] monthsFr = {
            "janvier", "février", "mars", "avril", "mai", "juin",
            "juillet", "août", "septembre", "octobre", "novembre", "décembre"
        };

        String[] monthsEn = {
            "january", "february", "march", "april", "may", "june",
            "july", "august", "september", "october", "november", "december"
        };

        String[] parts = stringDate.split(" ");
        int day = Integer.parseInt(parts[1]);
        int month = 0;

        String monthStr = parts[2].toLowerCase();

        for (int i = 0; i < monthsFr.length; i++) {
            if (monthsFr[i].equals(monthStr)) {
                month = i + 1;
                break;
            }
        }

        if (month == 0) {
            for (int i = 0; i < monthsEn.length; i++) {
                if (monthsEn[i].equals(monthStr)) {
                    month = i + 1;
                    break;
                }
            }
        }
        
        int year = Integer.parseInt(parts[3]);

        return LocalDate.of(year, month, day);
    }

    public static LocalTime parseTimeFormat(String stringDate) {
        if (stringDate == null) {
            return null;
        }
        String[] parts = stringDate.split(" ");
        int hours = Integer.parseInt(parts[0]);
        int minutes = 0;
        int seconds = 0;

        // Find minutes - look for number before "minutes"
        for (int i = 0; i < parts.length; i++) {
            if (parts[i].equals("minutes")) {
                minutes = Integer.parseInt(parts[i - 1]);
                break;
            }
        }
        
        // Find seconds - look for number before "secondes"
        for (int i = 0; i < parts.length; i++) {
            if (parts[i].equals("secondes") || parts[i].equals("seconds")) {
                seconds = Integer.parseInt(parts[i - 1]);
                break;
            }
        }
        
        // Check if it's evening time (PM)
        if (stringDate.contains("soir") || stringDate.contains("evening") && hours < 12) {
            hours += 12;
        }

        return LocalTime.of(hours, minutes, seconds);
    }
}