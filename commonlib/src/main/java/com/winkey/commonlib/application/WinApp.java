package com.winkey.commonlib.application;

import android.app.Application;

import com.alibaba.android.arouter.launcher.ARouter;
import com.joanzapata.iconify.fonts.FontAwesomeModule;
import com.winkey.commonlib.BuildConfig;
import com.winkey.commonlib.R;
import com.winkey.commonlib.db.DbManager;
import com.winkey.commonlib.icon.AppFontModule;
import com.winkey.commonlib.net.interceptors.TokenInterceptor;
import com.winkey.winlib.net.interceptors.DebugInterceptor;
import com.winkey.winlib.rx.Xz;

import okhttp3.logging.HttpLoggingInterceptor;

/**
 * 亿梯App入口
 *
 * @author xiongz
 * @date 2019-07-18
 */
public class WinApp extends Application {
    @Override
    public void onCreate() {
        super.onCreate();

        // 数据库初始化
        DbManager.getInstance().init(this);
        // ARouter初始化
        if (BuildConfig.DEBUG) {           // 这两行必须写在init之前，否则这些配置在init过程中将无效
            ARouter.openLog();     // 打印日志
            ARouter.openDebug();   // 开启调试模式(如果在InstantRun模式下运行，必须开启调试模式！线上版本需要关闭,否则有安全风险)
        }
        ARouter.init(this); // 尽可能早，推荐在Application中初始化
        Xz.init(this)
                .withIcon(new FontAwesomeModule())
                .withIcon(new AppFontModule())
                .withApplication(this)
                .withLoaderDelayed(500)
                .withApiHost("http://www.baidu.com")
                .withInterceptor(new TokenInterceptor())//token拦截器
                .withInterceptor(new DebugInterceptor("test", R.raw.test))// 测试json文件
                .withInterceptor(new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BASIC));


        // 初始化配置完成
        Xz.init(this).configure();

    }
}
