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
        category.add(new CategoryDomain("Latte","orange_juice"));
        category.add(new CategoryDomain("Mocha","orange_juice"));
        category.add(new CategoryDomain("Cherry","orange_juice"));
        category.add(new CategoryDomain("Moka","orange_juice"));

        adapter= new CategoryAdapter(category);
        recyclerViewCategoryList.setAdapter(adapter);

    }
    private  void recyclerViewPopular(){
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL,false);
        recyclerViewPopularList = findViewById(R.id.recyclerView2);
        recyclerViewPopularList.setLayoutManager(linearLayoutManager);

        ArrayList<DrinkDomain> drinkList = new ArrayList<>();
        drinkList.add(new DrinkDomain("Latte","cocktail","slies sgdsgdg, sdfsdgds, fsfgsd",25.000));
        drinkList.add(new DrinkDomain("Mocha","cocktail","slies sgdsgdg, sdfsdgds, fsfgsd",30.000));
        drinkList.add(new DrinkDomain("Cherry","cocktail","slies sgdsgdg, sdfsdgds, fsfgsd",35.000));
        drinkList.add(new DrinkDomain("Moka","cocktail","slies sgdsgdg, sdfsdgds, fsfgsd",40.000));

        adapter2 = new PopularAdapter(drinkList);
        recyclerViewPopularList.setAdapter(adapter2);
    }

}