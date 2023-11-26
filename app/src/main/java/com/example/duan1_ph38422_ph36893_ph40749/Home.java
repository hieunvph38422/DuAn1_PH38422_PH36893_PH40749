package com.example.duan1_ph38422_ph36893_ph40749;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.ListView;
import android.widget.ViewFlipper;

import com.google.android.material.navigation.NavigationView;

public class Home extends AppCompatActivity {
  Toolbar toolbar;
  RecyclerView recyclerViewManHinhChinh;
  NavigationView navigationView;
  ListView listViewManHinhChinh;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        AnhXa();
    }

    private void AnhXa() {
        toolbar = findViewById(R.id.toolbarmanhinhchinh);
        recyclerViewManHinhChinh = findViewById(R.id.recycleview);
        listViewManHinhChinh = findViewById(R.id.listviewmanhinhchinh);
        navigationView = findViewById(R.id.navigationview);
    }
}