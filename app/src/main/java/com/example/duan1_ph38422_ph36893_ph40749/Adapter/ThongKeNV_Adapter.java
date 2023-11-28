package com.example.duan1_ph38422_ph36893_ph40749.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import com.example.duan1_ph38422_ph36893_ph40749.Dao.LuuHoaDonDao;
import com.example.duan1_ph38422_ph36893_ph40749.Dao.UserDao;
import com.example.duan1_ph38422_ph36893_ph40749.Fragment.ViewUserInfor_frg;
import com.example.duan1_ph38422_ph36893_ph40749.Model.LuuHoaDon;
import com.example.duan1_ph38422_ph36893_ph40749.Model.User;
import com.example.duan1_ph38422_ph36893_ph40749.R;

import java.util.ArrayList;

public class ThongKeNV_Adapter extends RecyclerView.Adapter<ThongKeNV_Adapter.ViewHolder>{
    ArrayList<LuuHoaDon> list;
    Context context;
    LuuHoaDonDao luuHoaDonDao;
    UserDao userDao;

    public ThongKeNV_Adapter(Context context, ArrayList<LuuHoaDon> list) {
        this.context = context;
        this.list = list;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_thongkenhanvien, parent, false);
        luuHoaDonDao = new LuuHoaDonDao(view.getContext());
        userDao = new UserDao(view.getContext());
        return new ThongKeNV_Adapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        LuuHoaDon luuHoaDon = list.get(position);
        String index = "";
        if (position < 9){
            index = "0" + (position + 1);
        }
        else{
            index = String.valueOf(position + 1);
        }
        holder.txtTknvSTT.setText(index);
        holder.txtTknvTenNv.setText(luuHoaDon.getTenUser());

        if (String.valueOf(luuHoaDon.getThanhTien()) != null){
            double doanhThu = luuHoaDon.getThanhTien();
            String outTongTien = String.format("%,.0f", doanhThu);
            if (outTongTien.length() > 4){
                String subDoanhThu = outTongTien.substring(0, (outTongTien.length() - 4));
                holder.txtTknvDoanhThu.setText(subDoanhThu + "K VNĐ");
            }
            else {
                holder.txtTknvDoanhThu.setText(outTongTien + "K VNĐ");
            }

        }
        else {
            holder.txtTknvDoanhThu.setText("0 VNĐ");
        }
        if (position == (list.size() - 1)){
            holder.bottomViewTknv.setVisibility(View.GONE);
        }

        User user = userDao.getUser(luuHoaDon.getMaUser());

//        Item Click
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Load Fragment hiển thị thông tin nhân viên
                loadFragment(new ViewUserInfor_frg(user));
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView txtTknvSTT, txtTknvTenNv, txtTknvDoanhThu;
        View bottomViewTknv;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txtTknvSTT = itemView.findViewById(
                    R.id.txtTknvSTT);
            txtTknvTenNv = itemView.findViewById(R.id.txtTknvTenNv);
            txtTknvDoanhThu = itemView.findViewById(R.id.txtTknvDoanhThu);
            bottomViewTknv = itemView.findViewById(R.id.bottomViewTknv);
        }
    }

    private void loadFragment(Fragment fragment) {
        FragmentTransaction transaction = ((FragmentActivity)context).getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.frame_container, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }

}
