package com.lauren.simplenews.login.net;


import com.lauren.simplenews.login.UserBean;

import java.util.HashMap;
import java.util.Map;

import retrofit2.Retrofit;
import rx.Observable;



public class ApiHelper extends RetrofitHelper {
    private static ApiHelper apiHelper;
    private Service service;
    private Map<String, String> map;

    private ApiHelper() {
        Retrofit retrofit = getRetrofit();
        service = retrofit.create(Service.class);
    }

    public static ApiHelper getInstance() {
        if (apiHelper == null) {
            synchronized (ApiHelper.class) {
                if (apiHelper == null) {
                    apiHelper = new ApiHelper();
                }
            }
        }
        return apiHelper;
    }


    public Observable<UserBean> insert(Map<String, String> options){
        map = new HashMap<>(options);
        return service.insert(map).compose(apiHelper.<UserBean>applySchedulers());
    }

    public Observable<UserBean> update(Map<String, String> options){
        map = new HashMap<>(options);
        return service.update(map).compose(apiHelper.<UserBean>applySchedulers());
    }

    public Observable<UserBean> login(Map<String, String> options){
        map = new HashMap<>(options);
        return service.login(map).compose(apiHelper.<UserBean>applySchedulers());
    }
}

