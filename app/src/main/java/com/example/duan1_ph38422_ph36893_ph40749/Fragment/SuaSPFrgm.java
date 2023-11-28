package com.example.duan1_ph38422_ph36893_ph40749.Fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.ImageView;

import com.example.duan1_ph38422_ph36893_ph40749.Dao.SanPhamDao;
import com.example.duan1_ph38422_ph36893_ph40749.Model.SanPham;
import com.example.duan1_ph38422_ph36893_ph40749.R;

import java.util.ArrayList;


public class SuaSPFrgm extends Fragment {
    EditText edUpdateTenSP, edUpdateGiaBan, edUpdateMoTa, btnUpdate;
    AutoCompleteTextView edtLoaiSP;
    SanPham sanPham;
    ImageView imgUpdate;
    SanPhamDao daoSanPham;
    String strTenSP, strMota, strLoaiSP;
    double strGiaban;
    ArrayList<SanPham> arrayList;
    Adapter adapter = null;
    int maLoai, index;
    boolean checkTL;

    public SuaSPFrgm(SanPham sanPham) {
        this.sanPham = sanPham;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_sua_s_p_frgm, container, false);
    }
}