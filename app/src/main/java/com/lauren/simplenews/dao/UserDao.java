package com.lauren.simplenews.dao;


import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import com.lauren.simplenews.login.UserBean;

@Dao
public interface UserDao {

    @Query("SELECT * FROM users WHERE name = :name AND password = :password")
    public UserBean login(String name, String password);

    @Insert
    public void inserUser(UserBean user);
}
