package com.lthdl.app.screen.questions.view.group_question.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

public class ChildFragmentQuestionAdapter extends FragmentPagerAdapter {
    List<Fragment> fragmentList;

    public ChildFragmentQuestionAdapter(FragmentManager paramFragmentManager, List<Fragment> paramList) {
        super(paramFragmentManager);
        fragmentList = paramList;
    }

    public int getCount() {
        return fragmentList.size();
    }

    public Fragment getItem(int paramInt) {
        return fragmentList.get(paramInt);
    }
}