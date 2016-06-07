package com.lthdl.app.screen.home.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

public class HomeAdapter extends FragmentPagerAdapter {
    private final List<Fragment> mFragmentList = new ArrayList();
    private final List<String> mFragmentTitleList = new ArrayList();

    public HomeAdapter(FragmentManager paramFragmentManager) {
        super(paramFragmentManager);
    }

    public void addFrag(Fragment paramFragment, String paramString) {
        mFragmentList.add(paramFragment);
        mFragmentTitleList.add(paramString);
    }

    public int getCount() {
        return mFragmentList.size();
    }

    public Fragment getItem(int paramInt) {
        return mFragmentList.get(paramInt);
    }

    public CharSequence getPageTitle(int paramInt) {
        return (this.mFragmentTitleList.get(paramInt)).toUpperCase();
    }
}