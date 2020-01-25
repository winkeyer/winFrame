package com.winkey.winFrame.common.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;


import org.greenrobot.greendao.database.Database;

/**
 * release版本数据库帮助类
 * Created by xiongz on 2017/12/15
 */
public class ReleaseOpenHelper extends DaoMaster.OpenHelper {

    public ReleaseOpenHelper(Context context, String name) {
        super(context, name);
    }

    public ReleaseOpenHelper(Context context, String name, SQLiteDatabase.CursorFactory factory) {
        super(context, name, factory);
    }

    @Override
    public void onCreate(Database db) {
        super.onCreate(db);
    }

    @Override
    public void onUpgrade(Database db, int oldVersion, int newVersion) {
        super.onUpgrade(db, oldVersion, newVersion);
        // WkLogger.i("db version", oldVersion + "---先前和更新之后的版本---" + newVersion);
        if (oldVersion < newVersion) {
            MigrationHelper.migrate(db, UserProfileDao.class, SysParamProfileDao.class, VisitImgProfileDao.class);
        }
    }
}
