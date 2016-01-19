package org.computermentors.ageapp;

import android.widget.DatePicker;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * Created by CryoFlar3 on 4/19/2015.
 */
public class Calculate {

    public String Calculate(DatePicker dob){

        Date newDate = new Date(dob.getYear() - 1900, dob.getMonth(), dob.getDayOfMonth());

        // Calculating actual Birth
        GregorianCalendar calendar = new GregorianCalendar();
        calendar.setTime(newDate);
        newDate.setTime(calendar.getTime().getTime());

        DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
        String date = df.format(newDate);

        return date;

    }

    public Date Calculate2(DatePicker dob){

        Date newDate = new Date(dob.getYear() - 1900, dob.getMonth(), dob.getDayOfMonth());

        // Calculating actual Birth
        GregorianCalendar calendar = new GregorianCalendar();
        calendar.setTime(newDate);
        newDate.setTime(calendar.getTime().getTime());

        return newDate;

    }

    public int getYear(Date date){

        Date now = new Date();

        // Parse Birth Date
        Calendar dob = Calendar.getInstance();
        dob.setTime(date);
        Calendar today = Calendar.getInstance();
        int age = today.get(Calendar.YEAR) - dob.get(Calendar.YEAR);
        if (today.get(Calendar.MONTH) < dob.get(Calendar.MONTH)) {
            age--;
        } else if (today.get(Calendar.MONTH) == dob.get(Calendar.MONTH)
                && today.get(Calendar.DAY_OF_MONTH) < dob.get(Calendar.DAY_OF_MONTH)) {
            age--;
        }

        return age;
    }

    public int getMonth(Date date){

        Calendar dob = Calendar.getInstance();
        dob.setTime(date);
        Calendar today = Calendar.getInstance();
        int age = today.get(Calendar.MONTH) - dob.get(Calendar.MONTH);
        if (age < 0){
            //age++;
            age = age + 12;
        }

        return age;
    }

    public int getDay(Date date){

        Calendar dob = Calendar.getInstance();
        dob.setTime(date);
        Calendar today = Calendar.getInstance();
        int age = today.get(Calendar.DATE) - dob.get(Calendar.DATE);


        return age;
    }
}





























