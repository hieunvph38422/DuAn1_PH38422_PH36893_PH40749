package com.example.duan1_ph38422_ph36893_ph40749;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import com.example.duan1_ph38422_ph36893_ph40749.Activity.CartListActivity;
import com.example.duan1_ph38422_ph36893_ph40749.Adapter.CategoryAdapter;
import com.example.duan1_ph38422_ph36893_ph40749.Adapter.PopularAdapter;
import com.example.duan1_ph38422_ph36893_ph40749.Domain.CategoryDomain;
import com.example.duan1_ph38422_ph36893_ph40749.Domain.DrinkDomain;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class Home extends AppCompatActivity {

    private RecyclerView.Adapter adapter, adapter2;
    private RecyclerView recyclerViewCategoryList, recyclerViewPopularList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        recyclerViewCategory();
        recyclerViewPopular();
        bottomNavigation();
    }

    private void bottomNavigation(){
        FloatingActionButton floatingActionButton = findViewById(R.id.cartBtn);
        LinearLayout homeBtn = findViewById(R.id.homeBtn);

        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Home.this, CartListActivity.class));
            }
        });
        homeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Home.this, Home.class));
            }
        });
    }
    private void recyclerViewCategory() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL,false);
        recyclerViewCategoryList=findViewById(R.id.recyclerView);
        recyclerViewCategoryList.setLayoutManager(linearLayoutManager);

        ArrayList<CategoryDomain> category = new ArrayList<>();
        category.add(new CategoryDomain("Pizza","cat_1"));
        category.add(new CategoryDomain("izzaa","cat_2"));
        category.add(new CategoryDomain("zzaaa","cat_3"));
        category.add(new CategoryDomain("zaaaa","cat_4"));

        adapter= new CategoryAdapter(category);
        recyclerViewCategoryList.setAdapter(adapter);

    }
    private  void recyclerViewPopular(){
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL,false);
        recyclerViewPopularList = findViewById(R.id.recyclerView2);
        recyclerViewPopularList.setLayoutManager(linearLayoutManager);

        ArrayList<DrinkDomain> drinkList = new ArrayList<>();
        drinkList.add(new DrinkDomain("Minh","pizza","slies sgdsgdg, sdfsdgds, fsfgsd",9.76));
        drinkList.add(new DrinkDomain("hieu2","pizza","slies sgdsgdg, sdfsdgds, fsfgsd",9.6));
        drinkList.add(new DrinkDomain("hieu3","pizza","slies sgdsgdg, sdfsdgds, fsfgsd",9.7));
        drinkList.add(new DrinkDomain("hieu4","pizza","slies sgdsgdg, sdfsdgds, fsfgsd",9.86));

        adapter2 = new PopularAdapter(drinkList);
        recyclerViewPopularList.setAdapter(adapter2);
    }

}