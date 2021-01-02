package com.lauren.simplenews;

import android.app.Application;
import android.arch.persistence.room.Room;

import com.lauren.simplenews.dao.AppDataBase;
import com.lauren.simplenews.login.UserBean;


public class App extends Application{
    public static UserBean userBean=null;
    public static App instance;
//    public static SharedPreferences preferences;

    private AppDataBase appDataBase;

    @Override
    public void onCreate() {
        super.onCreate();
        instance=this;

        appDataBase = Room.databaseBuilder(getApplicationContext(), AppDataBase.class, "user_manager.db")
//                .allowMainThreadQueries()
                .build();
//        preferences = getSharedPreferences("fav_cai", Context.MODE_PRIVATE);
    }

    public AppDataBase getAppDataBase(){
        return appDataBase;
    }
}
