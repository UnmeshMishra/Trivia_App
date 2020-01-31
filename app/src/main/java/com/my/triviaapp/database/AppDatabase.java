package com.my.triviaapp.database;


import android.content.Context;
import android.util.Log;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;

@Database(entities = {QuizGame.class},version = 1,exportSchema = false)
@TypeConverters(DateConverter.class)
public abstract class AppDatabase extends RoomDatabase{


    private static Object LOCK = new Object();
    private static final String LOG_TAG = AppDatabase.class.getSimpleName();
    private static final String DATABASE_NAME = "quiz";
    private static AppDatabase dbInstance;

    public static AppDatabase getInstance(Context context){

        if (dbInstance == null){
            synchronized (LOCK){
                Log.d(LOG_TAG,"Creating new instance of database");
                dbInstance = Room.databaseBuilder(context.getApplicationContext(),AppDatabase.class,DATABASE_NAME)
                        .allowMainThreadQueries()
                        .build();

            }
        }

        Log.d(LOG_TAG,"Getting the database instance");
        return dbInstance;
    }

    public abstract QuizDao quizDao();
}