package com.winkey.commonlib.net.interceptors;

import android.text.TextUtils;

import com.alibaba.android.arouter.facade.annotation.Autowired;
import com.alibaba.android.arouter.launcher.ARouter;
import com.blankj.utilcode.util.ToastUtils;
import com.winkey.commonlib.constant.Router;
import com.winkey.commonlib.db.ProfileManager;
import com.winkey.commonlib.constant.ConstUrl;
import com.winkey.commonlib.model.vo.LoginEntity;
import com.winkey.commonlib.net.NetManager;
import com.winkey.commonlib.router.UserService;
import com.winkey.winlib.app.AccountManager;
import com.winkey.winlib.rx.RxNetClient;
import com.winkey.winlib.util.Base64Util;
import com.winkey.winlib.util.FastjsonUtil;

import java.io.IOException;
import java.util.HashMap;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * @author xuwenbin
 * @date 2020/1/27
 * @describe Token拦截器
 */
public class TokenInterceptor implements Interceptor {
    @Autowired
    UserService userService;
    @Override
    public Response intercept(Chain chain) throws IOException {
        Request request = chain.request();
        userService = ARouter.getInstance().navigation(UserService.class);
        if(request.url().url().toString().contains(ConstUrl.APP_LOGIN)){
            // 如果是登录接口，则不插入token
            return chain.proceed(request);
        }else if(userService !=null &&userService.getUserInfo()!=null
                && !TextUtils.isEmpty(userService.getUserInfo().getToken())&& AccountManager.isLogin()){
            Request authorised = request.newBuilder()
                    .addHeader("Authorization", userService.getUserInfo().getToken())
                    .method(request.method(), request.body())
                    .build();
            Response response = chain.proceed(authorised);//执行此次请求
            if(response.code() == 401){
                ToastUtils.showLong("重新拉取token");
                HashMap<String, Object> params = new HashMap<>();
                params.put("username", userService.getUserInfo().getUsername());
                params.put("password", Base64Util.getDecodeStr(userService.getUserInfo().getPassword()));
                String url = NetManager.getInstance().getUrl(ConstUrl.APP_LOGIN);
                // 此处如果发现401 token过期，需要使用同步方法，防止异步到来token失效的问题
                String result = RxNetClient.builder()
                        .url(url)
                        .params(params)
                        .build()
                        .callMethod()
                        .execute()
                        .body()
                        .toString();
                LoginEntity loginEntity = FastjsonUtil.parseObject(result,LoginEntity.class);
                ProfileManager.refreshToken(userService.getUserInfo(),loginEntity.getToken());
                Request newRequest = request.newBuilder()
                        .header("token", userService.getUserInfo().getToken())
                        .build();
                return chain.proceed(newRequest);
            }
            return response;
        }else{
            // 如果userService为空，或者数据库为空，或者数据库中没有token，则进入登录页面
            ARouter.getInstance().build(Router.LOGIN_MOUDLE_ACTIVITY).navigation();
            return null;
        }

    }
}
