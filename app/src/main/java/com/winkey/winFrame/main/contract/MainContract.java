package com.winkey.winFrame.main.contract;

import com.winkey.winFrame.main.model.vo.HomeMenuEntity;
import com.winkey.winFrame.main.model.vo.NewsBannerEntity;
import com.winkey.winlib.view.BaseView;

import java.util.HashMap;
import java.util.List;

/**
 * @author winkey
 * @date 2020/1/9
 * @describe 登录契约
 */
public interface MainContract {
    interface Model {

    }
    interface View extends BaseView {
        @Override
        void showLoading();

        @Override
        void hideLoading();

        @Override
        void onError(Throwable throwable);

        void onNotifyBanner(List<NewsBannerEntity> datas);

        void onNotifyMenu(List<HomeMenuEntity> datas);

    }

    interface Presenter {
        void requestMenu();
        void requestBanner();
    }
}
