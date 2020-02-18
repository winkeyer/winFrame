package com.winkey.projectmodule.view;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;

import androidx.annotation.Nullable;

import com.alibaba.android.arouter.facade.annotation.Autowired;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.blankj.utilcode.util.ActivityUtils;
import com.winkey.commonlib.constant.Launcher;
import com.winkey.commonlib.constant.Router;
import com.winkey.commonlib.router.UserService;
import com.winkey.loginmodule.contract.LoginContract;
import com.winkey.loginmodule.presenter.LoginPresenter;
import com.winkey.projectmodule.R;
import com.winkey.winlib.activity.BaseActivity;
import com.winkey.winlib.app.AccountManager;
import com.winkey.winlib.app.IUserChecker;


/**
 * @author winkey
 * @date 2020/1/9
 * @describe 欢迎页
 */
@Route(path = Router.LAUNCHER_ACTIVITY)
public class LauncherActivity extends BaseActivity<LoginPresenter> implements LoginContract.View {

    //启动页显示时间默认三秒
    private static final int LAUNCHER_SHOW_TIMES = 2000;

    //启动时间
    private long mLauncherTime;

    @Autowired(name = "/userService/userInfo")
    UserService userService;

    @Override
    protected Object getContentView() {
        return R.layout.project_activity_launcher;
    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        mIsFullScreen = true;
        super.onCreate(savedInstanceState);

        ActivityUtils.finishOtherActivities(LauncherActivity.class);
    }

    @Override
    protected void initViews() {
        mLauncherTime = System.currentTimeMillis();
        // 判断账号是否登录
        AccountManager.checkAccount(new IUserChecker() {
            @Override
            public void onLogin() {
                setDelayTimes(Launcher.LOGIN, mLauncherTime);
            }

            @Override
            public void onNotLogin() {
                setDelayTimes(Launcher.LOGIN, mLauncherTime);
            }
        });
        mPresenter = new LoginPresenter(this);
        mPresenter.register(this);
    }

    @Override
    protected void parseData() {

    }


    /**
     * 设置延迟时间
     */
    private void setDelayTimes(final int tag, long preTime) {
        long curTime = System.currentTimeMillis();
        long times = (LAUNCHER_SHOW_TIMES - (curTime - preTime) / 1000);
        if (times > 0) {
            new Handler(new Handler.Callback() {
                @Override
                public boolean handleMessage(Message msg) {
                    toActivity(tag);
                    return false;
                }
            }).sendEmptyMessageDelayed(0, times);
        } else {
            toActivity(tag);
        }
    }


    @Override
    public void onLoginSuccess() {
        ARouter.getInstance().build(Router.LOGIN_ACTIVITY).navigation();
    }


    /**
     * 跳转到不同的Activity
     */
    private void toActivity(int tag) {
        switch (tag) {
            //登录
            case Launcher.LOGIN:
                ARouter.getInstance().build(Router.LOGIN_ACTIVITY).withString("routePath",Router.PATROL_ACTIVITY).navigation();
                break;
        }
    }


}
