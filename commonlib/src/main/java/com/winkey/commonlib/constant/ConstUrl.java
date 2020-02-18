package com.winkey.commonlib.constant;


import com.winkey.commonlib.BuildConfig;

/**
 * @author winkey
 * @date 2020/1/9
 * @describe URL网络常量
 */
public class ConstUrl {


    // ping地址
    public static String PING_DEV = "106.12.46.79";        // 开发环境
    public static String PING_DOMAIN = "139.224.133.163";        // 正式环境
    public static String HOST = ":8889";



    /*******  baseUrl *******/
    // 图片前缀
    public static String HOST_IMAGE_DEV = "http://106.12.46.79:8889/statics/";
    public static String HOST_IMAGE_DOMAIN = "http://139.224.133.163:8889/statics/";
    public static String HOST_IMAGE = BuildConfig.DEBUG ? HOST_IMAGE_DEV : HOST_IMAGE_DOMAIN;

    // 登录
    public static final String APP_LOGIN = HOST + "/login";
    // 用户信息
    public static final String USER_INFO = HOST + "/users/current";
    // 用户信息
    public static final String HOME_MENU = HOST + "/permissions/mobile/menu";
    // 系统参数
    public static final String DICTIONARY_ALL = HOST + "/dicts/all";


    // 巡检列表
    public static final String PATROL_LIST = ConstUrl.HOST + "/patrol/planList";


}
