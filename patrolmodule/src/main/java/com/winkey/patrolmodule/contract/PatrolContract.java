package com.winkey.patrolmodule.contract;

import com.winkey.patrolmodule.model.vo.PatrolEntity;
import com.winkey.winlib.view.BaseView;

import java.util.HashMap;
import java.util.List;

/**
 * @author winkey
 * @date 2020/1/9
 * @describe 登录契约
 */
public interface PatrolContract {
    interface Model {

    }
    interface View extends BaseView {
        @Override
        void showLoading();

        @Override
        void hideLoading();

        @Override
        void onError(Throwable throwable);


        void onNotifyPatrol(int total,List<PatrolEntity> datas);

    }

    interface Presenter {
        void requestPatrol(HashMap<String,Object> params);
    }
}
