package com.winkey.winFrame.main.view;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.Settings;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.core.app.NotificationManagerCompat;
import androidx.fragment.app.Fragment;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.blankj.utilcode.util.ActivityUtils;
import com.blankj.utilcode.util.FragmentUtils;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.winkey.commonlib.constant.Router;
import com.winkey.winFrame.R;
import com.winkey.winlib.activity.BaseActivity;

import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import butterknife.BindView;

/**
 * @author winkey
 * @date 2020/1/26
 * @describe TODO
 */
@Route(path = Router.MAIN_MOUDLE_ACTIVITY)
public class MainActivity extends BaseActivity implements BottomNavigationView.OnNavigationItemSelectedListener {

    @BindView(  R.id.bnv_main)
    BottomNavigationView navigation;
    // 相关模块
    private Fragment[] mFrags = new Fragment[4];
    // 当前页面下标
    private int mTabIndex = 0;

    @Override
    protected Object getContentView() {
        return R.layout.activity_main;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        navigation.setOnNavigationItemSelectedListener(this);
        navigation.setSelectedItemId(R.id.navigation_home);

        // finish其他activity
        ActivityUtils.finishOtherActivities(MainActivity.class);

        NotificationManagerCompat manager = NotificationManagerCompat.from(this);
        // areNotificationsEnabled方法的有效性官方只最低支持到API 19，低于19的仍可调用此方法不过只会返回true，即默认为用户已经开启了通知。
        boolean isOpened = manager.areNotificationsEnabled();
        if (!isOpened) {
            new AlertDialog.Builder(this)
                    .setTitle("提示")
                    .setCancelable(false)
                    .setMessage("为确保及时收取亿梯保消息，需要打开通知权限，确定打开吗？")
                    .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            try {
                                // 根据isOpened结果，判断是否需要提醒用户跳转AppInfo页面，去打开App通知权限
                                Intent intent = new Intent();
                                intent.setAction(Settings.ACTION_APP_NOTIFICATION_SETTINGS);
                                //这种方案适用于 API 26, 即8.0（含8.0）以上可以用
                                intent.putExtra(Settings.EXTRA_APP_PACKAGE, getPackageName());
                                intent.putExtra(Settings.EXTRA_CHANNEL_ID, getApplicationInfo().uid);

                                //这种方案适用于 API21——25，即 5.0——7.1 之间的版本可以使用
                                intent.putExtra("app_package", getPackageName());
                                intent.putExtra("app_uid", getApplicationInfo().uid);

                                // 小米6 -MIUI9.6-8.0.0系统，是个特例，通知设置界面只能控制"允许使用通知圆点"——然而这个玩意并没有卵用，我想对雷布斯说：I'm not ok!!!
                                //  if ("MI 6".equals(Build.MODEL)) {
                                //      intent.setAction(Settings.ACTION_APPLICATION_DETAILS_SETTINGS);
                                //      Uri uri = Uri.fromParts("package", getPackageName(), null);
                                //      intent.setData(uri);
                                //      // intent.setAction("com.android.settings/.SubSettings");
                                //  }
                                startActivity(intent);
                            } catch (Exception e) {
                                e.printStackTrace();
                                // 出现异常则跳转到应用设置界面：锤子坚果3——OC105 API25
                                Intent intent = new Intent();

                                //下面这种方案是直接跳转到当前应用的设置界面。
                                //https://blog.csdn.net/ysy950803/article/details/71910806
                                intent.setAction(Settings.ACTION_APPLICATION_DETAILS_SETTINGS);
                                Uri uri = Uri.fromParts("package", getPackageName(), null);
                                intent.setData(uri);
                                startActivity(intent);
                            }
                        }
                    })
                    .setNegativeButton("取消", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                        }
                    }).show();
        }


    }
    @Override
    protected void initViews() {

    }

    @Override
    protected void parseData() {

    }



    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        int tab;
        switch (menuItem.getItemId()) {
            // 首页
            case R.id.navigation_home:
                tab = 0;

                if (mFrags[tab] == null) {
                    mFrags[tab] = new HomeFragment();
                    FragmentUtils.add(getSupportFragmentManager(), mFrags[tab], R.id.fl_main);
                }
                FragmentUtils.showHide(mFrags[tab], mFrags[mTabIndex]);
                mTabIndex = tab;
                return true;
            case R.id.navigation_contact:
                tab = 1;
                if (mFrags[tab] == null) {
                    mFrags[tab] = new NoAuthFragment();
                    FragmentUtils.add(getSupportFragmentManager(), mFrags[tab], R.id.fl_main);
                }
                FragmentUtils.showHide(mFrags[tab], mFrags[mTabIndex]);
                mTabIndex = tab;
                return true;
            // 计划
            case R.id.navigation_form:
                tab = 2;
                if (mFrags[tab] == null) {
                    mFrags[tab] = new NoAuthFragment();
                    FragmentUtils.add(getSupportFragmentManager(), mFrags[tab], R.id.fl_main);
                }
                FragmentUtils.showHide(mFrags[tab], mFrags[mTabIndex]);
                mTabIndex = tab;
                return true;
            // 我的
            case R.id.navigation_mine:
                tab = 3;
                if (mFrags[tab] == null) {
                    mFrags[tab] = new MineFragment();
                    FragmentUtils.add(getSupportFragmentManager(), mFrags[tab], R.id.fl_main);
                }
                FragmentUtils.showHide(mFrags[tab], mFrags[mTabIndex]);
                mTabIndex = tab;
                return true;
        }
        return false;
    }

}
