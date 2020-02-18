package com.winkey.commonlib.net;

import android.text.TextUtils;

import com.alibaba.android.arouter.launcher.ARouter;
import com.winkey.commonlib.constant.Const;
import com.winkey.commonlib.router.UserService;

import java.util.HashMap;

/**
 * @author winkey
 * @date 2020/1/9
 * @describe 网络请求公共参数
 */
public class NetParams {

    /**
     * 获取接口参数
     *
     * @return
     */
    public static HashMap<String, Object> getPostHeaderParams() {
        HashMap<String, Object> params = new HashMap<>();

        UserService userService = ARouter.getInstance().navigation(UserService.class);
        String token = userService.getToken();
        if (TextUtils.isEmpty(token)) {
            // token过期的情况 TODO
            /*ToastUtils.showLong("token过期,请重新登录!");
            ActivityUtils.startActivity(LoginActivity.class);*/
        } else {
            params.put("token", token);
        }
        return params;
    }

    /**
     * 拼接翻页接口url后缀
     *
     * @param page
     * @return
     */
    public static HashMap<String, Object> getPageHashMap(int page) {
        HashMap<String,Object> hashMap = new HashMap<>();
        hashMap.put("pageNumber", page);
        hashMap.put("pageSize", Const.PAGE_SIZE);
        return hashMap;
    }

    /**
     * header参数
     *
     * @return
     */
    public static HashMap<String, Object> getHeaderParams() {
        HashMap<String, Object> params = new HashMap<>();
        params.put("Content-Type", "application/x-www-form-urlencoded");
        UserService userService = ARouter.getInstance().navigation(UserService.class);
        String token = userService.getToken();
        if (TextUtils.isEmpty(token)) {
            /*ToastUtils.showLong("token过期,请重新登录!");
            ActivityUtils.startActivity(LoginActivity.class);*/
        } else {
            params.put("token", token);
        }
        return params;
    }


}
