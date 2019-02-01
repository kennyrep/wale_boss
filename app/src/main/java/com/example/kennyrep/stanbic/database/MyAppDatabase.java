package com.example.kennyrep.stanbic.database;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

@Database(entities = {User.class}, version = 1, exportSchema = true)
public abstract class MyAppDatabase extends RoomDatabase {

    //public static MyAppDatabase INSTANCE;

    public abstract MyDao myDao();

    private static volatile MyAppDatabase INSTANCE;


    static MyAppDatabase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (MyAppDatabase.class) {
                if (INSTANCE == null) {
                    // Create database here
                }
            }
        }
        return INSTANCE;
    }


}

