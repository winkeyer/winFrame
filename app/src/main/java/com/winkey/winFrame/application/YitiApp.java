package com.winkey.winFrame.application;

import android.app.Application;

import com.joanzapata.iconify.fonts.FontAwesomeModule;
import com.winkey.winFrame.common.db.DbManager;
import com.winkey.winFrame.common.icon.AppFontModule;
import com.winkey.winFrame.R;
import com.winkey.winlib.net.interceptors.DebugInterceptor;
import com.winkey.winlib.rx.Xz;

import okhttp3.logging.HttpLoggingInterceptor;

/**
 * 亿梯App入口
 *
 * @author xiongz
 * @date 2019-07-18
 */
public class YitiApp extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Xz.init(this)
                .withIcon(new FontAwesomeModule())
                .withIcon(new AppFontModule())
                .withApplication(this)
                .withLoaderDelayed(500)
                .withApiHost("http://www.baidu.com")
                .withInterceptor(new DebugInterceptor("test", R.raw.test))// 测试json文件
                .withInterceptor(new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BASIC));


        // 初始化配置完成
        Xz.init(this).configure();
        // 数据库初始化
        DbManager.getInstance().init(this);
    }
}
