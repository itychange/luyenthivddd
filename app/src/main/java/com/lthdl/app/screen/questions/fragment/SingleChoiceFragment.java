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
import com.lthdl.app.screen.questions.event.OnEventOneQuestionComplete;
import com.lthdl.app.screen.questions.view.BaseAnswerBottomView;
import com.lthdl.app.screen.questions.view.SingleChoiceAnswerView;

import org.greenrobot.eventbus.EventBus;

import butterknife.Bind;

public class SingleChoiceFragment extends BaseFragment {
    public static final String CLASS_NAME = " SingleChoiceFragment ";
    @Bind(R.id.lySingleAnswer)
    SingleChoiceAnswerView lySingleAnswer;

    protected void init(View paramView) {
//        Log.e(Constant.TAG, CLASS_NAME + " init()->start");
        this.lySingleAnswer.setIsShowQuestion(false);
        this.lySingleAnswer.setAnswerItemCount(4);
        this.lySingleAnswer.setData(2);
        this.lySingleAnswer.setBaseAnswerListener(new BaseAnswerBottomView.BaseAnswerListener() {
            public void onCompleteAnswer(boolean paramBoolean, int paramInt) {
//                Log.e(Constant.TAG, CLASS_NAME + " init()->onCompleteAnswer() 1");
                OnEventOneQuestionComplete localOnEventOneQuestionComplete = new OnEventOneQuestionComplete();
                localOnEventOneQuestionComplete.isCorrect = paramBoolean;
                EventBus.getDefault().post(localOnEventOneQuestionComplete);
//                Log.e(Constant.TAG, CLASS_NAME + " init()->onCompleteAnswer() 2");
            }

            public void onItemAnswerClick(View paramView, int paramInt, boolean paramBoolean) {
            }
        });
//        Log.e(Constant.TAG, CLASS_NAME + " init()->end");
    }

    @Nullable
    public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle) {
        return paramLayoutInflater.inflate(R.layout.question_single_choice_fragment, paramViewGroup, false);
    }
}