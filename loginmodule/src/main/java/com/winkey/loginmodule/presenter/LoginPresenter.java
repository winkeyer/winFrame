package com.winkey.loginmodule.presenter;

import android.content.Context;
import android.text.TextUtils;

import com.alibaba.android.arouter.facade.annotation.Autowired;
import com.alibaba.android.arouter.launcher.ARouter;
import com.alibaba.fastjson.JSONObject;
import com.blankj.utilcode.util.SPUtils;
import com.blankj.utilcode.util.ToastUtils;
import com.winkey.commonlib.constant.Const;
import com.winkey.commonlib.constant.ConstUrl;
import com.winkey.commonlib.db.SysParamManager;
import com.winkey.commonlib.model.po.UserProfile;
import com.winkey.commonlib.model.vo.PermissionsEntity;
import com.winkey.commonlib.net.NetManager;
import com.winkey.commonlib.net.ObserverProxy;
import com.winkey.commonlib.router.UserService;
import com.winkey.loginmodule.contract.LoginContract;
import com.winkey.loginmodule.model.vo.LoginEntity;
import com.winkey.loginmodule.model.vo.UserInfoEntity;
import com.winkey.winlib.app.AccountManager;
import com.winkey.winlib.presenter.BasePresenter;
import com.winkey.winlib.rx.RxNetClient;
import com.winkey.winlib.ui.loader.XzLoader;
import com.winkey.winlib.util.FastjsonUtil;

import java.io.IOException;
import java.net.ConnectException;
import java.net.SocketTimeoutException;
import java.util.HashMap;
import java.util.List;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.HttpException;

/**
 * @author winkey
 * @date 2020/1/9
 * @describe 登录Presenter类
 */
public class LoginPresenter extends BasePresenter<LoginContract.View> implements LoginContract.Presenter {

    // 上下文
    private Context mContext;

    @Autowired
    UserService userService;

    // 用户信息
    private UserProfile userProfile = new UserProfile();
    public LoginPresenter(Context context){
        ARouter.getInstance().inject(this);
        this.mContext = context;
    }
    @Override
    public void login(final HashMap<String, Object> requestMap) {
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
                .subscribe( new Observer<String>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                    }

                    @Override
                    public void onNext(String result) {
                        parseLoginData(result, requestMap);
                    }

                    @Override
                    public void onError(Throwable e) {
                        mView.onError(e);
                        if (e instanceof SocketTimeoutException) {
                            ToastUtils.showLong("网络超时,请稍后再试!" + e.getMessage());
                        } else if (e instanceof ConnectException) {
                            // ActivityUtils.startActivity(NetErrorActivity.class);
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

            mView.showLoading();
            requestUserInfo(loginEntity.getToken(), password);
            // 解析本地省市区json数据
            // initRegionData();

        } else {
            ToastUtils.showLong("登录出现错误");
        }
    }

    /**
     * 获取用户信息
     */
    public void requestUserInfo(String token, final String password) {
        SPUtils.getInstance().put(Const.TOKEN, token);
        HashMap<String, Object> headerParams = new HashMap<>();
        headerParams.put("token", token);
        String url = NetManager.getInstance().getUrl(ConstUrl.USER_INFO);
        String body = FastjsonUtil.toJSONString(headerParams);
        mView.showLoading();
        RxNetClient.builder()
                .url(url)
                .build()
                .get()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new ObserverProxy(mContext, url, body, new Observer<String>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                    }

                    @Override
                    public void onNext(String result) {
                        parseUserData(result, password);
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

    /**
     * 解析返回数据
     */
    private void parseUserData(String result, String password) {
        UserInfoEntity userInfoEntity = FastjsonUtil.parseObject(result, UserInfoEntity.class);
        if (null != userInfoEntity) {
            userProfile.setId((long) userInfoEntity.getId());
            userProfile.setUsername(userInfoEntity.getUsername());
            userProfile.setNickname(userInfoEntity.getNickname());
            userProfile.setRole(userInfoEntity.getRole());
            userProfile.setRoleCode(userInfoEntity.getRoleCode());
            userProfile.setHeadImgUrl(userInfoEntity.getHeadImgUrl());
            userProfile.setPermissions((List<PermissionsEntity>) userInfoEntity.getPermissions());

            // 用户信息变化则存入数据库
            UserProfile oldUserProfile = userService.getUserProfile();
            if (oldUserProfile == null || (oldUserProfile.getToken() != null
                    && !TextUtils.equals(oldUserProfile.getToken(), userProfile.getToken()))) {
                userService.insertUserProfile(userProfile, password);
            }

            mView.showLoading();
            // 获取系统参数
            SysParamManager.getInstance().setOnCompleteRequest(new SysParamManager.OnCompleteRequest() {
                @Override
                public void onComplete() {
                    XzLoader.dismissDialog();
                    AccountManager.setLoginState(true);
                    mView.onLoginSuccess();
                }
            }).getSysParams(mContext);
            AccountManager.setLoginState(true);
        } else {
            ToastUtils.showLong("获取用户信息失败");
        }
    }
}
