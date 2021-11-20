/**
 * 
 */
package com.talks.utils;

import java.sql.Timestamp;
import java.util.Date;

import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
/**
 * @author snaredl
 *
 */
public class DateUtils {

    private static final String GMT_MM = "yyyy-MM-dd HH:mm:ss";

    public static String getUTCFormattedTimestamp() {
        DateTime now = new DateTime();
        return now.toDateTime(DateTimeZone.UTC).toString();
    }

    public static Timestamp getTimestamp() {
        Date now = new Date();
        return new Timestamp(now.getTime());
    }

    public static String getYYYYMMDDHHMMSSFormat() {
        DateTime now = new DateTime();
        DateTimeFormatter formatter = DateTimeFormat.forPattern(GMT_MM);
        return formatter.print(now);
    }

}
