package com.lauren.simplenews.holiday.presenter;

import com.lauren.simplenews.beans.HolidayBean;
import com.lauren.simplenews.beans.ImageBean;
import com.lauren.simplenews.holiday.model.HolidayModel;
import com.lauren.simplenews.holiday.model.HolidayModelImpl;
import com.lauren.simplenews.holiday.view.ImageView;

import java.util.List;


public class HolidayPresenterImpl implements HolidayPresenter, HolidayModelImpl.OnLoadImageListListener {

    private HolidayModel mHolidayModel;
    private ImageView mImageView;

    public HolidayPresenterImpl(ImageView imageView) {
        this.mHolidayModel = new HolidayModelImpl();
        this.mImageView = imageView;
    }

    @Override
    public void loadImageList() {
        mImageView.showProgress();
        mHolidayModel.loadImageList(this);
    }

    @Override
    public void onSuccess(List<HolidayBean> list) {
        mImageView.addImages(list);
        mImageView.hideProgress();
    }

    @Override
    public void onFailure(String msg, Exception e) {
        mImageView.hideProgress();
        mImageView.showLoadFailMsg();
    }
}
