package com.lthdl.app.screen.questions.view;

import android.content.Context;
import android.util.AttributeSet;

public class SingleChoiceAnswerItem extends BaseAnswerItemView {
    public SingleChoiceAnswerItem(Context paramContext) {
        super(paramContext);
    }

    public SingleChoiceAnswerItem(Context paramContext, AttributeSet paramAttributeSet) {
        super(paramContext, paramAttributeSet);
    }

    public SingleChoiceAnswerItem(Context paramContext, boolean paramBoolean) {
        super(paramContext, paramBoolean);
    }

    public SingleChoiceAnswerItem(Context paramContext, boolean paramBoolean1, int paramInt, boolean paramBoolean2) {
        super(paramContext, paramBoolean1, paramInt, paramBoolean2);
    }

    public SingleChoiceAnswerItem(Context paramContext, boolean paramBoolean1, int paramInt, boolean paramBoolean2, String paramString) {
        super(paramContext, paramBoolean1, paramInt, paramBoolean2, paramString);
    }

    @TypeAnswer
    public int getTypeAnswer() {
        return BaseAnswerItemView.SINGLE;
    }

    void onAnswerClick(BaseAnswerItemView paramBaseAnswerItemView, int paramInt, boolean paramBoolean) {
        checkAnswer();
        hideAllDivider();
        this.answerItemListener.onItemAnswerClick(this, getIndex(), iCorrect());
    }
}