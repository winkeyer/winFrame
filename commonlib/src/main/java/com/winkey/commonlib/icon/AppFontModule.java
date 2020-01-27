package com.winkey.commonlib.icon;

import com.joanzapata.iconify.Icon;
import com.joanzapata.iconify.IconFontDescriptor;

/**
 * APP自定义字体图标库module
 *
 * @author xiongz
 * @date 2019-07-18
 */
public class AppFontModule implements IconFontDescriptor {
    @Override
    public String ttfFileName() {
        return "iconfont.ttf";
    }

    @Override
    public Icon[] characters() {
        return AppIcons.values();
    }
}
