package com.lthdl.app.screen.questions.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.lthdl.app.R;

import butterknife.Bind;
import butterknife.ButterKnife;

public class TextSingleChoiceAnswerItem extends FrameLayout {
    AnswerItemListener answerItemListener = new AnswerItemListener() {
        public void onItemAnswerClick(View paramView, int paramInt, boolean paramBoolean) {
        }
    };

    @Bind(R.id.imvCorrect)
    ImageView imvCorrect;

    @Bind(R.id.imvIncorrect)
    ImageView imvIncorrect;
    int index;
    boolean isCorrect;

    @Bind(R.id.lyAnswerContent)
    LinearLayout lyAnswerContent;

    @Bind(R.id.lyBoundAnswer)
    FrameLayout lyBoundAnswer;

    @Bind(R.id.tvAnswerContent)
    TextView tvAnswerContent;

    public TextSingleChoiceAnswerItem(Context paramContext) {
        super(paramContext);
        init();
    }

    public TextSingleChoiceAnswerItem(Context paramContext, AttributeSet paramAttributeSet) {
        super(paramContext, paramAttributeSet);
        init();
    }

    public TextSingleChoiceAnswerItem(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
        super(paramContext, paramAttributeSet, paramInt);
        init();
    }

    private void init() {
        LayoutInflater.from(getContext()).inflate(R.layout.view_text_single_choice_answer_item, this, true);
        ButterKnife.bind(this);
        setStatusNormal();
        this.lyAnswerContent.setOnClickListener(new OnClickListener() {
            public void onClick(View paramView) {
                TextSingleChoiceAnswerItem.this.answerItemListener.onItemAnswerClick(TextSingleChoiceAnswerItem.this, TextSingleChoiceAnswerItem.this.getIndex(), TextSingleChoiceAnswerItem.this.isCorrect);
            }
        });
    }

    public boolean checkAnswer() {
        if (this.isCorrect) {
            setStatusCorrect();
            return true;
        }
        setStatusInCorrect();
        return false;
    }

    public AnswerItemListener getAnswerItemListener() {
        return this.answerItemListener;
    }

    public int getIndex() {
        return this.index;
    }

    public boolean iCorrect() {
        return this.isCorrect;
    }

    public boolean isCorrect() {
        return this.isCorrect;
    }

    public void setAnswerItemListener(AnswerItemListener paramAnswerItemListener) {
        this.answerItemListener = paramAnswerItemListener;
    }

    public void setClickable(boolean paramBoolean) {
        this.lyAnswerContent.setClickable(false);
        this.lyAnswerContent.setEnabled(false);
    }

    public void setIndex(int paramInt) {
        this.index = paramInt;
    }

    public void setIsCorrect(boolean paramBoolean) {
        this.isCorrect = paramBoolean;
    }

    public void setStatusCorrect() {
        this.lyBoundAnswer.setBackgroundColor(getContext().getResources().getColor(R.color.greenBgCorrect));
        this.tvAnswerContent.setTextColor(getContext().getResources().getColor(R.color.greenCorrect));
        this.imvCorrect.setVisibility(View.VISIBLE);
        this.imvIncorrect.setVisibility(View.GONE);
    }

    public void setStatusInCorrect() {
        this.lyBoundAnswer.setBackgroundColor(getContext().getResources().getColor(R.color.redBgIncorrect));
        this.tvAnswerContent.setTextColor(getContext().getResources().getColor(R.color.redIncorrect));
        this.imvCorrect.setVisibility(View.GONE);
        this.imvIncorrect.setVisibility(View.VISIBLE);
    }

    public void setStatusNormal() {
        this.lyBoundAnswer.setBackgroundColor(getContext().getResources().getColor(R.color.blueBgAnswer));
        this.tvAnswerContent.setTextColor(getContext().getResources().getColor(R.color.blue));
        this.imvCorrect.setVisibility(View.GONE);
        this.imvIncorrect.setVisibility(View.GONE);
    }

    public static abstract interface AnswerItemListener {
        public abstract void onItemAnswerClick(View paramView, int paramInt, boolean paramBoolean);
    }
}