package com.example.android_examen_couckantoine.Utils;

import androidx.room.TypeConverter;

import org.threeten.bp.LocalDate;

public class DateConverters {

    @TypeConverter
    public static String dateToString(LocalDate date){
        return (date == null)? null : date.toString();
    }

    @TypeConverter
    public static LocalDate stringToDate(String dateString){
        return (dateString == null)? null : LocalDate.parse(dateString);
    }


}
