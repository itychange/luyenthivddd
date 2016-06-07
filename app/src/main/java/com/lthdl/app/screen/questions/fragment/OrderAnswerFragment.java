package com.lthdl.app.screen.questions.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.lthdl.app.BaseFragment;
import com.lthdl.app.R;
import com.lthdl.app.global.Constant;
import com.lthdl.app.screen.questions.event.OnEventAnswerModified;
import com.lthdl.app.screen.questions.event.OnEventOneQuestionComplete;
import com.lthdl.app.screen.questions.view.order_answer.OrderAnswerView;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import butterknife.Bind;

public class OrderAnswerFragment extends BaseFragment {
    public static final String CLASS_NAME = " OrderAnswerFragment ";
    @Bind(R.id.imvCheckAnswer)
    ImageView imvCheckAnswer;

    @Bind(R.id.orderAnswerView)
    OrderAnswerView orderAnswerView;

    protected void init(View paramView) {
        this.imvCheckAnswer.setVisibility(View.GONE);
        this.orderAnswerView.initData();
        this.imvCheckAnswer.setOnClickListener(new OnClickListener() {
            public void onClick(View paramView) {
                OrderAnswerFragment.this.orderAnswerView.checkAnswer();
                OrderAnswerFragment.this.imvCheckAnswer.setVisibility(View.GONE);
                OnEventOneQuestionComplete onEventOneQuestionComplete = new OnEventOneQuestionComplete();
                onEventOneQuestionComplete.isCorrect = false;
                EventBus.getDefault().post(onEventOneQuestionComplete);
            }
        });
    }

    @Nullable
    public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle) {
        return paramLayoutInflater.inflate(R.layout.question_order_answer_fragment, paramViewGroup, false);
    }

    @Subscribe
    public void onEvent(OnEventAnswerModified paramOnEventAnswerModified) {
//        Log.e(Constant.TAG, CLASS_NAME + "itemTouchOnMove()->start");
        this.imvCheckAnswer.setVisibility(View.VISIBLE);
//        Log.e(Constant.TAG, CLASS_NAME + "itemTouchOnMove()->end");
    }
}