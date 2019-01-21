package com;

import android.arch.persistence.db.SupportSQLiteDatabase;
import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;
import android.os.AsyncTask;
import android.support.annotation.NonNull;

@Database(entities = {User.class}, version = 1)
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

