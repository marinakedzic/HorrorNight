package com.filip.horrornight;

import android.annotation.SuppressLint;
import android.app.Application;
import android.content.Context;
import android.os.AsyncTask;

public class UserRepository {
    private UserDao userDao;
    private UserDatabase userDatabase;
    public UserRepository(Application application) {
        userDatabase = UserDatabase.getDatabase(application);
        userDao = userDatabase.getUserDao();
    }

    @SuppressLint("StaticFieldLeak")
    public void insert(final User user){
        new AsyncTask<Void, Void, Void>() {
            @Override
            protected Void doInBackground(Void... voids) {
                userDatabase.getUserDao().insert(user);
                return null;
            }
        }.execute();
    }
    @SuppressLint("StaticFieldLeak")
    public void update(final User user){
        new AsyncTask<Void, Void, Void>() {
            @Override
            protected Void doInBackground(Void... voids) {
                userDatabase.getUserDao().update(user);
                return null;
            }
        }.execute();
    }
    @SuppressLint("StaticFieldLeak")
    public void delete(final User user){
        new AsyncTask<Void, Void, Void>() {
            @Override
            protected Void doInBackground(Void... voids) {
                userDatabase.getUserDao().delete(user);
                return null;
            }
        }.execute();
    }
    @SuppressLint("StaticFieldLeak")
    public User find(final int userId){
        return userDatabase.getUserDao().findById(userId);
    }

}
