package com.winkey.commonlib.constant;

/**
 * @author xuwenbin
 * @date 2020/1/27
 * @describe TODO
 */
public class Router {
    // 用户服务
    public static final String USER_SERVICE = "/userService/";
    public static final String USER_INFO = USER_SERVICE+"userInfo";
    public static final String PARAM_INFO = USER_SERVICE+"paramInfo";

    // 登录模组
    public static final String LOGIN_MODULE = "/loginModule/";
    public static final String LOGIN_ACTIVITY = LOGIN_MODULE + "login";

    // 主模组
    public static final String MAIN_MODULE_NAME = "/mainModule/";
    public static final String LAUNCHER_ACTIVITY = MAIN_MODULE_NAME + "launcher";
    public static final String MAIN_ACTIVITY = MAIN_MODULE_NAME + "main";
    public static final String SETTING_ACTIVITY = MAIN_MODULE_NAME + "setting";

    // 巡检模组
    public static final String PATROL_MODULE_NAME = "/patrolModule/";
    public static final String PATROL_ACTIVITY = PATROL_MODULE_NAME + "manage";

    // 项目模组
    public static final String PROJECT_MODULE_NAME = "/projectModule/";
    public static final String PROJECT_ACTIVITY = PROJECT_MODULE_NAME + "manage";
}
