package com.winkey.commonlib.net;

import android.content.Context;

import com.alibaba.fastjson.JSONObject;
import com.blankj.utilcode.util.NetworkUtils;
import com.blankj.utilcode.util.ToastUtils;
import com.winkey.winlib.rx.RxApiManager;
import com.winkey.winlib.ui.loader.XzLoader;
import com.winkey.winlib.util.FastjsonUtil;

import java.io.IOException;
import java.net.ConnectException;
import java.net.SocketTimeoutException;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import retrofit2.HttpException;

/**
 * @author 网络请求观察代理类
 * @date 2020/1/9
 * @describe 常量
 */
public class ObserverProxy implements Observer<String> {

    // 上下文
    private Context mContext;
    //被观察者
    private Observer<String> mObserver;
    // 请求URL
    private String mUrl;
    // 请求Body
    private String mBody;

    public ObserverProxy(Context context, String url, String body, Observer<String> observer) {
        mContext = context;
        mObserver = observer;
        mUrl = url;
        mBody = body;
    }

    @Override
    public void onSubscribe(Disposable d) {
        if (NetworkUtils.isConnected()) {
            RxApiManager.getInstance().add(mContext, d);
            mObserver.onSubscribe(d);
        } else {
            XzLoader.dismissDialog();
            // ActivityUtils.startActivity(NetErrorActivity.class);
        }
    }

    @Override
    public void onNext(String s) {
        try {
            //todo token过期的code如果特殊，可以直接走此处判断
            /*JSONObject js = (JSONObject) JSON.parse(s);
            int code = js.getInteger("code");
            String message = js.getString("message");
            if (code == ConstUrl.TOKEN_ERROR) { // token过期，则重新登录
                XzLoader.dismissDialog();
                ToastUtils.showLong(message);
                ActivityUtils.startActivity(LoginActivity.class);
            } else {
                mObserver.onNext(s);
            }*/
            mObserver.onNext(s);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onError(Throwable e) {
        if (e instanceof SocketTimeoutException) {
            ToastUtils.showLong("网络超时,请稍后再试!" + e.getMessage());
        } else if (e instanceof ConnectException) {
            // ActivityUtils.startActivity(NetErrorActivity.class);
        }
        if (e instanceof HttpException) {
            try {
                HttpException exception = (HttpException) e;
                JSONObject jsonObject = new FastjsonUtil().parseObject(exception.response().errorBody().string());
                String code = exception.response().headers().toString();
                String message = "";
                if (jsonObject != null) {
                    code = jsonObject.getString("code");
                    if (code == null) {
                        ToastUtils.showLong("请求错误");
                    } else if (code.equals("401")) {
                        /*ToastUtils.showLong("登录信息已超时，请重新登录");
                        // 设置系统配置参数为空
                        SysParamModel.getInstance().setNull();
                        // 删除本地数据库用户数据
                        ProfileManager.clearUserProfile();
                        // 设置当前未登录
                        AccountManager.setLoginState(false);
                        // 退出
                        ActivityUtils.startActivity(LoginActivity.class);*/
                    } else if (!code.equals("200")) {
                        message = jsonObject.getString("message");
                        ToastUtils.showLong(message);
                        /*if(BuildConfig.isDebug){
                            ToastUtils.showLong("服务器错误，错误代码：" + code + ",错误消息:" + message);
                        }else{

                            ToastUtils.showLong(message);
                        }*/

                    }
                } else {
                    ToastUtils.showLong("服务器未知错误");
                }


            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }
        XzLoader.dismissDialog();
        mObserver.onError(e);
    }

    @Override
    public void onComplete() {
        mObserver.onComplete();
    }
}
