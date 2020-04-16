package com.filip.horrornight;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
@Database(entities = {User.class}, version = 1)
public abstract class UserDatabase extends RoomDatabase {
        private static volatile UserDatabase DATABASE;
        private static final String DATABASE_NAME = "user_database";
        public abstract UserDao getUserDao();

    public static UserDatabase getDatabase(Context context){
            if(DATABASE==null){
                synchronized (UserDatabase.class){
                    if(DATABASE==null){
                        DATABASE = Room.databaseBuilder(context.getApplicationContext(),
                                UserDatabase.class,
                                DATABASE_NAME).allowMainThreadQueries().build();
                    }
                }
            }
            return DATABASE;
        }
}
