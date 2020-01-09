package com.winkey.winlib.rx;

import android.content.Context;

import io.reactivex.disposables.Disposable;

/**
 * rx模式网络请求管理接口
 * Created by xiongz on 2017/12/18.
 */
public interface RxActionManager {

    void add(Context context, Disposable disposable);

    void remove(Context context, Disposable disposable);

    void cancel(Context context);
}
