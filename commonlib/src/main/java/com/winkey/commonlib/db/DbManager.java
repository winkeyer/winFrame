package com.winkey.commonlib.db;

import android.content.Context;


import com.winkey.commonlib.model.po.DaoMaster;
import com.winkey.commonlib.model.po.DaoSession;
import com.winkey.commonlib.model.po.SysParamProfileDao;
import com.winkey.commonlib.model.po.UserProfileDao;

import org.greenrobot.greendao.database.Database;

/**
 * 数据库管理类
 * Created by xiongz on 2017/12/15
 */
public class DbManager {

    private ReleaseOpenHelper mDbHelper = null;
    private DaoSession mDaoSession = null;
    private UserProfileDao mUserProfileDao = null;
    private SysParamProfileDao mSysParamProfileDao = null;

    private DbManager() {
    }

    public DbManager init(Context context) {
        initDao(context);
        return this;
    }

    private static final class Holder {
        private static final DbManager INSTANCE = new DbManager();
    }

    public static DbManager getInstance() {
        return Holder.INSTANCE;
    }

    private void initDao(Context context) {
        if (mDbHelper == null) {
            mDbHelper = new ReleaseOpenHelper(context, "yiti.db");
        }
        final Database db = mDbHelper.getWritableDb();
        mDaoSession = new DaoMaster(db).newSession();
        mDaoSession.clear();
        mUserProfileDao = mDaoSession.getUserProfileDao();
        mSysParamProfileDao = mDaoSession.getSysParamProfileDao();
    }

    /**
     * 获取用户信息
     *
     * @return
     */
    public final UserProfileDao getUserProfileDao() {
        return mUserProfileDao;
    }


    /**
     * 获取系统参数信息
     *
     * @return
     */
    public SysParamProfileDao getSysParamProfileDao() {
        return mSysParamProfileDao;
    }
}
