package com.lauren.simplenews.login.net;

import java.util.concurrent.TimeUnit;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSession;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;



public class RetrofitHelper {
    private static final String baseUrl = "http://10.0.0.3:8080/SSM/";

    protected Retrofit getRetrofit() {
        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient.Builder okBuilder = getOkHttpBuilder().addInterceptor(logging);
        OkHttpClient okHttpClient = okBuilder.build();
        Retrofit.Builder reBuilder = getReBuilder(baseUrl, okHttpClient);
        Retrofit retrofit = reBuilder.build();
        return retrofit;
    }

    private Retrofit.Builder getReBuilder(String host, OkHttpClient client) {
        if (host == null) {
            throw new IllegalArgumentException("host cant be null");
        }
        if (client == null) {
            throw new IllegalArgumentException("client cant be null");
        }
        return new Retrofit.Builder()
                .baseUrl(host)
                .callFactory(client)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create());
    }

    private OkHttpClient.Builder getOkHttpBuilder() {
        long DEFAULT_CONNECT_TIMEOUT = 10 * 1000;
        long DEFAULT_READ_TIMEOUT = 10 * 1000;
        long DEFAULT_WRITE_TIMEOUT = 10 * 1000;
        return new OkHttpClient.Builder()
                .hostnameVerifier(new HostnameVerifier() {
                    @Override
                    public boolean verify(String hostname, SSLSession session) {
                        return true;
                    }
                })
                .connectTimeout(DEFAULT_CONNECT_TIMEOUT, TimeUnit.SECONDS)
                .readTimeout(DEFAULT_WRITE_TIMEOUT, TimeUnit.SECONDS)
                .writeTimeout(DEFAULT_READ_TIMEOUT, TimeUnit.SECONDS);
    }


    protected <T> Observable.Transformer<T, T> applySchedulers() {
        return (Observable.Transformer<T, T>) transformer;
    }

    final Observable.Transformer transformer = new Observable.Transformer() {
        @Override
        public Object call(Object observable) {
            return ((Observable) observable)
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread());
        }
    };
}
