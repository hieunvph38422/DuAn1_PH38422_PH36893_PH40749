package com.example.duan1_ph38422_ph36893_ph40749.Database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class Db_Helper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "ChickenCoffee.db";
    private static final int DATABASE_VERSION = 2;

    public Db_Helper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTableAdmin = "CREATE TABLE Admin (" +
                "maAdmin INTEGER PRIMARY KEY, " +
                "tenDangNhap TEXT NOT NULL, " +
                "matKhau TEXT NOT NULL," +
                "role INTEGER NOT NULL)";
        db.execSQL(createTableAdmin);

        String insertDefaultAdmin = "INSERT INTO Admin (maAdmin, tenDangNhap, matKhau,role) VALUES "
                + "('admin01', 'nguyentrongnam', 'admin1',0)," +
                "('nhanvien01', 'nguyentrongnam', 'nhanvien1',1)";
        db.execSQL(insertDefaultAdmin);

        String createTableKhachHang = "CREATE TABLE KhachHang (" +
                "maKH INTEGER PRIMARY KEY, " +
                "tenKH TEXT NOT NULL, " +
                "soDT TEXT NOT NULL," +
                "matKhau TEXT NOT NULL)";
        db.execSQL(createTableKhachHang);

        String insertDefaultKhachHang = "INSERT INTO KhachHang (maKH, tenKH,soDT, matKhau) VALUES "
                + "('kh01', 'kieutanminh','012345679', '123')," +
                "('kh02', 'nguyenvanhieu','012345769', '321')";
        db.execSQL(insertDefaultKhachHang);

        String createTableLoaiSanPham = "CREATE TABLE LoaiSanPham (" +
                "maLoai INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "tenLoai TEXT NOT NULL)";
        db.execSQL(createTableLoaiSanPham);

        String createTableSanPham = "CREATE TABLE SanPham (" +
                "maSP INTEGER PRIMARY KEY AUTOINCREMENT," +
                "soLuong INTEGER NOT NULL, " +
                "tenSP TEXT NOT NULL, " +
                "giaTien INTERGER NOT NULL, " +
                "maLoai INTEGER NOT NULL, " +
                "FOREIGN KEY(maLoai) REFERENCES LoaiSanPham(maLoai))";
        db.execSQL(createTableSanPham);

        String createTableDanhGia = "CREATE TABLE DanhGia (" +
                "maDG INTEGER PRIMARY KEY AUTOINCREMENT," +
                "nhanXet TEXT NOT NULL, " +
                "ngayDG DATE NOT NULL, " +
                "maSP INTEGER NOT NULL, " +
                "FOREIGN KEY(maSP) REFERENCES SanPham(maSP))";
        db.execSQL(createTableDanhGia);

        String createTableGioHang = "CREATE TABLE GioHang (" +
                "maGH INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "tenSP TEXT NOT NULL, " +
                "giaTien INTERGER NOT NULL, " +
                "maSP INTEGER NOT NULL, " +
                "maHD INTEGER NOT NULL, " +
                "FOREIGN KEY(maHD) REFERENCES HoaDon(maHD)," +
                "FOREIGN KEY(maSP) REFERENCES SanPham(maSP))";
        db.execSQL(createTableGioHang);

        String createTableHoaDon = "CREATE TABLE HoaDon (" +
                "maHD INTEGER PRIMARY KEY AUTOINCREMENT," +
                "ngayDat DATE NOT NULL, " +
                "tongTien INTEGER NOT NULL, " +
                "soDT INTERGER NOT NULL, " +
                "diaChi TEXT NOT NULL, " +
                "maKH INTEGER NOT NULL, " +
                "FOREIGN KEY(maKH) REFERENCES KhachHang(maKH))";
        db.execSQL(createTableHoaDon);

        String createTableChiTietHoaDon = "CREATE TABLE HoaDon (" +
                "maCTHD INTEGER PRIMARY KEY AUTOINCREMENT," +
                "maHD INTEGER NOT NULL, " +
                "maSP INTEGER NOT NULL, " +
                "maKH INTEGER NOT NULL, " +
                "soLuong INTERGER NOT NULL, " +
                "giaTien INTEGER NOT NULL, " +
                "FOREIGN KEY(maHD) REFERENCES HoaDon(maHD)," +
                "FOREIGN KEY(maSP) REFERENCES SanPham(maSP)," +
                "FOREIGN KEY(maKH) REFERENCES KHACHHANG(maKH))";
        db.execSQL(createTableChiTietHoaDon);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS Admin");
        db.execSQL("DROP TABLE IF EXISTS KhachHang");
        db.execSQL("DROP TABLE IF EXISTS LoaiSanPham");
        db.execSQL("DROP TABLE IF EXISTS SanPham");
        db.execSQL("DROP TABLE IF EXISTS DanhGia");
        db.execSQL("DROP TABLE IF EXISTS GioHang");
        db.execSQL("DROP TABLE IF EXISTS HoaDon");
        db.execSQL("DROP TABLE IF EXISTS ChiTietHoaDon");
    }
}
