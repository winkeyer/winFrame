package com.winkey.winlib.view;

/**
 * @author winkey
 * @date 2020/1/8
 * @describe 基础视图接口
 */
public interface BaseView{

    /**
     * 显示加载框
     */
    void showLoading();

    /**
     * 隐藏加载框
     */
    void hideLoading();
    /**
     * 请求异常
     * @param throwable 异常
     */
    void onError(Throwable throwable);

}
