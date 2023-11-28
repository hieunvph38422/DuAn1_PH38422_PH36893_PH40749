package com.example.duan1_ph38422_ph36893_ph40749;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager2.widget.ViewPager2;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.duan1_ph38422_ph36893_ph40749.Fragment.Home_frg;
import com.example.duan1_ph38422_ph36893_ph40749.Fragment.Product_frg;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener{

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
                fragment = new Home_frg();

            } else if (itemId == R.id.pageSanPham) {
                fragment = new Product_frg();

            } else if (itemId == R.id.pageBanHang) {
//                fragment = new QlSachFragment();

            } else if (itemId == R.id.pageTaiKhoan) {
//                fragment = new QlThanhVienFragment();

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