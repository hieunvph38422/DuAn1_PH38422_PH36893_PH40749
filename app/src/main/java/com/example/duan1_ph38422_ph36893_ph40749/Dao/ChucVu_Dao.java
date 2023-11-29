package com.example.duan1_ph38422_ph36893_ph40749.Dao;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;


import com.example.duan1_ph38422_ph36893_ph40749.Model.ChucVu;
import com.example.duan1_ph38422_ph36893_ph40749.Database.DbHelper;

import java.util.ArrayList;
import java.util.List;

public class ChucVu_Dao {
    private SQLiteDatabase database;
    DbHelper dbHelper;

    public ChucVu_Dao(Context context) {
        dbHelper = new DbHelper(context, "DuAn1", null, 1);
        database = dbHelper.getWritableDatabase();
        database = dbHelper.getReadableDatabase();
    }

    public List<ChucVu> getAllChucVu() {
        String sql = "SELECT * FROM ChucVu";
        return getData(sql);
    }

    public List<ChucVu> getData(String sql, String... selectionAGrs) {
        ArrayList<ChucVu> list = new ArrayList<>();
        Cursor cursor = database.rawQuery(sql, selectionAGrs);
        while (cursor.moveToNext()) {
            int id_chucVu = cursor.getInt(0);
            String tenChucVu = cursor.getString(1);
            list.add(new ChucVu(id_chucVu, tenChucVu));
        }
        return list;
    }
}
