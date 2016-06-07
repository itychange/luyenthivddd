package com.lthdl.app.screen.questions.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;

import com.lthdl.app.R;
import com.lthdl.app.screen.questions.event.OnEventOneQuestionComplete;

import org.greenrobot.eventbus.EventBus;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

public class TextSingleChoiceAnswerView extends LinearLayout {
    public static final String CLASS_NAME = " TextSingleChoiceAnswerView ";
    private int answerCorrect;
    private int answerItemCount;

    @Bind(R.id.lyListAnswerContent)
    LinearLayout lyListAnswerContent;
    TextSingleChoiceAnswerItem textSingleChoiceAnswerItemCorrect = null;
    List<TextSingleChoiceAnswerItem> textSingleChoiceAnswerItems = new ArrayList();

    public TextSingleChoiceAnswerView(Context paramContext) {
        super(paramContext);
        init();
    }

    public TextSingleChoiceAnswerView(Context paramContext, AttributeSet paramAttributeSet) {
        super(paramContext, paramAttributeSet);
        init();
    }

    public TextSingleChoiceAnswerView(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
        super(paramContext, paramAttributeSet, paramInt);
        init();
    }

    private void init() {
        LayoutInflater.from(getContext()).inflate(R.layout.view_text_single_choise_view, this, true);
        ButterKnife.bind(this);
    }

    public int getAnswerCorrect() {
        return this.answerCorrect;
    }

    public int getAnswerItemCount() {
        return this.answerItemCount;
    }

    public void setAnswerCorrect(int paramInt) {
        this.answerCorrect = paramInt;
    }

    public void setAnswerItemCount(int paramInt) {
        this.answerItemCount = paramInt;
    }

    public void setData() {
        int i = 0;
        for (i = 0; i < getAnswerItemCount(); i++) {
            TextSingleChoiceAnswerItem localTextSingleChoiceAnswerItem = new TextSingleChoiceAnswerItem(getContext());
            localTextSingleChoiceAnswerItem.setIndex(i);
            localTextSingleChoiceAnswerItem.setAnswerItemListener(new TextSingleChoiceAnswerItem.AnswerItemListener() {
                public void onItemAnswerClick(View paramView, int paramInt, boolean paramBoolean) {
                    ((TextSingleChoiceAnswerItem) paramView).checkAnswer();
                    Object localObject = TextSingleChoiceAnswerView.this.textSingleChoiceAnswerItems.iterator();
                    while (((Iterator) localObject).hasNext())
                        ((TextSingleChoiceAnswerItem) ((Iterator) localObject).next()).setClickable(false);
                    TextSingleChoiceAnswerView.this.textSingleChoiceAnswerItemCorrect.checkAnswer();
                    localObject = new OnEventOneQuestionComplete();
                    ((OnEventOneQuestionComplete) localObject).isCorrect = ((TextSingleChoiceAnswerItem) paramView).isCorrect();
                    EventBus.getDefault().post(localObject);
                }
            });
            LayoutParams localLayoutParams = (LayoutParams) this.lyListAnswerContent.getLayoutParams();
            localLayoutParams.width = -1;
            localLayoutParams.height = 0;
            localLayoutParams.weight = 1.0F;
            this.lyListAnswerContent.addView(localTextSingleChoiceAnswerItem, localLayoutParams);
            this.textSingleChoiceAnswerItems.add(localTextSingleChoiceAnswerItem);
            if (i == getAnswerCorrect()) {
                localTextSingleChoiceAnswerItem.setIsCorrect(true);
                this.textSingleChoiceAnswerItemCorrect = localTextSingleChoiceAnswerItem;
            } else {
                localTextSingleChoiceAnswerItem.setIsCorrect(false);
            }
        }
    }
}