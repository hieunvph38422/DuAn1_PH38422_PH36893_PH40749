package com.example.duan1_ph38422_ph36893_ph40749;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;
import android.view.MenuItem;

import com.example.duan1_ph38422_ph36893_ph40749.Fragment.Home_frg;
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

        loadFragment(new Home_frg());


    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        Fragment fragment;
//        switch (item.getItemId()) {
//            case R.id.pageTrangChu:
               fragment = new Home_frg();
                loadFragment(fragment);
               return true;
//
//            case R.id.pageSanPham:
//              fragment = new ProductFrgm();
//             loadFragment(fragment);
//                return true;
//
//            case R.id.pageBanHang:
//               fragment = new StoreFrgm();
//                loadFragment(fragment);
//                return true;
//
//            case R.id.pageTaiKhoan:
//               loadFragment(new Account_Fragment());
//                return true;
//        }
//        return false;
    }

    public void loadFragment(Fragment fragment){
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.frame_container, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }
}