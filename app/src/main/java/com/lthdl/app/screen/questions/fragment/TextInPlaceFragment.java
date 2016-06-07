package com.lthdl.app.screen.questions.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.lthdl.app.BaseFragment;
import com.lthdl.app.R;
import com.lthdl.app.common.Utils;
import com.lthdl.app.screen.questions.event.OnEventOneQuestionComplete;
import com.lthdl.app.screen.questions.view.TextInPlaceLayout;

import org.greenrobot.eventbus.EventBus;

import butterknife.Bind;

import com.lthdl.app.screen.questions.view.TextInPlaceLayout.TextPlaceLayoutListener;

public class TextInPlaceFragment extends BaseFragment {

    @Bind(R.id.imvCheckAnswer)
    ImageView imvCheckAnswer;
    boolean isCorrect = false;

    @Bind(R.id.lyTextInPlace)
    TextInPlaceLayout lyTextInPlace;

    void hideCheckAnswer() {
        this.imvCheckAnswer.setVisibility(View.GONE);
    }

    protected void init(View paramView) {
        hideCheckAnswer();
        this.imvCheckAnswer.setOnClickListener(new OnClickListener() {
            public void onClick(View paramView) {
                Utils.hideKeyboard(TextInPlaceFragment.this.getActivity());
                TextInPlaceFragment.this.isCorrect = TextInPlaceFragment.this.lyTextInPlace.chekcAnswer();
                Utils.showToast(TextInPlaceFragment.this.getActivity(), "Answer is " + TextInPlaceFragment.this.isCorrect, true);
                TextInPlaceFragment.this.hideCheckAnswer();
            }
        });
        this.lyTextInPlace.setQuestion("Dịch từ sau sang tiếng việt:\nHello wolrd");
        this.lyTextInPlace.setAnswer("Xin chào thế giới");
        this.lyTextInPlace.setTextPlaceLayoutListener(new TextInPlaceLayout.TextPlaceLayoutListener() {
            public void onAnswerFilled(String paramString) {
                if (paramString.equals("")) {
                    TextInPlaceFragment.this.hideCheckAnswer();
                    return;
                }
                TextInPlaceFragment.this.showCheckAnswer();
            }

            public void onCompleteAnswer(boolean paramBoolean, int paramInt) {
                OnEventOneQuestionComplete localOnEventOneQuestionComplete = new OnEventOneQuestionComplete();
                localOnEventOneQuestionComplete.setCorrect(paramBoolean);
                EventBus.getDefault().post(localOnEventOneQuestionComplete);
            }
        });
    }

    @Nullable
    public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle) {
        return paramLayoutInflater.inflate(R.layout.question_textinplace_fragment, paramViewGroup, false);
    }

    void showCheckAnswer() {
        if (this.imvCheckAnswer.getVisibility() == View.GONE)
            this.imvCheckAnswer.setVisibility(View.VISIBLE);
    }
}