package com.lauren.simplenews.holiday;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.lauren.simplenews.beans.HolidayBean;
import com.lauren.simplenews.beans.ImageBean;
import com.lauren.simplenews.utils.JsonUtils;
import com.lauren.simplenews.utils.LogUtils;

import java.util.ArrayList;
import java.util.List;


public class ImageJsonUtils {

    private final static String TAG = "ImageJsonUtils";
    /**
     * 将获取到的json转换为图片列表对象
     * @param res
     * @return
     */
    public static List<HolidayBean> readJsonImageBeans(String res) {
        List<HolidayBean> beans = new ArrayList<HolidayBean>();
        try {
            JsonParser parser = new JsonParser();
            JsonObject jsonObj = parser.parse(res).getAsJsonObject();
            JsonArray jsonArray = jsonObj.getAsJsonObject("result").getAsJsonObject("data").getAsJsonArray("holiday_list");
            for (int i = 1; i < jsonArray.size(); i++) {
                JsonObject jo = jsonArray.get(i).getAsJsonObject();
                HolidayBean news = JsonUtils.deserialize(jo, HolidayBean.class);
                beans.add(news);
            }
        } catch (Exception e) {
            LogUtils.e(TAG, "readJsonImageBeans error", e);
        }
        return beans;
    }
}
