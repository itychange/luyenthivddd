package com.lthdl.app.screen.questions.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.lthdl.app.BaseFragment;
import com.lthdl.app.R;
import com.lthdl.app.screen.questions.view.TextSingleChoiceAnswerView;

import butterknife.Bind;

public class TextSingleChoiseFragment extends BaseFragment {

    @Bind(R.id.lyTextSingleChoiceAnswerView)
    TextSingleChoiceAnswerView lyTextSingleChoiceAnswerView;

    protected void init(View paramView) {
        this.lyTextSingleChoiceAnswerView.setAnswerItemCount(4);
        this.lyTextSingleChoiceAnswerView.setAnswerCorrect(2);
        this.lyTextSingleChoiceAnswerView.setData();
    }

    @Nullable
    public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle) {
        return paramLayoutInflater.inflate(R.layout.question_text_single_choice_fragment, paramViewGroup, false);
    }
}