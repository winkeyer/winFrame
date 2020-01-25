package com.winkey.winFrame.common.constant;

/**
 * @author winkey
 * @date 2020/1/9
 * @describe 登录类型常量定义
 */

import androidx.annotation.IntDef;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * 欢迎页跳转tag
 *
 * @author xiongz
 * @date 2018/9/4
 */
@IntDef({Launcher.SCROLL, Launcher.LOGIN, Launcher.MAIN})
@Retention(RetentionPolicy.SOURCE)
public @interface Launcher {
    int SCROLL = 1;
    int LOGIN = 2;
    int MAIN = 3;
}

