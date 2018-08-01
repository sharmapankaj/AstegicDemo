package com.example.pankaj.astegicdemo;

import android.app.Application;

import com.example.pankaj.astegicdemo.Database.DaoMaster;
import com.example.pankaj.astegicdemo.Database.DaoSession;

import org.greenrobot.greendao.database.Database;

public class AstegicDemoApp extends Application
{
    private DaoSession daoSession;
    private static AstegicDemoApp instance = null;

    public synchronized static AstegicDemoApp getInstance() {
        return instance;
    }
    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        DaoMaster.DevOpenHelper helper = new DaoMaster.DevOpenHelper(this, "astegic_db");
        Database db = helper.getWritableDb();
        if (db != null) {
            daoSession = new DaoMaster(db).newSession();
        }
    }
    public DaoSession getDaoSession() {
        return daoSession;
    }
}
