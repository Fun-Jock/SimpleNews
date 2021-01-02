package com.lauren.simplenews.commons;


public class Urls {

    //http://c.m.163.com/nc/article/headline/T1348647909107/0-5.html  头条

    public static final String TOUTIAO = "http://v.juhe.cn/toutiao/index?type=top&key=c0a97b472c428576e9fcafaa6b2a41fa";

    public static final String TIYU = "http://v.juhe.cn/toutiao/index?type=tiyu&key=c0a97b472c428576e9fcafaa6b2a41fa";

    public static final String CAIJING = "http://v.juhe.cn/toutiao/index?type=caijing&key=c0a97b472c428576e9fcafaa6b2a41fa";

    public static final String YULE = "http://v.juhe.cn/toutiao/index?type=yule&key=c0a97b472c428576e9fcafaa6b2a41fa";

    public static final int PAZE_SIZE = 20;

    public static final String HOST = "http://c.m.163.com/";
    public static final String END_URL = "-" + PAZE_SIZE + ".html";
    public static final String END_DETAIL_URL = "/full.html";
    // 头条
    public static final String TOP_URL = HOST + "nc/article/headline/";
    public static final String TOP_ID = "T1348647909107";
    // 新闻详情
    public static final String NEW_DETAIL = HOST + "nc/article/";

    public static final String COMMON_URL = HOST + "nc/article/list/";

    // 汽车
//    public static final String CAR_ID = "T1348654060988";


    // 汽车
    public static final String MOVIE_ID = "T1348648650048";
    // 笑话
    public static final String JOKE_ID = "T1350383429665";
    // nba
    public static final String NBA_ID = "T1348649145984";

    // 图片
//    public static final String IMAGES_URL = "http://api.laifudao.com/open/tupian.json";
    // 节假日安排
//    public static final String HOLIDAY_URL = "http://v.juhe.cn/calendar/year?year=2020&key=524d49c165c6450fda8f90057c3c1497";

    // 天气预报url
    public static final String WEATHER = "http://wthrcdn.etouch.cn/weather_mini?city=";

    //百度定位
    public static final String INTERFACE_LOCATION = "http://api.map.baidu.com/geocoder";

}
