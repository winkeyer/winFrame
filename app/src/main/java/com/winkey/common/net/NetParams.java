package com.winkey.common.net;

import android.text.TextUtils;

import com.blankj.utilcode.util.ActivityUtils;
import com.blankj.utilcode.util.AppUtils;
import com.blankj.utilcode.util.DeviceUtils;
import com.blankj.utilcode.util.ToastUtils;
import com.winkey.common.db.ProfileManager;
import com.winkey.common.db.UserProfile;

import java.util.HashMap;

/**
 * 网络请求公共参数
 *
 * @author xiongz
 * @date 2018/9/27
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
