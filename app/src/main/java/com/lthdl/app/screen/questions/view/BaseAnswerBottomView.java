package com.lthdl.app.screen.questions.view;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.lthdl.app.R;
import com.lthdl.app.global.Constant;

import butterknife.Bind;
import butterknife.ButterKnife;

public abstract class BaseAnswerBottomView extends LinearLayout {
    public static final String CLASS_NAME = " BaseAnswerBottomView ";
    private int answerCorrect;
    private int answerItemCount;
    BaseAnswerListener baseAnswerListener = new BaseAnswerListener() {
        public void onCompleteAnswer(boolean paramBoolean, int paramInt) {
        }

        public void onItemAnswerClick(View paramView, int paramInt, boolean paramBoolean) {
        }
    };
    private boolean isShowQuestion = false;

    @Bind(R.id.lyListAnswerContent)
    LinearLayout lyListAnswerContent;

    @Bind(R.id.tvQuestion)
    TextView tvQuestion;

    public BaseAnswerBottomView(Context paramContext) {
        super(paramContext);
        init();
    }

    public BaseAnswerBottomView(Context paramContext, AttributeSet paramAttributeSet) {
        super(paramContext, paramAttributeSet);
        init();
    }

    public BaseAnswerBottomView(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
        super(paramContext, paramAttributeSet, paramInt);
        init();
    }

    public BaseAnswerBottomView(Context paramContext, boolean paramBoolean) {
        super(paramContext);
        init();
        setIsShowQuestion(paramBoolean);
    }

    private void init() {
        LayoutInflater.from(getContext()).inflate(R.layout.view_base_answer_bottom, this, true);
        ButterKnife.bind(this);
        afterInit();
    }

    abstract void afterInit();

    public int getAnswerCorrect() {
        return this.answerCorrect;
    }

    public int getAnswerItemCount() {
        return this.answerItemCount;
    }

    public boolean isShowQuestion() {
        return this.isShowQuestion;
    }

    public void setAnswerCorrect(int paramInt) {
        this.answerCorrect = paramInt;
    }

    public void setAnswerItemCount(int paramInt) {
        this.answerItemCount = paramInt;
    }

    public void setBaseAnswerListener(BaseAnswerListener paramBaseAnswerListener) {
        this.baseAnswerListener = paramBaseAnswerListener;
    }

    public void setIsShowQuestion(boolean paramBoolean) {
        isShowQuestion = paramBoolean;
        if (paramBoolean){
            tvQuestion.setVisibility(View.VISIBLE);
        } else {
            tvQuestion.setVisibility(View.GONE);
        }

    }

    public void setQuestion(String paramString) {
        this.tvQuestion.setText(paramString);
    }

    public static abstract interface BaseAnswerListener extends BaseAnswerItemView.AnswerItemListener {
        public abstract void onCompleteAnswer(boolean paramBoolean, int paramInt);
    }
}