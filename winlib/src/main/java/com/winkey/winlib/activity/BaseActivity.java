package com.winkey.winlib.activity;

import android.app.Activity;
import android.app.Dialog;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.gyf.barlibrary.ImmersionBar;
import com.winkey.winlib.R;
import com.winkey.winlib.event.EventManage;
import com.winkey.winlib.presenter.BasePresenter;
import com.winkey.winlib.rx.RxApiManager;
import com.winkey.winlib.ui.loader.XzLoader;
import com.winkey.winlib.view.BaseView;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Activity基类
 * Created by xiongz on 2017/12/9.
 */
public abstract class BaseActivity<T extends BasePresenter> extends AppCompatActivity implements BaseView {

    //是否注册EventBus
    protected boolean mIsRegisterBus;
    //是否全屏
    protected boolean mIsFullScreen;
    protected T mPresenter;

    //ButterKnife绑定
    private Unbinder mUnbinder = null;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        final ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.hide();
        }

        //沉浸式
        if (mIsFullScreen) {
            ImmersionBar.with(this).navigationBarColor(R.color.colorPrimary).init();
        }

        //EventBus注册
        if (mIsRegisterBus) {
            EventBus.getDefault().register(this);
        }

        //设置layout
        if (getContentView() instanceof Integer) {
            setContentView((int) getContentView());
        } else if (getContentView() instanceof View) {
            setContentView((View) getContentView());
        } else {
            throw new ClassCastException("type of getContentView() must be int or View!");
        }
        mUnbinder = ButterKnife.bind(this);
        initViews();
        parseData();
    }

    /**
     * 设置activity layout资源文件
     *
     * @return
     */
    protected abstract Object getContentView();

    /**
     * view相关
     */
    protected abstract void initViews();


    /**
     * 数据相关
     */
    protected abstract void parseData();

    @Override
    protected void onDestroy() {
        //销毁ImmersionBar
        if (mIsFullScreen) {
            ImmersionBar.with(this).destroy();
        }
        //销毁EventBus
        if (mIsRegisterBus) {
            EventBus.getDefault().unregister(this);
        }
        //解绑
        if (mUnbinder != null) {
            mUnbinder.unbind();
        }
        //清除当前页面的网络请求
        RxApiManager rxApiManager = RxApiManager.getInstance();
        if (rxApiManager != null) {
            rxApiManager.cancel(this);
        }
        if (mPresenter != null) {
            mPresenter.unregister();
        }
        XzLoader.dismissDialog();
        super.onDestroy();
    }

    @Override
    public void showLoading() {
        XzLoader.showLoading(this);
    }

    @Override
    public void hideLoading() {
        XzLoader.dismissOneDialog();
    }


    @Override
    public void onError(Throwable throwable) {

    }

    /**
     * 设置标题
     */
    protected Toolbar setTitle(final Activity activity, String title) {
        Toolbar toolbar = activity.findViewById(R.id.toolbar);
        TextView tvTitle = activity.findViewById(R.id.tv_toolbar_title);
        tvTitle.setText(title);
        toolbar.setNavigationIcon(R.mipmap.ic_back_white);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
        return toolbar;
    }

    // 设置字体为默认大小，不随系统字体大小改而改变
    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        if (newConfig.fontScale != 1)//非默认值
            getResources();
        super.onConfigurationChanged(newConfig);
    }



    @Override
    public Resources getResources() {
        Resources res = super.getResources();
        if (res.getConfiguration().fontScale != 1) {//非默认值
            Configuration newConfig = new Configuration();
            newConfig.setToDefaults();//设置默认
            res.updateConfiguration(newConfig, res.getDisplayMetrics());
        }
        return res;
    }
}
