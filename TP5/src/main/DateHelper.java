package main;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Antoine on 16/11/2014.
 */
public class DateHelper {

    static SimpleDateFormat dateTimeFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm");
    static SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    static SimpleDateFormat timeFormat = new SimpleDateFormat("hh:mm");

    /**
     *
     * @param dateTime String au format "yyyy-MM-dd hh:mm"
     * @return String "yyyy-MM-dd"
     * @throws ParseException format attendu non respecté
     */
    public static String getDateTimeFromDateTime(String dateTime) throws ParseException{
        String retour = null;
            Date parsedTimeStamp = dateTimeFormat.parse(dateTime);
            retour = String.valueOf(dateTimeFormat.format(parsedTimeStamp.getTime()));
        return retour;
    }


    /**
     *
     * @param date String au format "yyyy-MM-dd" ou même "yyyy-MM-dd hh:mm"
     * @return String "yyyy-MM-dd"
     * @throws ParseException format attendu non respecté
     */
    public static String getDateFromDate(String date) throws ParseException{
        String retour = null;
            Date parsedTimeStamp = dateFormat.parse(date);
            retour = String.valueOf(dateFormat.format(parsedTimeStamp.getTime()));
        return retour;
    }

    /**
     *
     * @param dateTime String au format "yyyy-MM-dd hh:mm"
     * @return String "yyyy-MM-dd"
     * @throws ParseException format attendu non respecté
     */
    public static String getTimeFromDateTime(String dateTime) throws ParseException{
        String retour = null;
            Date parsedTimeStamp = dateTimeFormat.parse(dateTime);
            retour = String.valueOf(timeFormat.format(parsedTimeStamp.getTime()));
        return retour;
    }
    /**
     *
     * @param time String au format "yyyy-MM-dd hh:mm"
     * @return String "yyyy-MM-dd"
     * @throws ParseException format attendu non respecté
     */
    public static String getTimeFromTime(String time) throws ParseException{
        String retour = null;
            Date parsedTimeStamp = timeFormat.parse(time);
            retour = String.valueOf(timeFormat.format(parsedTimeStamp.getTime()));
        return retour;
    }
}
