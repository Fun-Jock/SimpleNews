package com.lauren.simplenews.news.presenter;

import com.lauren.simplenews.beans.NewsBean;
import com.lauren.simplenews.commons.Urls;
import com.lauren.simplenews.news.model.NewsModel;
import com.lauren.simplenews.news.model.NewsModelImpl;
import com.lauren.simplenews.news.model.OnLoadNewsListListener;
import com.lauren.simplenews.news.view.NewsView;
import com.lauren.simplenews.news.widget.NewsFragment;
import com.lauren.simplenews.utils.LogUtils;

import java.util.List;


public class NewsPresenterImpl implements NewsPresenter, OnLoadNewsListListener {

    private static final String TAG = "NewsPresenterImpl";

    private NewsView mNewsView;
    private NewsModel mNewsModel;

    public NewsPresenterImpl(NewsView newsView) {
        this.mNewsView = newsView;
        this.mNewsModel = new NewsModelImpl();
    }

    @Override
    public void loadNews(final int type, final int pageIndex) {
        String url = getUrl(type, pageIndex);
        LogUtils.d(TAG, url);
        //只有第一页的或者刷新的时候才显示刷新进度条
        if(pageIndex == 0) {
            mNewsView.showProgress();
        }
        mNewsModel.loadNews(url, type, this);
    }

    /**
     * 根据类别和页面索引创建url
     * @param type
     * @param pageIndex
     * @return
     */
    private String getUrl(int type, int pageIndex) {
        StringBuffer sb = new StringBuffer();
        switch (type) {
            case NewsFragment.NEWS_TYPE_TOP:
                sb.append(Urls.TOUTIAO);

                break;
            case NewsFragment.NEWS_TYPE_TIYU:
                sb.append(Urls.TIYU);
                break;
            case NewsFragment.NEWS_TYPE_YULE:
                sb.append(Urls.YULE);
                break;
            case NewsFragment.NEWS_TYPE_CAIJING:
                sb.append(Urls.CAIJING);
                break;
            default:
                sb.append(Urls.TOP_URL).append(Urls.TOP_ID);
                break;
        }
//        sb.append("/").append(pageIndex).append(Urls.END_URL);
        return sb.toString();
    }



    @Override
    public void onSuccess(List<NewsBean> list) {
        mNewsView.hideProgress();
        mNewsView.addNews(list);
    }

    @Override
    public void onFailure(String msg, Exception e) {
        mNewsView.hideProgress();
        mNewsView.showLoadFailMsg();
    }
}
