package id.co.jamkrindo.backend.util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateTimeUtil {
  public static LocalDateTime stringToLocalDateTime(String input) {
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    LocalDateTime localDateTime = LocalDateTime.parse(input, formatter);
    return localDateTime;
  }
}
