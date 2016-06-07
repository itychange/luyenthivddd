package com.lthdl.app.screen.questions.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.lthdl.app.BaseFragment;
import com.lthdl.app.R;
import com.lthdl.app.screen.questions.event.OnEventOneQuestionComplete;
import com.lthdl.app.screen.questions.view.BaseAnswerBottomView;
import com.lthdl.app.screen.questions.view.MultiChoiceAnswerView;

import org.greenrobot.eventbus.EventBus;

import butterknife.Bind;

public class MultiChoiceFragment extends BaseFragment {

    @Bind(R.id.lyMultiAnswer)
    MultiChoiceAnswerView lyMultiAnswer;

    protected void init(View paramView) {
        this.lyMultiAnswer.setIsShowQuestion(false);
        this.lyMultiAnswer.setCorrectIndexAnswer(new int[]{0, 1, 3});
        this.lyMultiAnswer.setAnswerItemCount(5);
        this.lyMultiAnswer.setData();
        this.lyMultiAnswer.setBaseAnswerListener(new BaseAnswerBottomView.BaseAnswerListener() {
            public void onCompleteAnswer(boolean paramBoolean, int paramInt) {
                OnEventOneQuestionComplete localOnEventOneQuestionComplete = new OnEventOneQuestionComplete();
                localOnEventOneQuestionComplete.isCorrect = paramBoolean;
                EventBus.getDefault().post(localOnEventOneQuestionComplete);
            }

            public void onItemAnswerClick(View paramView, int paramInt, boolean paramBoolean) {
            }
        });
    }

    @Nullable
    public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle) {
        return paramLayoutInflater.inflate(R.layout.question_multi_choice_fragment, paramViewGroup, false);
    }
}