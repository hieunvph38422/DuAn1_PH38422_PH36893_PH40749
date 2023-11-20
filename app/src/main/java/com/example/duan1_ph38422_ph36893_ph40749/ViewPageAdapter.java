package com.example.duan1_ph38422_ph36893_ph40749;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class ViewPageAdapter extends FragmentStateAdapter {


    public ViewPageAdapter(@NonNull MainActivity fragment) {
        super(fragment);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position){
            case 0: return new LoginFragment();
            case 1: return new SignupFragment();
        }
        return new LoginFragment();

    }

    @Override
    public int getItemCount() {
        return 2;
    }
}
