package com.lauren.simplenews.holiday.view;

import com.lauren.simplenews.beans.HolidayBean;
import com.lauren.simplenews.beans.ImageBean;

import java.util.List;


public interface ImageView {
    void addImages(List<HolidayBean> list);
    void showProgress();
    void hideProgress();
    void showLoadFailMsg();
}
