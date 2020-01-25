package com.winkey.winFrame.common.net;

import android.text.TextUtils;

import com.winkey.winFrame.common.db.ProfileManager;
import com.winkey.winFrame.common.db.UserProfile;

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
        // UserProfile userProfile = ProfileManager.getCurUserProfile();
        UserProfile userProfile = ProfileManager.getCurUserProfile();
        String token = userProfile.getToken();
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
     * header参数
     *
     * @return
     */
    public static HashMap<String, Object> getHeaderParams() {
        HashMap<String, Object> params = new HashMap<>();
        params.put("Content-Type", "application/x-www-form-urlencoded");
        UserProfile userProfile = ProfileManager.getCurUserProfile();
        String token = userProfile.getToken();
        if (TextUtils.isEmpty(token)) {
            /*ToastUtils.showLong("token过期,请重新登录!");
            ActivityUtils.startActivity(LoginActivity.class);*/
        } else {
            params.put("token", token);
        }
        return params;
    }


}
