package com.lthdl.app.screen.questions.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.lthdl.app.BaseFragment;
import com.lthdl.app.R;
import com.lthdl.app.global.Constant;

public class JumpTextInPlaceFragment extends BaseFragment {
    public static final String CLASS_NAME = " JumpTextInPlaceFragment ";
    protected void init(View paramView) {
        Log.e(Constant.TAG, CLASS_NAME + " init()");
    }

    @Nullable
    public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle) {
        Log.e(Constant.TAG, CLASS_NAME + " onCreateView()");
        return LayoutInflater.from(paramViewGroup.getContext()).inflate(R.layout.question_jumptextinplace_fragment, paramViewGroup, false);
//        return paramLayoutInflater.inflate(R.layout.question_jumptextinplace_fragment, paramViewGroup, false);
    }
}