package com.winkey.winFrame.login.contract;

import com.winkey.winlib.view.BaseView;

import java.util.HashMap;

/**
 * @author winkey
 * @date 2020/1/9
 * @describe 登录契约
 */
public interface LoginContract {
    interface Model {

    }
    interface View extends BaseView {
        @Override
        void showLoading();

        @Override
        void hideLoading();

        @Override
        void onError(Throwable throwable);

        void onLoginSuccess();

    }

    interface Presenter {
        void login(HashMap<String, Object> requestMap);
    }
}
