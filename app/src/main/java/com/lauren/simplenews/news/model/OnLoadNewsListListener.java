package com.lauren.simplenews.news.model;

import com.lauren.simplenews.beans.NewsBean;

import java.util.List;


public interface OnLoadNewsListListener {
//加载新闻列表的事件监听
    void onSuccess(List<NewsBean> list);

    void onFailure(String msg, Exception e);
}
