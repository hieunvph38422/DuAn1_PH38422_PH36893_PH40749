package com.example.duan1_ph38422_ph36893_ph40749.Fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.duan1_ph38422_ph36893_ph40749.Adapter.ThongKeNV_Adapter;
import com.example.duan1_ph38422_ph36893_ph40749.Dao.LuuHoaDonDao;
import com.example.duan1_ph38422_ph36893_ph40749.Model.LuuHoaDon;
import com.example.duan1_ph38422_ph36893_ph40749.R;

import java.util.ArrayList;


public class ThongKeNV_frg extends Fragment {

    public RecyclerView recycler_TKNV;
    public LuuHoaDonDao luuHoaDonDao;
    ArrayList<LuuHoaDon> listNhanVien;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_thong_ke_n_v_frg, container, false);

//        Ánh xạ các View;
        ImageView btnBackTKNV = view.findViewById(R.id.btnBackTKNV);
        TextView txtTKNVSoLg = view.findViewById(R.id.txtTKNVSoLg);
        recycler_TKNV = view.findViewById(R.id.recycler_TKNV);
        luuHoaDonDao = new LuuHoaDonDao(getContext());

        listNhanVien = luuHoaDonDao.tkNhanVien();
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        recycler_TKNV.setLayoutManager(linearLayoutManager);
        ThongKeNV_Adapter thongKeNVAdapter = new ThongKeNV_Adapter(getContext(), listNhanVien);
        recycler_TKNV.setAdapter(thongKeNVAdapter);

        txtTKNVSoLg.setText(listNhanVien.size() + " người");

        btnBackTKNV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadFragment(new Account_frg());
            }
        });

        return view;
    }

    private void loadFragment(Fragment fragment) {
        FragmentTransaction transaction = (getActivity()).getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.frame_container, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }
}