package com.winkey.winFrame.common.net;


import com.winkey.winFrame.BuildConfig;
/**
 * @author winkey
 * @date 2020/1/9
 * @describe URL网络常量
 */
public class ConstUrl {


    // ping地址
    public static String PING_DEV = "106.12.46.79";        // 开发环境
    public static String PING_DOMAIN = "139.224.133.163";        // 正式环境
    private static String HOST = ":8889";



    // 登录
    public static final String APP_LOGIN = HOST + "/login";
    // 用户信息
    public static final String USER_INFO = HOST + "/users/current";


}
