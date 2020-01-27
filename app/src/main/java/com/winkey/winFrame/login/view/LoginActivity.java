package com.winkey.winFrame.login.view;

import android.os.Bundle;
import android.text.TextUtils;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.blankj.utilcode.util.ActivityUtils;
import com.blankj.utilcode.util.SPUtils;
import com.blankj.utilcode.util.ToastUtils;
import com.winkey.commonlib.constant.Const;
import com.winkey.commonlib.constant.Router;
import com.winkey.winFrame.BuildConfig;
import com.winkey.winFrame.R;
import com.winkey.winFrame.login.contract.LoginContract;
import com.winkey.winFrame.login.presenter.LoginPresenter;
import com.winkey.winlib.activity.BaseActivity;
import com.winkey.winlib.ui.view.ClearEditText;
import com.winkey.winlib.util.OperateUtil;

import java.util.HashMap;

import butterknife.BindView;
import butterknife.OnClick;


/**
 * 登录页面
 *
 * @author xiongz
 * @date 2019-07-18
 */
@Route(path = Router.LOGIN_MOUDLE_ACTIVITY)
public class LoginActivity extends BaseActivity<LoginPresenter> implements LoginContract.View {

    @BindView(R.id.tv_route_select)
    TextView tvNetRoute;
    @BindView(R.id.cet_login_username)
    ClearEditText etUname;
    @BindView(R.id.cet_login_password)
    ClearEditText etPwd;
    @BindView(R.id.tv_login_pwd_switch)
    ImageView tvPwdSwitch;

    //密码是否可见
    private boolean isPwdVisible = false;

    @Override
    protected Object getContentView() {
        return R.layout.activity_login;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        mIsFullScreen = true;
        super.onCreate(savedInstanceState);
        ActivityUtils.finishOtherActivities(LoginActivity.class);
    }

    @Override
    protected void initViews() {
        mPresenter = new LoginPresenter(this);
        mPresenter.register(this);
    }

    @Override
    protected void parseData() {
    }


    @Override
    public void onResume() {
        super.onResume();
        tvNetRoute.setText("自定义");
        int curNetIndex = SPUtils.getInstance().getInt(Const.NET_ROUTE_INDEX, 0);
        if (BuildConfig.DEBUG) {
            tvNetRoute.setVisibility(View.VISIBLE);
            if (curNetIndex == 10000) {
                tvNetRoute.setText("自定义");
            } else {
                tvNetRoute.setText(Const.NET_ROUTES_DEV[curNetIndex].trim());
            }

        } else {
            tvNetRoute.setVisibility(View.GONE);
        }
    }


    @Override
    public void onLoginSuccess() {
        ARouter.getInstance().build(Router.MAIN_MOUDLE_ACTIVITY).navigation();
    }

    @OnClick({R.id.btn_login_login, R.id.tv_login_pwd_switch, R.id.tv_route_select})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            // 线路选择
            case R.id.tv_route_select:
                if (OperateUtil.isFastClick()) return;
                // ActivityUtils.startActivity(SelectNetActivity.class);
                break;
            // 登录
            case R.id.btn_login_login:
                String userName = etUname.getText().toString().trim();
                String password = etPwd.getText().toString().trim();
                if (TextUtils.isEmpty(userName)) {
                    ToastUtils.showShort("请输入手机号|邮箱|用户名");
                } else if (TextUtils.isEmpty(password)) {
                    ToastUtils.showShort("请输入密码");
                } else {
                    HashMap<String, Object> params = new HashMap<>();
                    params.put("username", userName);
                    params.put("password", password);
                    mPresenter.login(params);
                }
                break;
            // 密码可见
            case R.id.tv_login_pwd_switch:
                if (isPwdVisible) {
                    tvPwdSwitch.setImageResource(R.mipmap.ic_hidden_psd);
                    etPwd.setTransformationMethod(PasswordTransformationMethod.getInstance());
                    isPwdVisible = false;
                } else {
                    tvPwdSwitch.setImageResource(R.mipmap.ic_show_psd);
                    etPwd.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                    isPwdVisible = true;
                }
                break;
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

}
