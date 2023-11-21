package com.example.duan1_ph38422_ph36893_ph40749.Adapter;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.duan1_ph38422_ph36893_ph40749.Domain.CategoryDomain;
import com.example.duan1_ph38422_ph36893_ph40749.Domain.DrinkDomain;
import com.example.duan1_ph38422_ph36893_ph40749.R;
import com.example.duan1_ph38422_ph36893_ph40749.ShowDetailActivity;

import java.util.ArrayList;

public class PopularAdapter extends RecyclerView.Adapter<PopularAdapter.ViewHolder> {

    ArrayList<DrinkDomain> drinkDomains;

    public PopularAdapter(ArrayList<DrinkDomain> drinkDomains) {
        this.drinkDomains = drinkDomains;
    }


    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.viewholder_popular,parent,false);
        return new ViewHolder(inflate);
    }

    @SuppressLint("RecyclerView")
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.title.setText(drinkDomains.get(position).getTitle());
        holder.fee.setText(String.valueOf(drinkDomains.get(position).getFee()));

        int drawableResourceID = holder.itemView.getContext().getResources().getIdentifier(drinkDomains.get(position).getPic(),"drawable", holder.itemView.getContext().getPackageName());


        Glide.with(holder.itemView.getContext()).load(drawableResourceID).into(holder.pic);
        holder.addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(holder.itemView.getContext(), ShowDetailActivity.class);
                intent.putExtra("object",drinkDomains.get(position));
                holder.itemView.getContext().startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return drinkDomains.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView title, fee;
        ImageView pic;
        TextView addBtn;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.title);
            fee = itemView.findViewById(R.id.fee);
            pic = itemView.findViewById(R.id.pic);
            addBtn = itemView.findViewById(R.id.addBtn);

        }
    }

}
