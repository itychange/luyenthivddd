package com.lthdl.app.screen.questions.view.order_answer.adapter;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.lthdl.app.R;

import butterknife.Bind;
import butterknife.ButterKnife;

public class OrderAnswerItem extends FrameLayout {
    int correctIndex;

    @Bind(R.id.imvCorrect)
    ImageView imvCorrect;

    @Bind(R.id.imvIncorrect)
    ImageView imvIncorrect;
    int index;

    @Bind(R.id.lyBoundAnswerItem)
    RelativeLayout lyBoundAnswerItem;

    @Bind(R.id.tvOrderAnswer)
    TextView tvOrderAnswer;

    public OrderAnswerItem(Context paramContext) {
        super(paramContext);
        init();
    }

    public OrderAnswerItem(Context paramContext, AttributeSet paramAttributeSet) {
        super(paramContext, paramAttributeSet);
        init();
    }

    public OrderAnswerItem(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
        super(paramContext, paramAttributeSet, paramInt);
        init();
    }

    private void init() {
        LayoutInflater.from(getContext()).inflate(R.layout.view_order_answer_item, this, true);
        ButterKnife.bind(this);
        setStatusNormal();
    }

    public boolean checkAnswer() {
        if (getIndex() == getCorrectIndex()) {
            setStatusCorrect();
            return true;
        }
        setStatusInCorrect();
        return false;
    }

    public int getCorrectIndex() {
        return this.correctIndex;
    }

    public int getIndex() {
        return this.index;
    }

    public void setContentAnswer(String paramString) {
        this.tvOrderAnswer.setText(paramString);
    }

    public void setCorrectIndex(int paramInt) {
        this.correctIndex = paramInt;
    }

    public void setIndex(int paramInt) {
        this.index = paramInt;
    }

    public void setStatusCorrect() {
        this.lyBoundAnswerItem.setBackgroundColor(getContext().getResources().getColor(R.color.greenBgCorrect));
        this.imvCorrect.setVisibility(View.VISIBLE);
        this.imvIncorrect.setVisibility(View.GONE);
    }

    public void setStatusInCorrect() {
        this.lyBoundAnswerItem.setBackgroundColor(getContext().getResources().getColor(R.color.redBgIncorrect));
        this.imvCorrect.setVisibility(View.GONE);
        this.imvIncorrect.setVisibility(View.VISIBLE);
    }

    public void setStatusNormal() {
        this.imvCorrect.setVisibility(View.INVISIBLE);
        this.imvIncorrect.setVisibility(View.INVISIBLE);
    }
}