package com.redple.day2daynews;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class pagerAdapter extends FragmentPagerAdapter {
    int tabcount;
    public pagerAdapter( FragmentManager fm, int behavior) {
        super(fm, behavior);
        tabcount=behavior;

    }

    @Override
    public Fragment getItem(int position) {
        switch(position){
            case 0: return new homeFragment();

            case 1: return new catoFragment();

            case 2: return new favFragment();

            default:return null;
        }
    }

    @Override
    public int getCount() {
        return tabcount;
    }
}
