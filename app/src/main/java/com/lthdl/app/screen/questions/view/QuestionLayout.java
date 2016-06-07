package com.lthdl.app.screen.questions.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;

public abstract class QuestionLayout extends FrameLayout {
    public QuestionLayout(Context paramContext) {
        super(paramContext);
    }

    public QuestionLayout(Context paramContext, AttributeSet paramAttributeSet) {
        super(paramContext, paramAttributeSet);
    }

    public QuestionLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
        super(paramContext, paramAttributeSet, paramInt);
    }

    protected abstract void init();
}