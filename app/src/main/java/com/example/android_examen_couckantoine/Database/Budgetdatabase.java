package com.example.android_examen_couckantoine.Database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;

import com.example.android_examen_couckantoine.DAO.Budget_itemDAO;
import com.example.android_examen_couckantoine.Models.Budget_item;
import com.example.android_examen_couckantoine.Utils.DateConverters;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Database(version = 1 , entities = {Budget_item.class} , exportSchema = false)
@TypeConverters(DateConverters.class)
public abstract class Budgetdatabase extends RoomDatabase {

    private static final String DB_NAME = "Budgetdatabase.db";
    private static Budgetdatabase instance;
    private static final int NUMBER_OF_THREADS = 4;

    public static final ExecutorService databaseexe = Executors.newFixedThreadPool(NUMBER_OF_THREADS);


    public static Budgetdatabase getInstance(Context context) {

        if (instance == null) {

            instance = Room.databaseBuilder(context, Budgetdatabase.class, DB_NAME).build();

        }
        return instance;
    }

    //TODO  add all dao here

    public abstract Budget_itemDAO getDAO();


}