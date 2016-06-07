package com.lthdl.app.screen.questions.view;

import android.animation.LayoutTransition;
import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;

import com.lthdl.app.R;
import com.lthdl.app.common.DimenUtils;
import com.lthdl.app.common.widget.flowlayout.FlowLayout;
import com.lthdl.app.common.widget.flowlayout.MultiLineFlowLayout;
import com.lthdl.app.common.widget.textview.RichTextView;
import com.lthdl.app.common.widget.textview.TextViewTag;
import com.lthdl.app.global.Constant;
import com.lthdl.app.screen.questions.event.OnEventOneQuestionComplete;

import org.greenrobot.eventbus.EventBus;

import java.util.ArrayList;
import java.util.Iterator;

import butterknife.Bind;
import butterknife.ButterKnife;

public class JumpOrderAnswerLayout extends QuestionLayout
        implements OnClickListener {
    public static final String CLASS_NAME = " JumpOrderAnswerLayout ";
    public static boolean m_bNextQuestionShown;
    @Bind(R.id.flowAnswer)
    MultiLineFlowLayout flowAnswer;

    @Bind(R.id.flowTag)
    FlowLayout flowTag;
    private final int largeMargin = 8;
    private ArrayList<TextViewTag> tags = new ArrayList();

    @Bind(R.id.tvContent)
    RichTextView tvContent;

    public JumpOrderAnswerLayout(Context paramContext) {
        super(paramContext);
        init();
    }

    public JumpOrderAnswerLayout(Context paramContext, AttributeSet paramAttributeSet) {
        super(paramContext, paramAttributeSet);
        init();
    }

    public JumpOrderAnswerLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
        super(paramContext, paramAttributeSet, paramInt);
        init();
    }

    private void addSampleData() {
        TextViewTag localTextViewTag1 = new TextViewTag(getContext());
        TextViewTag localTextViewTag2 = new TextViewTag(getContext());
        TextViewTag localTextViewTag3 = new TextViewTag(getContext());
        TextViewTag localTextViewTag4 = new TextViewTag(getContext());
        localTextViewTag1.setText("+ adj/adv").setTag(0);
        localTextViewTag2.setText("+ too").setTag(1/*Integer.valueOf(1)*/);
        localTextViewTag3.setText("+ (for someone)").setTag(2);
        localTextViewTag4.setText("+ to do something").setTag(3);
        addAnswer(localTextViewTag1);
        addAnswer(localTextViewTag2);
        addAnswer(localTextViewTag3);
        addAnswer(localTextViewTag4);
    }

    private void addTagView(FlowLayout paramFlowLayout, TextViewTag paramTextViewTag, int paramInt1, int paramInt2) {
        Log.e(Constant.TAG, CLASS_NAME + " addTagView()->start: [paramInt1]==" + paramInt1 + " [paramInt2]==" + paramInt2);
        paramTextViewTag.setOnClickListener(this);
        FlowLayout.LayoutParams params = new FlowLayout.LayoutParams(-2, -2);
        params.rightMargin = DimenUtils.dpToPx(getContext(), paramInt2);
        paramTextViewTag.setLayoutParams(params);
        this.tags.add(paramTextViewTag);
        paramFlowLayout.addView(paramTextViewTag, Math.min(paramInt1, paramFlowLayout.getChildCount()));
    }

    public void addAnswer(TextViewTag paramTextViewTag) {
        addTagView(this.flowTag, paramTextViewTag, -1, largeMargin);
    }

    protected void init() {
        LayoutInflater.from(getContext()).inflate(R.layout.question_jumporderanswer_layout, this, true);
        ButterKnife.bind(this);
        this.flowTag.removeAllViews();
        this.flowAnswer.removeAllViews();
        this.flowAnswer.setLayoutTransition(new LayoutTransition());
        this.flowTag.setLayoutTransition(new LayoutTransition());
        addSampleData();
    }

    public void onClick(View paramView) {
        Log.e(Constant.TAG, CLASS_NAME + " onClick()->start");
        TextViewTag localTextViewTag1 = (TextViewTag) paramView;
        if (((ViewGroup) paramView.getParent()).getId() == this.flowTag.getId() && localTextViewTag1.isVisible()) {
            localTextViewTag1.setVisible(false);
            TextViewTag localTextViewTag = new TextViewTag(getContext());
            localTextViewTag.setText(localTextViewTag1.getText()).setTag(localTextViewTag1.getTag());
            addTagView(this.flowAnswer, localTextViewTag, -1, largeMargin);
        }
        if (((ViewGroup) paramView.getParent()).getId() == this.flowAnswer.getId()) {
            this.flowAnswer.removeView(localTextViewTag1);
            Iterator iterator = this.tags.iterator();
            while (iterator.hasNext()) {
                TextViewTag localTextViewTag2 = (TextViewTag) iterator.next();
                if (!localTextViewTag2.getText().equalsIgnoreCase(localTextViewTag1.getText()))
                    continue;
                localTextViewTag2.setVisible(true);
            }
        }
        OnEventOneQuestionComplete onEventOneQuestionComplete = new OnEventOneQuestionComplete();
        if (this.flowAnswer.getChildCount() == 4) {
            m_bNextQuestionShown = true;
            EventBus.getDefault().post(onEventOneQuestionComplete.setShowNextQuestion(true).setCorrect(true));
        } else {
            if (m_bNextQuestionShown) {
                EventBus.getDefault().post(onEventOneQuestionComplete.setShowNextQuestion(false));
            }
            m_bNextQuestionShown = false;
        }
    }
}