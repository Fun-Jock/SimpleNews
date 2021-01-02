package com.lauren.simplenews.beans;

import java.io.Serializable;

public class HolidayBean implements Serializable {
    //名称
    private String name;
    //节日开始时间
    private String startday;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStartday() {
        return startday;
    }

    public void setStartday(String startday) {
        this.startday = startday;
    }
}
