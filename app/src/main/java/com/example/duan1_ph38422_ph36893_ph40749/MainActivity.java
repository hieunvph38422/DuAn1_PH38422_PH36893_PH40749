package com.example.duan1_ph38422_ph36893_ph40749;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.example.duan1_ph38422_ph36893_ph40749.FragmentManager.Account_Fragment;
import com.example.duan1_ph38422_ph36893_ph40749.FragmentManager.HomeFrgm;
import com.example.duan1_ph38422_ph36893_ph40749.FragmentManager.ProductFrgm;
import com.example.duan1_ph38422_ph36893_ph40749.FragmentManager.StoreFrgm;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {

    public static BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bottomNavigationView = findViewById(R.id.navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(this);
        bottomNavigationView.setSelectedItemId(R.id.pageTrangChu);

    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int itemId = item.getItemId();
        showMenu(itemId);
        return true;
    }

    private boolean showMenu(int itemId) {
        Fragment fragment = null;
        try {
            if (itemId == R.id.pageTrangChu) {
                fragment = new HomeFrgm();

            } else if (itemId == R.id.pageSanPham) {
                fragment = new ProductFrgm();

            } else if (itemId == R.id.pageBanHang) {
                fragment = new StoreFrgm();

            } else if (itemId == R.id.pageTaiKhoan) {
                fragment = new Account_Fragment();

            }
            if (fragment != null) {
                getSupportFragmentManager().beginTransaction().replace(R.id.frame_container, fragment).commit();

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }

}