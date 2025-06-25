package uz.itpu.tasktracker.utils;

import lombok.experimental.UtilityClass;

import java.time.LocalDateTime;

@UtilityClass
public class DateTimeUtils {

    public static Long convertDateToTimestamp(LocalDateTime localDateTime) {
        if (localDateTime != null) {
            return localDateTime.atZone(java.time.ZoneId.systemDefault()).toInstant().toEpochMilli();
        }
        return null;
    }

    public static LocalDateTime convertTimestampToDate(Long timestamp) {
        if (timestamp != null) {
            return LocalDateTime.ofInstant(java.time.Instant.ofEpochMilli(timestamp), java.time.ZoneId.systemDefault());
        }
        return null;
    }
}
