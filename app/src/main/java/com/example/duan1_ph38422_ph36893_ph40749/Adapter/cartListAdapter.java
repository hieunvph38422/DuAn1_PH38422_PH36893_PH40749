package com.example.duan1_ph38422_ph36893_ph40749.Adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.duan1_ph38422_ph36893_ph40749.Domain.DrinkDomain;
import com.example.duan1_ph38422_ph36893_ph40749.Helper.ManagenentCart;
import com.example.duan1_ph38422_ph36893_ph40749.Interface.ChangeNumberItemsListener;
import com.example.duan1_ph38422_ph36893_ph40749.R;

import java.util.ArrayList;

public class cartListAdapter extends RecyclerView.Adapter<cartListAdapter.ViewHolder> {
    private ArrayList<DrinkDomain> drinkDomains;
    private ManagenentCart managenentCart;
    private DrinkDomain drinkDomain;
    private ChangeNumberItemsListener changeNumberItemsListener;

    public cartListAdapter(ArrayList<DrinkDomain> drinkDomains, Context context, ChangeNumberItemsListener changeNumberItemsListener) {
        this.drinkDomains = drinkDomains;
        this.managenentCart =new ManagenentCart(context);
        this.changeNumberItemsListener = changeNumberItemsListener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
    View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.viewholder_cart, parent, false);
        return new ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, @SuppressLint("RecyclerView") int position) {
        holder.title.setText(drinkDomains.get(position).getTitle());
        holder.feeEachItem.setText(String.valueOf(drinkDomains.get(position).getFee()));
        holder.totalEachItem.setText(String.valueOf(Math.round((drinkDomains.get(position).getNumberInCart() * drinkDomains.get(position).getFee())*100)/100));
        holder.num.setText(String.valueOf(drinkDomains.get(position).getNumberInCart()));

        int drawableReourceId = holder.itemView.getContext().getResources().getIdentifier(drinkDomains.get(position).getPic()
                ,"drawable", holder.itemView.getContext().getPackageName());

        Glide.with(holder.itemView.getContext()).load(drawableReourceId).into(holder.pic);

        holder.plusItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                managenentCart.plusNumberDrink(drinkDomains, position, new ChangeNumberItemsListener() {
                    @Override
                    public void change() {
                        notifyDataSetChanged();
                        changeNumberItemsListener.change();
                    }
                });
            }
        });
        holder.minusItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                managenentCart.minusNumberDrink(drinkDomains, position, new ChangeNumberItemsListener() {
                    @Override
                    public void change() {
                        notifyDataSetChanged();
                        changeNumberItemsListener.change();
                    }
                });
            }
        });
    }

    @Override
    public int getItemCount() {
        return drinkDomains.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView title, feeEachItem;
        ImageView pic, plusItem, minusItem;
        TextView totalEachItem, num;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.titleTxt);
            feeEachItem=itemView.findViewById(R.id.feeEachItem);
            pic = itemView.findViewById(R.id.picCart);
            totalEachItem=itemView.findViewById(R.id.totalEachItem);
            num=itemView.findViewById(R.id.numberItemTxt);
            plusItem=itemView.findViewById(R.id.plusCartBtn);
            minusItem=itemView.findViewById(R.id.minusCartBtn);

        }
    }
}
