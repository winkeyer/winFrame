package com.winkey.winlib.fragments;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;

import com.alibaba.android.arouter.launcher.ARouter;
import com.blankj.utilcode.util.KeyboardUtils;
import com.blankj.utilcode.util.ToastUtils;
import com.winkey.winlib.presenter.BasePresenter;
import com.winkey.winlib.rx.RxApiManager;
import com.winkey.winlib.ui.loader.XzLoader;

import org.greenrobot.eventbus.EventBus;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * @author winkey
 * @date 2020/1/7
 * @describe Fragment基类
 */
public abstract class BaseFragment<T extends BasePresenter> extends Fragment {

    //Activity
    protected FragmentActivity _mActivity = null;
    //ButterKnife绑定
    private Unbinder mUnbinder = null;
    //是否注册EventBus
    protected boolean mIsRegisterBus;

    protected T mPresenter;

    public abstract Object setLayout();

    public abstract void onBindView(@Nullable Bundle savedInstanceState, @NonNull View rootView);

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        ARouter.getInstance().inject(this);
        _mActivity = getActivity();
        //EventBus注册
        if (mIsRegisterBus) {
            EventBus.getDefault().register(this);
        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View rootView;
        if (setLayout() instanceof Integer) {
            rootView = inflater.inflate((int) setLayout(), container, false);
        } else if (setLayout() instanceof View) {
            rootView = (View) setLayout();
        } else {
            throw new ClassCastException("type of setLayout() must be int or View!");
        }

        //绑定
        mUnbinder = ButterKnife.bind(this, rootView);
        onBindView(savedInstanceState, rootView);
        initViews();
        parseData();
        return rootView;
    }

    /**
     * 获取Activity
     *
     * @return
     */
    public Activity getProxyActivity() {
        return _mActivity;
    }
    /**
     * view相关
     */
    protected abstract void initViews();


    /**
     * 数据相关
     */
    protected abstract void parseData();

    public void showLoading() {
        XzLoader.showLoading(_mActivity);
    }

    public void hideLoading() {
        XzLoader.dismissOneDialog();
    }

    public void onError(Throwable throwable){
        XzLoader.dismissDialog();
    }

    @Override
    public void onDestroyView() {
        KeyboardUtils.hideSoftInput(_mActivity);
        //销毁EventBus
        if (mIsRegisterBus) {
            EventBus.getDefault().unregister(this);
        }
        //解绑
        if (mUnbinder != null) {
            mUnbinder.unbind();
        }
        if (mPresenter != null) {
            mPresenter.unregister();
        }
        //清除当前页面的网络请求
        RxApiManager rxApiManager = RxApiManager.getInstance();
        if (rxApiManager != null) {
            rxApiManager.cancel(getContext());
        }
        XzLoader.dismissDialog();
        super.onDestroyView();
    }
}
