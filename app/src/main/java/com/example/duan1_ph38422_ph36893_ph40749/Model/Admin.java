package com.example.duan1_ph38422_ph36893_ph40749.Model;

public class Admin {
    private String maAdmin;
    private String tenDangNhap;
    private String matKhau;

    public Admin(String maAdmin, String tenDangNhap, String matKhau) {
        this.maAdmin = maAdmin;
        this.tenDangNhap = tenDangNhap;
        this.matKhau = matKhau;
    }

    public String getMaAdmin() {
        return maAdmin;
    }

    public void setMaAdmin(String maAdmin) {
        this.maAdmin = maAdmin;
    }

    public String getTenDangNhap() {
        return tenDangNhap;
    }

    public void setTenDangNhap(String tenDangNhap) {
        this.tenDangNhap = tenDangNhap;
    }

    public String getMatKhau() {
        return matKhau;
    }

    public void setMatKhau(String matKhau) {
        this.matKhau = matKhau;
    }
}
