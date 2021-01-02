package com.lauren.simplenews.holiday.model;

import com.lauren.simplenews.beans.HolidayBean;
import com.lauren.simplenews.beans.ImageBean;
import com.lauren.simplenews.commons.Urls;
import com.lauren.simplenews.holiday.ImageJsonUtils;
import com.lauren.simplenews.utils.OkHttpUtils;

import java.util.List;


public class HolidayModelImpl implements HolidayModel {

    /**
     * 获取放假安排列表
     * @param listener
     */
    @Override
    public void loadImageList(final OnLoadImageListListener listener) {
        String url = Urls.HOLIDAY_URL;
        OkHttpUtils.ResultCallback<String> loadNewsCallback = new OkHttpUtils.ResultCallback<String>() {
            @Override
            public void onSuccess(String response) {
                List<HolidayBean> iamgeBeanList = ImageJsonUtils.readJsonImageBeans(response);
                listener.onSuccess(iamgeBeanList);
            }

            @Override
            public void onFailure(Exception e) {
                listener.onFailure("load image list failure.", e);
            }
        };
        OkHttpUtils.get(url, loadNewsCallback);
    }

    public interface OnLoadImageListListener {
        void onSuccess(List<HolidayBean> list);
        void onFailure(String msg, Exception e);
    }
}
