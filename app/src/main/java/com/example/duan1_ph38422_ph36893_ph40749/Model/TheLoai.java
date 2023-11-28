package com.example.duan1_ph38422_ph36893_ph40749.Model;

public class TheLoai {
    private int maLoai;
    private String tenLoai;

    public TheLoai(String strLoai) {
    }

    public TheLoai(int maLoai, String tenLoai) {
        this.maLoai = maLoai;
        this.tenLoai = tenLoai;
    }

    public int getMaLoai() {
        return maLoai;
    }

    public void setMaLoai(int maLoai) {
        this.maLoai = maLoai;
    }

    public String getTenLoai() {
        return tenLoai;
    }

    public void setTenLoai(String tenLoai) {
        this.tenLoai = tenLoai;
    }
}
