package com.winkey.winlib.presenter;

import com.winkey.winlib.view.BaseView;

/**
 * @author winkey
 * @date 2020/1/8
 * @describe 基础Presenter
 */
public abstract class BasePresenter<V extends BaseView> {

    protected V mView;


    public void register(V baseView) {
        this.mView = baseView;
    }


    public void unregister() {
        this.mView = null;
    }

    /**
     * View是否绑定
     *
     * @return
     */
    public boolean isViewAttached() {
        return mView != null;
    }

}
