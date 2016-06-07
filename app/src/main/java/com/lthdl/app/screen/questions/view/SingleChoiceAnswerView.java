package com.lthdl.app.screen.questions.view;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

import com.lthdl.app.global.Constant;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class SingleChoiceAnswerView extends BaseAnswerBottomView {

    public static final String CLASS_NAME = " SingleChoiceAnswerView ";
    SingleChoiceAnswerItem singleChoiceAnswerItemCorrect = null;
    List<SingleChoiceAnswerItem> singleChoiceAnswerItems = new ArrayList();
    BaseAnswerBottomView.BaseAnswerListener singleChoiceAnswerListener = new BaseAnswerBottomView.BaseAnswerListener() {
        public void onCompleteAnswer(boolean paramBoolean, int paramInt) {
        }

        public void onItemAnswerClick(View paramView, int paramInt, boolean paramBoolean) {
        }
    };

    public SingleChoiceAnswerView(Context paramContext) {
        super(paramContext);
    }

    public SingleChoiceAnswerView(Context paramContext, AttributeSet paramAttributeSet) {
        super(paramContext, paramAttributeSet);
    }

    public SingleChoiceAnswerView(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
        super(paramContext, paramAttributeSet, paramInt);
    }

    void afterInit() {
    }

    public BaseAnswerBottomView.BaseAnswerListener getSingleChoiceAnswerListener() {
        return this.singleChoiceAnswerListener;
    }

    public void setData(int paramInt) {
        Log.e(Constant.TAG, CLASS_NAME + " setData() start ");
        int i = 0;
        Log.e(Constant.TAG, CLASS_NAME + " setData() getAnswerItemCount() == " + getAnswerItemCount());
        for (i = 0; i < getAnswerItemCount(); i++) {
            Log.e(Constant.TAG, CLASS_NAME + " setData() i == " + i);
            final SingleChoiceAnswerItem localSingleChoiceAnswerItem = new SingleChoiceAnswerItem(getContext());
            localSingleChoiceAnswerItem.setIndex(i);
            localSingleChoiceAnswerItem.setIsShowQuestion(isShowQuestion());
            localSingleChoiceAnswerItem.setAnswerItemListener(new BaseAnswerItemView.AnswerItemListener() {
                public void onItemAnswerClick(View paramView, int paramInt, boolean paramBoolean) {
                    SingleChoiceAnswerView.this.singleChoiceAnswerItemCorrect.checkAnswer();
                    Iterator iterator = SingleChoiceAnswerView.this.singleChoiceAnswerItems.iterator();
                    while (iterator.hasNext()) {
                        SingleChoiceAnswerItem localSingleChoiceAnswerItem1 = (SingleChoiceAnswerItem) iterator.next();
                        localSingleChoiceAnswerItem1.setClickable(false);
                        localSingleChoiceAnswerItem1.hideAllDivider();
                    }
                    if (localSingleChoiceAnswerItem.getIndex() == paramInt) {
                        SingleChoiceAnswerView.this.baseAnswerListener.onCompleteAnswer(true, 1);
                        Log.e(Constant.TAG, CLASS_NAME + " setData() paramInt == " + paramInt);
                        return;
                    }
                    SingleChoiceAnswerView.this.baseAnswerListener.onCompleteAnswer(false, 0);
                }
            });
            localSingleChoiceAnswerItem.setIcon(i);
            this.lyListAnswerContent.addView(localSingleChoiceAnswerItem);
            this.singleChoiceAnswerItems.add(localSingleChoiceAnswerItem);
            if (i == paramInt) {
                localSingleChoiceAnswerItem.setIsCorrect(true);
                this.singleChoiceAnswerItemCorrect = localSingleChoiceAnswerItem;
            } else {
                localSingleChoiceAnswerItem.setIsCorrect(false);
            }
        }
        Log.e(Constant.TAG, CLASS_NAME + " setData() end ");
    }

    public void setSingleChoiceAnswerListener(BaseAnswerBottomView.BaseAnswerListener paramBaseAnswerListener) {
        this.singleChoiceAnswerListener = paramBaseAnswerListener;
    }
}