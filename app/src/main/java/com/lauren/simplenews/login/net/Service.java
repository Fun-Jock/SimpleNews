package com.lauren.simplenews.login.net;


import com.lauren.simplenews.login.UserBean;

import java.util.Map;

import retrofit2.http.GET;
import retrofit2.http.QueryMap;
import rx.Observable;



public interface Service {

    @GET("user/login")
    Observable<UserBean> login(@QueryMap Map<String, String> options);


    @GET("user/update")
    Observable<UserBean> update(@QueryMap Map<String, String> options);


    @GET("user/insert")
    Observable<UserBean> insert(@QueryMap Map<String, String> options);
}
