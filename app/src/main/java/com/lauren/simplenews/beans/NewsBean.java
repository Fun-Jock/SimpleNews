package com.lauren.simplenews.beans;

import java.io.Serializable;


public class NewsBean implements Serializable {

    /**
     * uniquekey
     */
    private String uniquekey;
    /**
     * 标题
     */
    private String title;

    /**
     * 时间
     */
    private String date;

    /**
     * 来源
     */
    private String category;
    /**
     * 小内容
     */
    private String author_name;

    /*
    * 详情地址
    * */
    private String url;

    /**
     * 图片地址
     */
    private String thumbnail_pic_s;


    /**
     * TAG
     */
    private String tag;

    public String getUniquekey() {
        return uniquekey;
    }

    public void setUniquekey(String uniquekey) {
        this.uniquekey = uniquekey;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

//    public String getDigest() {
//        return digest;
//    }
//
//    public void setDigest(String digest) {
//        this.digest = digest;
//    }

    public String getAuthor_name() {
        return author_name;
    }

    public void setAuthor_name(String author_name) {
        this.author_name = author_name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getThumbnail_pic_s() {
        return thumbnail_pic_s;
    }

    public void setThumbnail_pic_s(String thumbnail_pic_s) {
        this.thumbnail_pic_s = thumbnail_pic_s;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }
}
