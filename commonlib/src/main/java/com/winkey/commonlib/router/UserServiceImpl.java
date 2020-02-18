package com.winkey.commonlib.router;

import android.content.Context;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.blankj.utilcode.util.SPUtils;
import com.winkey.commonlib.constant.Const;
import com.winkey.commonlib.constant.Router;
import com.winkey.commonlib.db.DbManager;
import com.winkey.commonlib.model.po.UserProfile;
import com.winkey.commonlib.model.po.UserProfileDao;
import com.winkey.winlib.util.Base64Util;

import java.util.List;

/**
 * @author winkey
 * @date 2020/1/26
 * @describe 用户基本信息服务实现类
 */
@Route(path = Router.USER_INFO)
public class UserServiceImpl implements UserService {

    @Override
    public String getToken() {
        return SPUtils.getInstance().getString(Const.TOKEN, "");
    }

    @Override
    public UserProfile getUserProfile() {
        UserProfile userProfile = null;
        UserProfileDao dao = DbManager.getInstance().getUserProfileDao();
        dao.detachAll(); // 清除缓存
        List<UserProfile> datas = dao.loadAll();
        if (datas != null && datas.size() > 0) {
            userProfile = datas.get(0);
        }
        return userProfile;
    }

    @Override
    public void insertUserProfile(UserProfile userProfile, String pwd) {
        UserProfileDao dao = DbManager.getInstance().getUserProfileDao();
        dao.detachAll(); // 清除缓存
        dao.deleteAll();
        userProfile.setPassword(Base64Util.getEncodeStr(pwd));
        dao.insert(userProfile);
    }

    @Override
    public void clearUserProfile() {
        UserProfileDao dao = DbManager.getInstance().getUserProfileDao();
        dao.detachAll(); // 清除缓存
        dao.deleteAll();
    }

    @Override
    public void updateUserPwd(String pwd) {
        UserProfileDao dao = DbManager.getInstance().getUserProfileDao();
        dao.detachAll(); // 清除缓存
        List<UserProfile> datas = dao.loadAll();
        if (datas != null && datas.size() > 0) {
            UserProfile userProfile = datas.get(0);
            userProfile.setPassword(Base64Util.getEncodeStr(pwd));
            dao.update(userProfile);
        }
    }

    @Override
    public void init(Context context) {

    }
}
