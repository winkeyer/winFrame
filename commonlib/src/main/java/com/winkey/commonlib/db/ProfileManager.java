package com.winkey.commonlib.db;


import com.winkey.commonlib.model.po.SysParamProfile;
import com.winkey.commonlib.model.po.SysParamProfileDao;
import com.winkey.commonlib.model.po.UserProfile;
import com.winkey.commonlib.model.po.UserProfileDao;
import com.winkey.winlib.util.Base64Util;

import java.util.List;

/**
 * 数据库信息管理类
 *
 * @author xiongz
 * @date 2018/9/4
 */
public class ProfileManager {

    /********** 用户信息 **********/

    /**
     * 插入用户信息
     *
     * @param userProfile 用户信息
     * @param pwd         密码
     */
    public static void insertUserProfile(UserProfile userProfile, String pwd) {
        UserProfileDao dao = DbManager.getInstance().getUserProfileDao();
        dao.detachAll(); // 清除缓存
        dao.deleteAll();
        userProfile.setPassword(Base64Util.getEncodeStr(pwd));
        dao.insert(userProfile);
    }

    public static void refreshToken(UserProfile userProfile,String pwd){
        UserProfileDao dao = DbManager.getInstance().getUserProfileDao();
        userProfile.setPassword(Base64Util.getEncodeStr(pwd));
        dao.insert(userProfile);
    }

    /**
     * 获取当前用户信息
     *
     * @return
     */
    public static UserProfile getCurUserProfile() {
        UserProfile userProfile = null;
        UserProfileDao dao = DbManager.getInstance().getUserProfileDao();
        dao.detachAll(); // 清除缓存
        List<UserProfile> datas = dao.loadAll();
        if (datas != null && datas.size() > 0) {
            userProfile = datas.get(0);
        }
        return userProfile;
    }

    /**
     * 删除用户信息
     */
    public static void clearUserProfile() {
        UserProfileDao dao = DbManager.getInstance().getUserProfileDao();
        dao.detachAll(); // 清除缓存
        dao.deleteAll();
    }

    /**
     * 修改用户密码
     *
     * @return
     */
    public static void updateUserPwd(String pwd) {
        UserProfileDao dao = DbManager.getInstance().getUserProfileDao();
        dao.detachAll(); // 清除缓存
        List<UserProfile> datas = dao.loadAll();
        if (datas != null && datas.size() > 0) {
            UserProfile userProfile = datas.get(0);
            userProfile.setPassword(Base64Util.getEncodeStr(pwd));
            dao.update(userProfile);
        }
    }



    /********** 系统参数信息 **********/

    /**
     * 插入一条系统参数记录
     *
     * @param profile 系统参数
     */
    public static void insertSysParamProfile(SysParamProfile profile) {
        SysParamProfileDao dao = DbManager.getInstance().getSysParamProfileDao();
        dao.detachAll(); // 清除缓存
        List<SysParamProfile> profiles = dao.queryBuilder().where(
                SysParamProfileDao.Properties.DictId.eq(profile.getDictId())).list();
        if (profiles == null || profiles.size() == 0) {
            dao.insert(profile);
        }
    }

    /**
     * 删除所有的系统参数信息
     */
    public static void clearSysParamProfile() {
        SysParamProfileDao dao = DbManager.getInstance().getSysParamProfileDao();
        dao.detachAll(); // 清除缓存
        dao.deleteAll();
    }

    /**
     * 获取系统参数
     *
     * @param parentId 父id
     */
    public static List<SysParamProfile> getSysParams(String parentId) {
        SysParamProfileDao dao = DbManager.getInstance().getSysParamProfileDao();
        dao.detachAll(); // 清除缓存
        List<SysParamProfile> profiles = dao.queryBuilder()
                .where(SysParamProfileDao.Properties.DictTag.eq(parentId))
                .orderAsc(SysParamProfileDao.Properties.DictKeyId)
                .list();
        return profiles;
    }
}
