package com.winkey.winFrame.contract;

import com.winkey.winFrame.model.vo.LoginEntity;
import com.winkey.winFrame.model.vo.MainEntity;
import com.winkey.winlib.view.BaseView;

import java.util.HashMap;

/**
 * @author winkey
 * @date 2020/1/8
 * @describe Main契约接口
 */
public interface MainContract {

    interface View extends BaseView {
        @Override
        void showLoading();

        @Override
        void hideLoading();

        @Override
        void onError(Throwable throwable);

        void onMain(MainEntity mainEntity);

    }

    interface Presenter {

        void main(HashMap<String, Object> requestMap);

        void login(HashMap<String, Object> requestMap);
    }
}
