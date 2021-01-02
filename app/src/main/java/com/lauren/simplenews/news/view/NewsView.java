package com.lauren.simplenews.news.view;

import com.lauren.simplenews.beans.NewsBean;

import java.util.List;


public interface NewsView {

    void showProgress();

    void addNews(List<NewsBean> newsList);

    void hideProgress();

    void showLoadFailMsg();
}
