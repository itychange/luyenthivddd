package com.lthdl.app.screen.questions.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.lthdl.app.BaseFragment;
import com.lthdl.app.R;

public class JumpOrderAnswerFragment extends BaseFragment {
    protected void init(View paramView) {
    }

    @Nullable
    public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle) {
        return LayoutInflater.from(paramViewGroup.getContext()).inflate(R.layout.question_jumporderanswer_fragment, paramViewGroup, false);
    }
}