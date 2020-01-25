package com.winkey.winFrame.common.constant;


import com.winkey.winFrame.common.net.ConstUrl;

/**
 * @author winkey
 * @date 2020/1/9
 * @describe 常量
 */
public class Const {

    // 网络线路下标
    public final static String NET_ROUTE_INDEX = "net_route_index";
    public final static String NET_ROUTE_CUSTOM_ALL = "net_route_custom_all";
    public final static String[] NET_PING = {ConstUrl.PING_DOMAIN, ConstUrl.PING_DOMAIN};
    public final static String[] NET_ROUTES_DEV = {"测试服务  ", "正式服务  "};
    public final static String[] NET_PING_DEV = {ConstUrl.PING_DEV, ConstUrl.PING_DOMAIN};
}
