package com.winkey.winFrame.setting.view;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.widget.Toolbar;

import com.alibaba.android.arouter.facade.annotation.Autowired;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.blankj.utilcode.util.ActivityUtils;
import com.blankj.utilcode.util.AppUtils;
import com.winkey.commonlib.constant.Router;
import com.winkey.commonlib.db.SysParamManager;
import com.winkey.commonlib.router.UserService;
import com.winkey.loginmodule.view.LoginActivity;
import com.winkey.winFrame.R;
import com.winkey.winlib.activity.BaseActivity;
import com.winkey.winlib.app.AccountManager;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * @author xuwenbin
 * @date 2020/2/18
 * @describe 系统设置
 */

@Route(path = Router.SETTING_ACTIVITY)
public class SettingActivity extends BaseActivity {
    @BindView(R.id.tv_toolbar_title)
    TextView tvToolbarTitle;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.tv_setting_version)
    TextView tvSettingVersion;
    @BindView(R.id.ll_setting_version)
    LinearLayout llSettingVersion;
    @BindView(R.id.btn_setting_login_out)
    Button btnSettingLoginOut;

    @Autowired
    UserService userService;


    @Override
    protected Object getContentView() {
        return R.layout.activity_setting;
    }

    @Override
    protected void initViews() {
        setTitle(this, "系统设置");

        tvSettingVersion.setText(TextUtils.concat("v", AppUtils.getAppVersionName()));
    }

    @Override
    protected void parseData() {

    }

    @OnClick({ R.id.ll_setting_version,R.id.btn_setting_login_out,})
    public void onViewClicked(View view) {
        switch (view.getId()) {

            // 版本更新
            case R.id.ll_setting_version:
                // Beta.checkUpgrade();
                break;
            // 退出登录
            case R.id.btn_setting_login_out:
                logout();
                break;

        }
    }

    /**
     * 退出
     */
    private void logout() {

        // 设置系统配置参数为空
        SysParamManager.getInstance().setNull();
        // 删除本地数据库用户数据
        userService.clearUserProfile();
        // 设置当前未登录
        AccountManager.setLoginState(false);
        ARouter.getInstance().build(Router.LOGIN_ACTIVITY).navigation();
    }
}
