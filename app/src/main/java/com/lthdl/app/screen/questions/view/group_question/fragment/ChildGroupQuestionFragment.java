package com.lthdl.app.screen.questions.view.group_question.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.lthdl.app.BaseFragment;
import com.lthdl.app.R;
import com.lthdl.app.global.Constant;
import com.lthdl.app.screen.questions.view.BaseAnswerBottomView;
import com.lthdl.app.screen.questions.view.BaseAnswerBottomView.BaseAnswerListener;
import com.lthdl.app.screen.questions.view.MultiChoiceAnswerView;
import com.lthdl.app.screen.questions.view.SingleChoiceAnswerView;
import com.lthdl.app.screen.questions.view.group_question.event.OnEventChildQuestionComplete;

import org.greenrobot.eventbus.EventBus;

import butterknife.Bind;

public class ChildGroupQuestionFragment extends BaseFragment {
    public static final String CLASS_NAME = " ChildGroupQuestionFragment ";
    public static final String PARAM_DATA = "data";
    public static final String PARAM_TYPE_ANSWER = "type_answer";
    public static final int TYPE_MULTI = 1;
    public static final int TYPE_SINGLE = 0;

    @Bind(R.id.lyAnswerContent)
    LinearLayout lyAnswerContent;
    int typeAnswer;

    public static ChildGroupQuestionFragment newInstance(int paramInt, String paramString) {
        ChildGroupQuestionFragment localChildGroupQuestionFragment = new ChildGroupQuestionFragment();
        Bundle localBundle = new Bundle();
        localBundle.putInt(PARAM_TYPE_ANSWER, paramInt);
        Log.e(Constant.TAG, CLASS_NAME + "newInstance()->[paramInt]==" + paramInt);
        localBundle.putString(PARAM_DATA, paramString);
        localChildGroupQuestionFragment.setArguments(localBundle);
        return localChildGroupQuestionFragment;
    }

    protected void init(View paramView) {
        Log.e(Constant.TAG, CLASS_NAME + " init()->start");
        if (this.typeAnswer == TYPE_SINGLE) {
            Log.e(Constant.TAG, CLASS_NAME + " init()->start single");
            SingleChoiceAnswerView singleChoiceAnswerView = new SingleChoiceAnswerView(getActivity());
            singleChoiceAnswerView.setIsShowQuestion(true);
            singleChoiceAnswerView.setAnswerItemCount(4);
            singleChoiceAnswerView.setData(2);
            singleChoiceAnswerView.setBaseAnswerListener(new BaseAnswerListener() {
                public void onCompleteAnswer(boolean paramBoolean, int paramInt) {
                    Log.e(Constant.TAG, CLASS_NAME + " init()->onCompleteAnswer single [paramInt]==" + paramInt);
                    OnEventChildQuestionComplete localOnEventChildQuestionComplete = new OnEventChildQuestionComplete();
                    EventBus.getDefault().post(localOnEventChildQuestionComplete);
                }

                public void onItemAnswerClick(View paramView, int paramInt, boolean paramBoolean) {
                }
            });
            this.lyAnswerContent.addView(singleChoiceAnswerView);
            Log.e(Constant.TAG, CLASS_NAME + " init()->end single");
            return;
        }
        Log.e(Constant.TAG, CLASS_NAME + " init()->start multil");
        MultiChoiceAnswerView multiChoiceAnswerView = new MultiChoiceAnswerView(getActivity());
        multiChoiceAnswerView.setIsShowQuestion(true);
        multiChoiceAnswerView.setCorrectIndexAnswer(new int[]{0, 1, 3});
        multiChoiceAnswerView.setAnswerItemCount(5);
        multiChoiceAnswerView.setData();
        multiChoiceAnswerView.setBaseAnswerListener(new BaseAnswerBottomView.BaseAnswerListener() {
            public void onCompleteAnswer(boolean paramBoolean, int paramInt) {
                Log.e(Constant.TAG, CLASS_NAME + " init()->onCompleteAnswer multi [paramInt]==" + paramInt);
                OnEventChildQuestionComplete localOnEventChildQuestionComplete = new OnEventChildQuestionComplete();
                EventBus.getDefault().post(localOnEventChildQuestionComplete);
            }

            public void onItemAnswerClick(View paramView, int paramInt, boolean paramBoolean) {
            }
        });
        this.lyAnswerContent.addView(multiChoiceAnswerView);
        Log.e(Constant.TAG, CLASS_NAME + " init()->end multi");
    }

    public void onCreate(Bundle paramBundle) {
        super.onCreate(paramBundle);
        Log.e(Constant.TAG, CLASS_NAME + "onCreate()->start");
        this.typeAnswer = getArguments().getInt(PARAM_TYPE_ANSWER, 0);
        Log.e(Constant.TAG, CLASS_NAME + "onCreate()->end. [typeAnswer]=="+ typeAnswer);
    }

    @Nullable
    public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle) {
        return LayoutInflater.from(paramViewGroup.getContext()).inflate(R.layout.child_group_question_fragment, paramViewGroup, false);
    }
}