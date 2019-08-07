package utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class DateUtils {
    public static boolean validateDate(String dateToValidate)
    {
        if(dateToValidate == null){
            return false;
        }

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        sdf.setLenient(false);

        try {
            Date date = sdf.parse(dateToValidate);

        } catch (ParseException e) {

            return false;
        }

        return true;
    }
    
    public static Date createDateFromString(String date)
    {
        if(validateDate(date))
        {
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            try {
                Date dateFim = sdf.parse(date);
                return dateFim;
            } catch (ParseException ex) {
                return null;
            }
        }
        else
            return null;
    }
    
    public static String formatDateBR(Date date)
    {
        DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        return df.format(date);
    }
}