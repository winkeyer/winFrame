package com.winkey.commonlib.router;

import com.alibaba.android.arouter.facade.template.IProvider;
import com.winkey.commonlib.db.DbManager;
import com.winkey.commonlib.model.po.SysParamProfile;
import com.winkey.commonlib.model.po.UserProfile;
import com.winkey.commonlib.model.po.UserProfileDao;

import java.util.List;

/**
 * @author winkey
 * @date 2020/1/26
 * @describe Arouter用户基本信息服务
 */
public interface UserService extends IProvider {

    String getToken();

    UserProfile getUserProfile();

    void insertUserProfile(UserProfile userProfile, String pwd);

    void clearUserProfile();

    void updateUserPwd(String pwd);

}
