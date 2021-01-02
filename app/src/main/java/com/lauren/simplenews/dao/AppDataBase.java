package com.lauren.simplenews.dao;


import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

import com.lauren.simplenews.login.UserBean;

@Database(entities = {UserBean.class }, version = 1)
public abstract class AppDataBase extends RoomDatabase {
    public abstract UserDao userDao();
}
