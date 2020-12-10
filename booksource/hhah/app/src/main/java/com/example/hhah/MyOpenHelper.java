package com.example.hhah;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class MyOpenHelper extends SQLiteOpenHelper {

    // context:上下文
    // name:数据库名字
    // 目的创建cursor对象
    // 数据库的版本从一开始
    public MyOpenHelper(Context context) {
        super(context, "zhanghao", null, 1);

    }

    @Override
    // 当数据库第一次被创建的时候调用，用来建表
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table biao01 (t_name varchar(20),t_place varchar(20),time varchar(20));");
        db.execSQL("insert into biao01 values('吃饭','白骆驼','2019.3.21');");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // TODO Auto-generated method stub

    }

}