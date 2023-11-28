package com.example.duan1_ph38422_ph36893_ph40749.Dao;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.example.duan1_ph38422_ph36893_ph40749.Database.Db_Helper;

public class UserDao {
    private SQLiteDatabase database;
    public UserDao(Context context){
        Db_Helper db_helper = new Db_Helper(context, "User", null, 1);
        database = db_helper.getReadableDatabase();
        database = db_helper.getWritableDatabase();
    }
}
