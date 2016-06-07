package com.lthdl.app.screen.questions.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;

import com.lthdl.app.R;

public class MultiChoiceAnswerItem extends BaseAnswerItemView {
    public MultiChoiceAnswerItem(Context paramContext) {
        super(paramContext);
    }

    public MultiChoiceAnswerItem(Context paramContext, AttributeSet paramAttributeSet) {
        super(paramContext, paramAttributeSet);
    }

    public MultiChoiceAnswerItem(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
        super(paramContext, paramAttributeSet, paramInt);
    }

    public MultiChoiceAnswerItem(Context paramContext, boolean paramBoolean) {
        super(paramContext, paramBoolean);
    }

    public MultiChoiceAnswerItem(Context paramContext, boolean paramBoolean1, int paramInt, boolean paramBoolean2) {
        super(paramContext, paramBoolean1, paramInt, paramBoolean2);
    }

    public MultiChoiceAnswerItem(Context paramContext, boolean paramBoolean1, int paramInt, boolean paramBoolean2, String paramString) {
        super(paramContext, paramBoolean1, paramInt, paramBoolean2, paramString);
    }

    @TypeAnswer
    public int getTypeAnswer() {
        return BaseAnswerItemView.MULTI;
    }

    void onAnswerClick(BaseAnswerItemView paramBaseAnswerItemView, int paramInt, boolean paramBoolean) {
        setStatusSelect();
    }

    public void setStatusSelect() {
        this.lyBoundAnswer.setBackgroundColor(getContext().getResources().getColor(R.color.yellow));
        this.imvCorrect.setVisibility(View.GONE);
        this.imvIncorrect.setVisibility(View.GONE);
    }
}