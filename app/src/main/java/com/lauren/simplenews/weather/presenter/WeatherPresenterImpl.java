package com.lauren.simplenews.weather.presenter;

import android.content.Context;

import com.lauren.simplenews.beans.WeatherBean;
import com.lauren.simplenews.utils.ToolsUtil;
import com.lauren.simplenews.weather.model.WeatherModel;
import com.lauren.simplenews.weather.model.WeatherModelImpl;
import com.lauren.simplenews.weather.view.WeatherView;

import java.util.List;


public class WeatherPresenterImpl implements WeatherPresenter, WeatherModelImpl.LoadWeatherListener {

    private WeatherView mWeatherView;
    private WeatherModel mWeatherModel;
    private Context mContext;

    public WeatherPresenterImpl(Context context, WeatherView weatherView) {
        this.mContext = context;
        this.mWeatherView = weatherView;
        mWeatherModel = new WeatherModelImpl();
    }

    @Override
    public void loadWeatherData() {
        mWeatherView.showProgress();
        if(!ToolsUtil.isNetworkAvailable(mContext)) {
            mWeatherView.hideProgress();
            mWeatherView.showErrorToast("无网络连接");
            return;
        }

        WeatherModelImpl.LoadLocationListener listener = new WeatherModelImpl.LoadLocationListener() {
            @Override
            public void onSuccess(String cityName) {
                //定位成功，获取定位城市天气预报
                mWeatherView.setCity(cityName);  //先展示城市名称，然后再拿城市名去获取信息
                mWeatherModel.loadWeatherData(cityName, WeatherPresenterImpl.this);
            }

            @Override
            public void onFailure(String msg, Exception e) {
                mWeatherView.showErrorToast("定位失败");
                mWeatherView.setCity("深圳");
                mWeatherModel.loadWeatherData("深圳", WeatherPresenterImpl.this);
            }
        };
        //获取定位信息
        mWeatherModel.loadLocation(mContext, listener);
    }

    @Override
    public void onSuccess(List<WeatherBean> list) { //实现回调功能，
        // 将在WeatherModeImpl获取的List进行回调到view中进行展示

        if(list != null && list.size() > 0) {
            WeatherBean todayWeather = list.remove(0);
            mWeatherView.setToday(todayWeather.getDate());
            mWeatherView.setTemperature(todayWeather.getTemperature());
            mWeatherView.setWeather(todayWeather.getWeather());
            mWeatherView.setWind(todayWeather.getWind());
            mWeatherView.setWeatherImage(todayWeather.getImageRes());
        }
        mWeatherView.setWeatherData(list);
        mWeatherView.hideProgress();
        mWeatherView.showWeatherLayout();
    }

    @Override
    public void onFailure(String msg, Exception e) {
        mWeatherView.hideProgress();
        mWeatherView.showErrorToast("获取天气数据失败");
    }

}
