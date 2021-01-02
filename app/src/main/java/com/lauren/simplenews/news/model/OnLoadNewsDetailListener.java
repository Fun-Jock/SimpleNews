package com.lauren.simplenews.news.model;

import com.lauren.simplenews.beans.NewsDetailBean;


public interface OnLoadNewsDetailListener {
//加载新闻具体信息的事件监听
    void onSuccess(NewsDetailBean newsDetailBean);

    void onFailure(String msg, Exception e);
}
