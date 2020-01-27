package com.winkey.commonlib.net;

import com.blankj.utilcode.util.SPUtils;
import com.winkey.commonlib.BuildConfig;
import com.winkey.commonlib.constant.Const;

/**
 * @author winkey
 * @date 2020/1/9
 * @describe 网络服务管理类
 */
public class NetManager {

    private static final class Holder {
        private static final NetManager INSTANCE = new NetManager();
    }

    public static NetManager getInstance() {
        return NetManager.Holder.INSTANCE;
    }

    /**
     * 获取请求url
     *
     * @param route 路由
     * @return
     */
    public String getUrl(String route) {
        // 获取当前网络服务(默认电信)
        int curNetIndex = SPUtils.getInstance().getInt(Const.NET_ROUTE_INDEX, 0);
        if (BuildConfig.DEBUG) {
            if(curNetIndex==10000){
                String customNet = SPUtils.getInstance().getString(Const.NET_ROUTE_CUSTOM_ALL,"106.12.46.79");
                return "http://" + customNet + route;
            }
            return "http://" + Const.NET_PING_DEV[curNetIndex] + route;
        } else {
            return "http://" + Const.NET_PING[curNetIndex] + route;
        }
    }
}
