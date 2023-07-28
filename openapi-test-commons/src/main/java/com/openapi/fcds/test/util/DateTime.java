package com.openapi.fcds.test.util;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.Date;

public enum DateTime {

  YEAR, MONTH, DAY;
  
  public static String current(boolean withTime) {
    return formatDate(new Date(), withTime);
  }
  
  public static Date currentDateMillis() {
    return new Date();
  }
  
  public static long getNowTimestamp() {
    return Timestamp.from(Instant.now()).getTime();
  }
  
  public static long getTwoDaysBeforeTimestamp() {
    return Timestamp.from(Instant.now().minus(2, ChronoUnit.DAYS)).getTime();
  }
  
  public static long getTwoDaysAfterTimestamp() {
    return Timestamp.from(Instant.now().plus(2, ChronoUnit.DAYS)).getTime();
  }
  
  private static String formatDate(Date date, boolean withTime) {
    return (withTime) ? new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS").format(date)
            : new SimpleDateFormat("yyyy-MM-dd").format(date);
  }
  
  public static int getEpochSecond() {
    return (int) Instant.now().getEpochSecond();
  }
  
  public static DateTimeFormatter getMessageDateTimeFormatter() {
    return DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
  }
  
  public static DateTimeFormatter getLongDateFormat() {
    return DateTimeFormatter.ofLocalizedDate(FormatStyle.LONG);
  }
  
  public static String parseDate(String originalFormat, String newFormat, String originalDateString)
          throws ParseException {
    return new SimpleDateFormat(newFormat)
            .format(new SimpleDateFormat(originalFormat).parse(originalDateString));
  }
  
  public String adjust(int amount, boolean withTime) {
    var cal = Calendar.getInstance();
    cal.setTime(new Date());
    switch (this) {
      case YEAR:
        cal.add(Calendar.YEAR, amount);
        break;
      case MONTH:
        cal.add(Calendar.MONTH, amount);
        break;
      case DAY:
        cal.add(Calendar.DATE, amount);
        break;
    }
    return formatDate(cal.getTime(), withTime);
  }
}
