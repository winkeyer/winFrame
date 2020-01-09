package com.winkey.common.db;

import android.text.TextUtils;


import com.winkey.winlib.util.Base64Util;

import java.util.ArrayList;
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


    /********** 拜访图片信息 **********/

    /**
     * 获取所有拜访图片信息
     *
     * @return
     */
    public static List<VisitImgProfile> getVisitImgProfile() {
        VisitImgProfileDao dao = DbManager.getInstance().getVisitImgProfileDao();
        dao.detachAll(); // 清除缓存
        List<VisitImgProfile> imgs = dao.loadAll();
        return imgs;
    }

    /**
     * 删除所有的拜访图片信息
     */
    public static void clearImgProfile() {
        VisitImgProfileDao dao = DbManager.getInstance().getVisitImgProfileDao();
        dao.detachAll(); // 清除缓存
        dao.deleteAll();
    }


    /**
     * 插入拜访图片的线上地址
     *
     * @param localPath 图片本地地址
     * @param photoPath 图片线上地址
     */
    public static void updateImgProfile(String localPath, String photoPath) {
        VisitImgProfileDao dao = DbManager.getInstance().getVisitImgProfileDao();
        dao.detachAll(); // 清除缓存
        List<VisitImgProfile> imgProfiles = dao.queryBuilder().where(VisitImgProfileDao.Properties.LocalPath.eq(localPath)).list();
        if (imgProfiles.size() > 0) {
            VisitImgProfile profile = imgProfiles.get(0);
            profile.setPhotoPath(photoPath);
            dao.update(profile);
        }
    }

    /**
     * 删除一条拜访图片记录
     *
     * @param localPath 图片本地地址
     */
    public static void deleteImgProfile(String localPath) {
        VisitImgProfileDao dao = DbManager.getInstance().getVisitImgProfileDao();
        dao.detachAll(); // 清除缓存
        List<VisitImgProfile> imgProfiles = dao.queryBuilder().where(VisitImgProfileDao.Properties.LocalPath.eq(localPath)).list();
        if (imgProfiles.size() > 0) {
            VisitImgProfile profile = imgProfiles.get(0);
            dao.deleteByKey(profile.getId());
        }
    }

    /**
     * 判断图片是否已上传
     *
     * @param localPath 图片本地地址
     */
    public static boolean isUploaded(String localPath) {
        VisitImgProfileDao dao = DbManager.getInstance().getVisitImgProfileDao();
        dao.detachAll(); // 清除缓存
        List<VisitImgProfile> imgProfiles = dao.queryBuilder().where(VisitImgProfileDao.Properties.LocalPath.eq(localPath)).list();
        if (imgProfiles.size() > 0) {
            VisitImgProfile profile = imgProfiles.get(0);
            if (TextUtils.isEmpty(profile.getPhotoPath())) {
                return false;
            } else {
                return true;
            }
        }
        return false;
    }

    /**
     * 获取所有未上传的图片
     */
    public static List<VisitImgProfile> getNoUploadImgs() {
        VisitImgProfileDao dao = DbManager.getInstance().getVisitImgProfileDao();
        dao.detachAll(); // 清除缓存
        List<VisitImgProfile> imgs = dao.loadAll();
        List<VisitImgProfile> noUploadImgs = new ArrayList<>();
        for (int i = 0; i < imgs.size(); i++) {
            VisitImgProfile profile = imgs.get(i);
            if (TextUtils.isEmpty(profile.getPhotoPath())) {
                noUploadImgs.add(profile);
            }
        }
        return noUploadImgs;
    }

    /**
     * 判断图片是否已提交
     *
     * @param localPath 图片本地地址
     */
    public static boolean isCommited(String localPath) {
        VisitImgProfileDao dao = DbManager.getInstance().getVisitImgProfileDao();
        dao.detachAll(); // 清除缓存
        List<VisitImgProfile> imgProfiles = dao.queryBuilder().where(VisitImgProfileDao.Properties.LocalPath.eq(localPath)).list();
        if (imgProfiles.size() > 0) {
            VisitImgProfile profile = imgProfiles.get(0);
            if (profile.getIsCommit()) {
                return true;
            } else {
                return false;
            }
        }
        return false;
    }

    /**
     * 更新拜访图片的提交状态为已提交
     */
    public static void updateImgCommitStatus() {
        VisitImgProfileDao dao = DbManager.getInstance().getVisitImgProfileDao();
        dao.detachAll(); // 清除缓存
        List<VisitImgProfile> imgProfiles = getNoCommitImgs();
        if (imgProfiles.size() > 0) {
            for (int i = 0; i < imgProfiles.size(); i++) {
                VisitImgProfile profile = imgProfiles.get(i);
                profile.setIsCommit(true);
            }
        }
        dao.updateInTx(imgProfiles);
    }

    /**
     * 获取所有未提交的图片
     */
    public static List<VisitImgProfile> getNoCommitImgs() {
        VisitImgProfileDao dao = DbManager.getInstance().getVisitImgProfileDao();
        dao.detachAll(); // 清除缓存
        List<VisitImgProfile> imgs = dao.loadAll();
        List<VisitImgProfile> noCommitImgs = new ArrayList<>();
        for (int i = 0; i < imgs.size(); i++) {
            VisitImgProfile profile = imgs.get(i);
            if (!profile.getIsCommit()) {
                noCommitImgs.add(profile);
            }
        }
        return noCommitImgs;
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
