package com.winkey.commonlib.router;

import android.content.Context;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.blankj.utilcode.util.SPUtils;
import com.winkey.commonlib.constant.Const;
import com.winkey.commonlib.db.ProfileManager;
import com.winkey.commonlib.model.po.SysParamProfile;
import com.winkey.commonlib.model.po.UserProfile;

import java.util.List;

/**
 * @author winkey
 * @date 2020/1/26
 * @describe TODO
 */
@Route(path = "/userService/userInfo")
public class UserServiceImpl implements UserService {

    @Override
    public String getToken() {
        return SPUtils.getInstance().getString(Const.TOKEN, "");
    }

    @Override
    public void init(Context context) {

    }
}
