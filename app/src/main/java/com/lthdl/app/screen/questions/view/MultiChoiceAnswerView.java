package com.lthdl.app.screen.questions.view;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

import com.lthdl.app.global.Constant;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class MultiChoiceAnswerView extends BaseAnswerBottomView {
    public static final String CLASS_NAME = " MultiChoiceAnswerView ";
    List<MultiChoiceAnswerItem> allAnswerList = new ArrayList();
    List<MultiChoiceAnswerItem> correctAnswerList = new ArrayList();
    int[] correctIndexAnswer = {0, 1, 3};
    Set<MultiChoiceAnswerItem> selectedAnswerList = new HashSet();

    public MultiChoiceAnswerView(Context paramContext) {
        super(paramContext);
    }

    public MultiChoiceAnswerView(Context paramContext, AttributeSet paramAttributeSet) {
        super(paramContext, paramAttributeSet);
    }

    public MultiChoiceAnswerView(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
        super(paramContext, paramAttributeSet, paramInt);
    }

    private boolean isCorrectAnswer(int paramInt) {
        Log.e(Constant.TAG, CLASS_NAME + " setData()->start");
        int i = 0;
        while (i < getCorrectIndexAnswer().length) {
            Log.e(Constant.TAG, CLASS_NAME + " setData()->[loop] i=="+i);
            if (getCorrectIndexAnswer()[i] == paramInt)
                return true;
            i += 1;
        }
        return false;
    }

    void afterInit() {
    }

    public int[] getCorrectIndexAnswer() {
        return this.correctIndexAnswer;
    }

    public void setCorrectIndexAnswer(int[] paramArrayOfInt) {
        this.correctIndexAnswer = paramArrayOfInt;
    }

    public void setData() {
        Log.e(Constant.TAG, CLASS_NAME + " setData()->start ");
        int i = 0;
        while (i < getAnswerItemCount()) {
            Log.e(Constant.TAG, CLASS_NAME + " setData()->[loop]i == "+i);
            boolean bool = isCorrectAnswer(i);
            MultiChoiceAnswerItem localMultiChoiceAnswerItem = new MultiChoiceAnswerItem(getContext(), isCorrectAnswer(i), i, isShowQuestion());
            localMultiChoiceAnswerItem.setAnswerItemListener(new BaseAnswerItemView.AnswerItemListener() {
                public void onItemAnswerClick(View paramView, int paramInt, boolean paramBoolean) {
                    MultiChoiceAnswerView.this.selectedAnswerList.add((MultiChoiceAnswerItem) paramView);
                    if (MultiChoiceAnswerView.this.selectedAnswerList.size() == MultiChoiceAnswerView.this.getCorrectIndexAnswer().length) {
                        Iterator iterator = MultiChoiceAnswerView.this.allAnswerList.iterator();
                        while (iterator.hasNext()) {
                            MultiChoiceAnswerItem localMultiChoiceAnswerItem = (MultiChoiceAnswerItem) iterator.next();
                            localMultiChoiceAnswerItem.hideAllDivider();
                            localMultiChoiceAnswerItem.setClickable(false);
                        }
                        iterator = MultiChoiceAnswerView.this.selectedAnswerList.iterator();
                        while (iterator.hasNext())
                            ((MultiChoiceAnswerItem) iterator.next()).checkAnswer();
                        iterator = MultiChoiceAnswerView.this.correctAnswerList.iterator();
                        while (iterator.hasNext())
                            ((MultiChoiceAnswerItem) iterator.next()).checkAnswer();
                        if (MultiChoiceAnswerView.this.selectedAnswerList.containsAll(MultiChoiceAnswerView.this.correctAnswerList))
                            MultiChoiceAnswerView.this.baseAnswerListener.onCompleteAnswer(true, 0);
                    } else {
                        return;
                    }
                    MultiChoiceAnswerView.this.baseAnswerListener.onCompleteAnswer(true, 0);
                }
            });
            if (bool)
                this.correctAnswerList.add(localMultiChoiceAnswerItem);
            this.allAnswerList.add(localMultiChoiceAnswerItem);
            this.lyListAnswerContent.addView(localMultiChoiceAnswerItem);
            i += 1;
        }
        Log.e(Constant.TAG, CLASS_NAME + " setData()->end ");
    }

    public void setVisibility(int paramInt) {
    }
}