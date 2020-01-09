package com.winkey.winFrame.presenter;

import android.content.Context;

import com.alibaba.fastjson.JSONObject;
import com.blankj.utilcode.util.ToastUtils;
import com.winkey.common.db.UserProfile;
import com.winkey.common.net.ConstUrl;
import com.winkey.common.net.NetManager;
import com.winkey.common.net.ObserverProxy;
import com.winkey.winFrame.contract.MainContract;
import com.winkey.winFrame.model.vo.LoginEntity;
import com.winkey.winFrame.model.vo.MainEntity;
import com.winkey.winlib.presenter.BasePresenter;
import com.winkey.winlib.rx.RxNetClient;
import com.winkey.winlib.util.FastjsonUtil;

import java.io.IOException;
import java.net.ConnectException;
import java.net.SocketTimeoutException;
import java.util.HashMap;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.HttpException;

/**
 * @author winkey
 * @date 2020/1/8
 * @describe Main Presenter
 */
public class MainPresenter extends BasePresenter<MainContract.View> implements MainContract.Presenter {

    private Context context;
    // 用户信息
    private UserProfile userProfile = new UserProfile();
    public MainPresenter(Context context){
        this.context = context;
    }
    @Override
    public void register(MainContract.View baseView) {
        super.register(baseView);
    }

    @Override
    public void unregister() {
        super.unregister();
    }

    @Override
    public boolean isViewAttached() {
        return super.isViewAttached();
    }

    @Override
    public void main(HashMap<String, Object> requestMap) {
        if (!isViewAttached())
            return;
        String url = NetManager.getInstance().getUrl(ConstUrl.APP_LOGIN);
        String body = FastjsonUtil.toJSONString(requestMap);
        mView.showLoading();
        RxNetClient.builder()
                .url(url)
                .params(requestMap)
                .build()
                .postParams()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new ObserverProxy(context, url, body, new Observer<String>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                    }

                    @Override
                    public void onNext(String result) {
                        MainEntity mainEntity = FastjsonUtil.parseObject(result, MainEntity.class);
                        mView.onMain(mainEntity);
                    }

                    @Override
                    public void onError(Throwable e) {
                        e.printStackTrace();
                    }

                    @Override
                    public void onComplete() {
                       mView.hideLoading();
                    }
                }));
    }

    @Override
    public void login(final HashMap<String, Object> requestMap) {
        if (!isViewAttached())
            return;
        final String url = NetManager.getInstance().getUrl(ConstUrl.APP_LOGIN);
        mView.showLoading();
        RxNetClient.builder()
                .url(url)
                .params(requestMap)
                .build()
                .postParams()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<String>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                    }

                    @Override
                    public void onNext(String result) {

                        parseLoginData(result, requestMap); }

                    @Override
                    public void onError(Throwable e) {
                        if (e instanceof SocketTimeoutException) {
                            ToastUtils.showLong("网络超时,请稍后再试!" + e.getMessage());
                        } else if (e instanceof ConnectException) {
                            // 连接超时处理
                            //ActivityUtils.startActivity(NetErrorActivity.class);
                        }
                        if (e instanceof HttpException) {
                            try {
                                HttpException exception = (HttpException) e;
                                JSONObject jsonObject = new FastjsonUtil().parseObject(exception.response().errorBody().string());
                                String code;
                                String message;
                                if (jsonObject != null) {
                                    code = jsonObject.getString("code");
                                    if (code == null) {
                                        ToastUtils.showLong("请求错误");
                                    } else if (code.equals("401")) {
                                        message = jsonObject.getString("message");
                                        ToastUtils.showLong(message);
                                    } else if (!code.equals("200")) {
                                        message = jsonObject.getString("message");
                                        ToastUtils.showLong("服务器错误，错误代码：" + code + ",错误消息:" + message);
                                    }
                                } else {
                                    ToastUtils.showLong("服务器未知错误");
                                }

                            } catch (IOException e1) {
                                e1.printStackTrace();
                            }
                        }
                    }

                    @Override
                    public void onComplete() {
                        mView.hideLoading();
                    }
                });
    }

    /**
     * 解析用户信息返回数据
     */
    private void parseLoginData(String result, HashMap<String, Object> params) {
        LoginEntity loginEntity = FastjsonUtil.parseObject(result, LoginEntity.class);
        if (null != loginEntity) {

            userProfile.setToken(loginEntity.getToken());
            String password = (String) params.get("password");
            // requestUserInfo(loginEntity.getToken(), password);
            // 解析本地省市区json数据
            // initRegionData();

        } else {
            ToastUtils.showLong("登录出现错误");
        }
    }

}
