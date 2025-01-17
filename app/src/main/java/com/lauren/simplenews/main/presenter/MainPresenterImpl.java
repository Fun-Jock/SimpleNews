package com.lauren.simplenews.main.presenter;

import com.lauren.simplenews.main.view.MainView;
import com.lauren.simplenews.R;

public class MainPresenterImpl implements MainPresenter {

    private MainView mMainView;

    public MainPresenterImpl(MainView mainView) {
        this.mMainView = mainView;
    }

    @Override
    public void switchNavigation(int id) {
        switch (id) {
            case R.id.navigation_item_news:
                mMainView.switch2News();
                break;
//            case R.id.navigation_item_images:
//                mMainView.switch2Images();
//                break;
            case R.id.navigation_item_weather:
                mMainView.switch2Weather();
                break;
//            case R.id.navigation_item_about:
//                mMainView.switch2About();
//                break;
            default:
                mMainView.switch2News();
                break;
        }
    }
}
