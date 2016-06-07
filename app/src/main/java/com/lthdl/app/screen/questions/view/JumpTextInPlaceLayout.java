package com.lthdl.app.screen.questions.view;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.LayoutTransition;
import android.content.Context;
import android.graphics.Point;
import android.support.design.widget.Snackbar;
import android.support.v4.view.animation.LinearOutSlowInInterpolator;
import android.text.Editable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;

import com.lthdl.app.R;
import com.lthdl.app.common.DimenUtils;
import com.lthdl.app.common.StringUtils;
import com.lthdl.app.common.widget.flowlayout.FlowLayout;
import com.lthdl.app.common.widget.textview.ResourceTagHandler.OnClickableListener;
import com.lthdl.app.common.widget.textview.RichTextView;
import com.lthdl.app.global.Constant;
import com.lthdl.app.screen.questions.event.OnEventOneQuestionComplete;

import org.greenrobot.eventbus.EventBus;

import java.util.HashMap;

public class JumpTextInPlaceLayout extends QuestionLayout
        implements OnClickableListener, OnClickListener {
    public static final String CLASS_NAME = " JumpTextInPlaceLayout ";
    FlowLayout flowAnswer;
    String html;
    TextView tvAnswer01;
    TextView tvAnswer02;
    TextView tvAnswer03;
    TextView tvAnswer04;
    TextView tvAnswer05;
    TextView tvAnswer06;
    TextView tvAnswer07;
    TextView tvAnswer08;
    TextView tvAnswerAnim;
    RichTextView tvQuestionContent;
    private int iQuestionNumber = 0;

    public JumpTextInPlaceLayout(Context paramContext) {
        super(paramContext);
        init();
    }

    public JumpTextInPlaceLayout(Context paramContext, AttributeSet paramAttributeSet) {
        super(paramContext, paramAttributeSet);
        init();
    }

    public JumpTextInPlaceLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
        super(paramContext, paramAttributeSet, paramInt);
        init();
    }

    protected void init() {
        Log.e(Constant.TAG, CLASS_NAME + " init()");
        LayoutInflater.from(getContext()).inflate(R.layout.question_jumptextinplace_layout, this, true);
        this.tvQuestionContent = ((RichTextView) findViewById(R.id.tvQuestionContent));
        this.flowAnswer = ((FlowLayout) findViewById(R.id.flowAnswer));
        this.tvAnswerAnim = ((TextView) findViewById(R.id.tvAnswerAnim));
        this.tvAnswer01 = ((TextView) findViewById(R.id.tvAnswer01));
        this.tvAnswer02 = ((TextView) findViewById(R.id.tvAnswer02));
        this.tvAnswer03 = ((TextView) findViewById(R.id.tvAnswer03));
        this.tvAnswer04 = ((TextView) findViewById(R.id.tvAnswer04));
        this.tvAnswer05 = ((TextView) findViewById(R.id.tvAnswer05));
        this.tvAnswer06 = ((TextView) findViewById(R.id.tvAnswer06));
        this.tvAnswer07 = ((TextView) findViewById(R.id.tvAnswer07));
        this.tvAnswer08 = ((TextView) findViewById(R.id.tvAnswer08));
        this.tvAnswer01.setOnClickListener(this);
        this.tvAnswer02.setOnClickListener(this);
        this.tvAnswer03.setOnClickListener(this);
        this.tvAnswer04.setOnClickListener(this);
        this.tvAnswer05.setOnClickListener(this);
        this.tvAnswer06.setOnClickListener(this);
        this.tvAnswer07.setOnClickListener(this);
        this.tvAnswer08.setOnClickListener(this);
        this.tvQuestionContent.setOnClickableListener(this);
        this.html = StringUtils.getStringFromResouce(getContext(), R.string.question_jumptextinplace_content);
        this.tvQuestionContent.setRichText(this.html);
        this.flowAnswer.setLayoutTransition(new LayoutTransition());
        Log.e(Constant.TAG, CLASS_NAME + " init()->end");
    }

    public void onClick(View paramView) {
        Log.e(Constant.TAG, CLASS_NAME + " onClick()->start");
        if ((paramView instanceof TextView)) {
            TextView localTextView = (TextView) paramView;
            Object localObject = this.html.replaceFirst("\\.\\.\\.\\.\\.", localTextView.getText().toString());
            if (!((String) localObject).equalsIgnoreCase(this.html)) {
                iQuestionNumber++;
                this.html = ((String) localObject);
                localObject = this.tvQuestionContent.getFirstPosThreeDot();
                int[] arrayOfInt = new int[2];
                paramView.getLocationOnScreen(arrayOfInt);
                this.tvAnswerAnim.setX(arrayOfInt[0] - this.tvAnswerAnim.getWidth() / 2);
                this.tvAnswerAnim.setY(arrayOfInt[1] - this.tvAnswerAnim.getHeight() / 2);
                this.tvAnswerAnim.setText(localTextView.getText());
                this.tvAnswerAnim.setVisibility(View.VISIBLE);
                this.flowAnswer.removeView(paramView);
                this.tvAnswerAnim.animate().x(((Point) localObject).x - this.tvAnswerAnim.getWidth() / 2).y(((Point) localObject).y - this.tvAnswerAnim.getHeight() / 2).setDuration(200).setInterpolator(new LinearOutSlowInInterpolator()).setListener(new AnimatorListener() {
                    public void onAnimationCancel(Animator paramAnimator) {
                    }

                    public void onAnimationEnd(Animator paramAnimator) {
                        JumpTextInPlaceLayout.this.tvAnswerAnim.setVisibility(View.GONE);
                        JumpTextInPlaceLayout.this.tvQuestionContent.setRichText(JumpTextInPlaceLayout.this.html);
                    }

                    public void onAnimationRepeat(Animator paramAnimator) {
                    }

                    public void onAnimationStart(Animator paramAnimator) {
                    }
                }).start();
            }
        } else {
            return;
        }
        if (iQuestionNumber > 6) {
            Snackbar.make(paramView, "Out of range", Snackbar.LENGTH_SHORT).show();
        }
        if (iQuestionNumber == 6) {
            iQuestionNumber++;
            EventBus.getDefault().post(new OnEventOneQuestionComplete().setCorrect(true));
        }
    }

    public void onTagClick(String paramString, Editable paramEditable, Integer paramInteger, HashMap<String, String> paramHashMap) {
        Log.e(Constant.TAG, CLASS_NAME + " onTagClick()->start");
        String strEditable = paramHashMap.get("data");
        String strInteger = String.format("<lt_clickable data=%s>%s</lt_clickable>", new Object[]{paramEditable, paramString});
        String strHashMap = String.format("<lt_clickable data=%s>.....</lt_clickable>", new Object[]{paramEditable});
        strInteger = this.html.replaceFirst(strInteger, strHashMap);
        if ((!strInteger.equalsIgnoreCase(this.html)) && (strEditable.contains("answer:"))) {
            this.html = strInteger;
            this.tvQuestionContent.setRichText(this.html);
            TextView localTextView = (TextView) LayoutInflater.from(getContext()).inflate(R.layout.question_jumptextinplace_item_tag, null, false);
            localTextView.setText(paramString);
            localTextView.setOnClickListener(this);
            this.flowAnswer.addView(localTextView);
            ((FlowLayout.LayoutParams) localTextView.getLayoutParams()).width = -2;
            ((FlowLayout.LayoutParams) localTextView.getLayoutParams()).height = -2;
            ((FlowLayout.LayoutParams) localTextView.getLayoutParams()).bottomMargin = DimenUtils.dpToPx(getContext(), 5);
            ((FlowLayout.LayoutParams) localTextView.getLayoutParams()).rightMargin = DimenUtils.dpToPx(getContext(), 5);
        }
    }
}