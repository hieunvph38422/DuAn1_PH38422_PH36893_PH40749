package com.example.duan1_ph38422_ph36893_ph40749.Fragment;

import android.app.Dialog;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.duan1_ph38422_ph36893_ph40749.Adapter.Home_Adapter;
import com.example.duan1_ph38422_ph36893_ph40749.Dao.LuuHoaDonDao;
import com.example.duan1_ph38422_ph36893_ph40749.Dao.SanPhamDao;
import com.example.duan1_ph38422_ph36893_ph40749.Dao.UserDao;
import com.example.duan1_ph38422_ph36893_ph40749.Model.SanPham;
import com.example.duan1_ph38422_ph36893_ph40749.Model.TheLoai;
import com.example.duan1_ph38422_ph36893_ph40749.Model.User;
import com.example.duan1_ph38422_ph36893_ph40749.R;

import java.util.ArrayList;


public class Home_frg extends Fragment {


    RecyclerView recycler_SPBanChay;
    private Home_Adapter home_adapter;
    private ArrayList<SanPham> listSpTopOut = new ArrayList<>();
    LuuHoaDonDao luuHoaDonDao;
    SanPhamDao sanPhamDao;
    LinearLayout layoutParent;
    UserDao userDao;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_home_frg, container, false);
        ImageView imgNotifi = view.findViewById(R.id.imgNotifi);
        layoutParent = view.findViewById(R.id.layoutParent);
        recycler_SPBanChay = view.findViewById(R.id.recycler_SPBanChay);
        TextView txtHello = view.findViewById(R.id.txtHello);
        luuHoaDonDao = new LuuHoaDonDao(getContext());
        sanPhamDao = new SanPhamDao(getContext());
        userDao = new UserDao(getContext());

        SharedPreferences pref = getActivity().getSharedPreferences("USER_FILE", getActivity().MODE_PRIVATE);
        int maUserNow = pref.getInt("MA", 0);
        User user = userDao.getUser(maUserNow);
        String fullName = user.getFullName();

        txtHello.setText("Xin chào, " + fullName + "!");

        ArrayList<SanPham> listSanPham = sanPhamDao.getAllProduct(0);
        ArrayList<Integer> listMaSPTop = luuHoaDonDao.getTopSP();
        for (int i = 0; i < listMaSPTop.size(); i++) {
            for (int j = 0; j < listSanPham.size(); j++) {
                if (listMaSPTop.get(i) == listSanPham.get(j).getId()){
                    listSpTopOut.add(listSanPham.get(j));
                }
            }
        }

        ArrayList<TheLoai> listLoaiSP = sanPhamDao.getDSLSP();
        for (int i = 0; i < listLoaiSP.size(); i++) {
            ArrayList<SanPham> listSP = sanPhamDao.getSPofTL(listLoaiSP.get(i).getMaLoai());
            if (listSP.size() != 0){
                View addLayout = inflater.inflate(R.layout.list_san_pham, null);
                TextView tittle = addLayout.findViewById(R.id.txtSPHomeTittle);
                tittle.setText(listLoaiSP.get(i).getTenLoai());
                RecyclerView recyclerViewAdd = addLayout.findViewById(R.id.recycler_SPTheoLoai);
                Home_Adapter home_adapter1 = new Home_Adapter(listSP, getContext());
                LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
                linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
                recyclerViewAdd.setLayoutManager(linearLayoutManager);
                recyclerViewAdd.setAdapter(home_adapter1);
                layoutParent.addView(addLayout);
            }
        }

        home_adapter = new Home_Adapter(listSpTopOut ,getActivity());
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        recycler_SPBanChay.setLayoutManager(linearLayoutManager);
        recycler_SPBanChay.setAdapter(home_adapter);

//        Notifi
        imgNotifi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Dialog dialog = new Dialog(getActivity());
                dialog.setContentView(R.layout.dialog_notifi);
                dialog.getWindow().setLayout(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.WRAP_CONTENT);
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

                EditText btnDongNotifi = dialog.findViewById(R.id.btnDongNotifi);
                btnDongNotifi.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.dismiss();
                    }
                });
                dialog.show();

            }
        });

        return view;
    }
}