package com.example.duan1_ph38422_ph36893_ph40749.Adapter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.duan1_ph38422_ph36893_ph40749.Domain.DrinkDomain;
import com.example.duan1_ph38422_ph36893_ph40749.Helper.ManagenentCart;
import com.example.duan1_ph38422_ph36893_ph40749.Interface.ChangeNumberItemsListener;

import java.util.ArrayList;

public class cartListAdapter extends RecyclerView.Adapter<cartListAdapter.ViewHolder> {
    private ArrayList<DrinkDomain> drinkDomains;
    private ManagenentCart managenentCart;
    private ChangeNumberItemsListener changeNumberItemsListener;

    public cartListAdapter(ArrayList<DrinkDomain> drinkDomains, ManagenentCart managenentCart, ChangeNumberItemsListener changeNumberItemsListener) {
        this.drinkDomains = drinkDomains;
        this.managenentCart = managenentCart;
        this.changeNumberItemsListener = changeNumberItemsListener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return drinkDomains.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView title, feeEachItem;
        ImageView pic, plusItem, minusItem;
        TextView totialEachItem, num;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            title=itemView.findViewById(R.id.)
        }
    }
}
