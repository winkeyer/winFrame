package com.winkey.winFrame.login.view;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;

import androidx.annotation.Nullable;

import com.blankj.utilcode.util.ActivityUtils;
import com.winkey.winFrame.R;
import com.winkey.winlib.activity.BaseActivity;
import com.winkey.winlib.app.AccountManager;
import com.winkey.winlib.app.IUserChecker;

import static com.winkey.winFrame.common.constant.Launcher.LOGIN;
import static com.winkey.winFrame.common.constant.Launcher.MAIN;

/**
 * @author winkey
 * @date 2020/1/9
 * @describe 欢迎页
 */
public class LauncherActivity extends BaseActivity {

    //启动页显示时间默认三秒
    private static final int LAUNCHER_SHOW_TIMES = 2000;

    //启动时间
    private long mLauncherTime;

    @Override
    protected Object getContentView() {
        return R.layout.activity_launcher;
    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        mIsFullScreen = true;
        super.onCreate(savedInstanceState);

        ActivityUtils.finishOtherActivities(LauncherActivity.class);

        initViews();
    }

    @Override
    protected void initViews() {
        mLauncherTime = System.currentTimeMillis();
        // 判断账号是否登录
        AccountManager.checkAccount(new IUserChecker() {
            @Override
            public void onLogin() {
                setDelayTimes(MAIN, mLauncherTime);
            }

            @Override
            public void onNotLogin() {
                setDelayTimes(LOGIN, mLauncherTime);
            }
        });
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

    /**
     * 跳转到不同的Activity
     */
    private void toActivity(int tag) {
        switch (tag) {
            //登录
            case LOGIN:
                    ActivityUtils.startActivity(LoginActivity.class);
                break;
            //主页面
            case MAIN:
                /*UserProfile userProfile = ProfileManager.getCurUserProfile();
                if (userProfile != null) { // 更新token
                    HashMap<String, Object> params = NetParams.getDeviceParams();
                    String password = userProfile.getPassword();
                    if (!TextUtils.isEmpty(password)) {
                        params.put("username", userProfile.getUsername());
                        params.put("password", Base64Util.getDecodeStr(password));
                        new LoginModel(LauncherActivity.this).login(params);
                    }
                } else {
                    ActivityUtils.startActivity(MainActivity.class);
                }*/
                break;
        }
    }


}
