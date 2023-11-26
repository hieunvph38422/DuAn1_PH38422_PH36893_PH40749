package com.example.duan1_ph38422_ph36893_ph40749.Dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.duan1_ph38422_ph36893_ph40749.Database.Db_Helper;
import com.example.duan1_ph38422_ph36893_ph40749.Model.Admin;

import java.util.AbstractMap;
import java.util.ArrayList;

public class AdminDAO {
    Db_Helper dbHelper;

    public static final String TABLE_NAME = "Admin";

    public static final String COLUMN_MAADMIN = "maAdmin";

    public static final String COLUMN_TEN_DANG_NHAP = "tenDangNhap";

    public static final String COLUMN_MATKHAU = "matKhau";

    public AdminDAO(Context context){
        dbHelper = new Db_Helper(context);
    }

    public boolean insertData(Admin obj) {
        SQLiteDatabase sqLiteDatabase = dbHelper.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COLUMN_MAADMIN, obj.getMaAdmin());
        contentValues.put(COLUMN_TEN_DANG_NHAP, obj.getTenDangNhap());
        contentValues.put(COLUMN_MATKHAU, obj.getMatKhau());
        long check = sqLiteDatabase.insert(TABLE_NAME, null, contentValues);
        return check != -1;
    }
    public boolean delete(Admin obj) {
        SQLiteDatabase sqLiteDatabase = dbHelper.getWritableDatabase();
        String dk[] = {String.valueOf(obj.getMaAdmin())};
        long check = sqLiteDatabase.delete(TABLE_NAME, COLUMN_MAADMIN + "= ?", dk);
        return check != -1;
    }
    public boolean update(Admin obj) {
        SQLiteDatabase sqLiteDatabase = dbHelper.getWritableDatabase();
        String dk[] = {String.valueOf(obj.getMaAdmin())};
        ContentValues contentValues = new ContentValues();
        contentValues.put(COLUMN_TEN_DANG_NHAP, obj.getTenDangNhap());
        contentValues.put(COLUMN_MATKHAU, obj.getMatKhau());
        long check = sqLiteDatabase.update(TABLE_NAME, contentValues, COLUMN_MAADMIN + "= ?", dk);
        return check != -1;
    }
    public boolean updatePass(Admin obj) {
        ContentValues contentValues = new ContentValues();
        SQLiteDatabase sqLiteDatabase = dbHelper.getWritableDatabase();
        String dk[] = {String.valueOf(obj.getMaAdmin())};
        contentValues.put(COLUMN_TEN_DANG_NHAP, obj.getTenDangNhap());
        contentValues.put(COLUMN_MATKHAU, obj.getMatKhau());
        long check = sqLiteDatabase.update(TABLE_NAME, contentValues, COLUMN_MAADMIN + "= ?", dk);
        return check != -1;
    }
    public ArrayList<Admin> getAll(String sql, String... selectionArgs){
        SQLiteDatabase sqLiteDatabase = dbHelper.getWritableDatabase();
        ArrayList<Admin> list = new ArrayList<>();
        Cursor cursor = sqLiteDatabase.rawQuery(sql, selectionArgs);
        if (cursor.getCount() > 0) {
            cursor.moveToFirst();
            do {
                String maAdmin = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_MAADMIN));
                String tenDangNhap = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_TEN_DANG_NHAP));
                String matKhau = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_MATKHAU));
                list.add(new Admin(maAdmin, tenDangNhap, matKhau));
            } while (cursor.moveToNext());
        }
        return list;
    }
    public ArrayList<Admin> SelectAll() {
        String sql = "SELECT * FROM " + TABLE_NAME;
        return getAll(sql);
    }

    public Admin SelectID(String id) {
        String sql = "SELECT * FROM Admin WHERE tenDangNhap = ?";
        ArrayList<Admin> list = getAll(sql, id);
        return list.get(0);
    }

    public boolean checkLogin(String username, String password) {
        SQLiteDatabase sqLiteDatabase = dbHelper.getReadableDatabase();
        String sql = "SELECT * FROM Admin WHERE " + COLUMN_TEN_DANG_NHAP + "=? AND " + COLUMN_MATKHAU + "=?";
        String[] selectionArgs = new String[]{username, password};
        Cursor cursor = sqLiteDatabase.rawQuery(sql, selectionArgs);
        boolean result = cursor.getCount() > 0;
        return result;
    }
}
