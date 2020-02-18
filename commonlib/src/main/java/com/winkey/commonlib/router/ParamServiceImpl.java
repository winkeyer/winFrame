package com.winkey.commonlib.router;

import android.content.Context;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.winkey.commonlib.db.DbManager;
import com.winkey.commonlib.model.po.SysParamProfile;
import com.winkey.commonlib.model.po.SysParamProfileDao;

import java.util.List;

/**
 * @author xuwenbin
 * @date 2020/2/18
 * @describe TODO
 */
@Route(path = "/userService/paramInfo")
public class ParamServiceImpl implements ParamService{




    @Override
    public void insertSysParamProfile(SysParamProfile profile) {
        SysParamProfileDao dao = DbManager.getInstance().getSysParamProfileDao();
        dao.detachAll(); // 清除缓存
        List<SysParamProfile> profiles = dao.queryBuilder().where(
                SysParamProfileDao.Properties.DictId.eq(profile.getDictId())).list();
        if (profiles == null || profiles.size() == 0) {
            dao.insert(profile);
        }
    }

    @Override
    public void clearSysParamProfile() {
        SysParamProfileDao dao = DbManager.getInstance().getSysParamProfileDao();
        dao.detachAll(); // 清除缓存
        dao.deleteAll();
    }

    @Override
    public List<SysParamProfile> getSysParams(String parentId) {
        SysParamProfileDao dao = DbManager.getInstance().getSysParamProfileDao();
        dao.detachAll(); // 清除缓存
        List<SysParamProfile> profiles = dao.queryBuilder()
                .where(SysParamProfileDao.Properties.DictTag.eq(parentId))
                .orderAsc(SysParamProfileDao.Properties.DictKeyId)
                .list();
        return profiles;
    }

    @Override
    public void init(Context context) {

    }
}
