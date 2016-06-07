package com.lthdl.app.screen.questions.view;

import android.content.Context;
import android.support.annotation.IntDef;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.lthdl.app.R;
import com.lthdl.app.common.widget.textview.CTextView;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import butterknife.Bind;
import butterknife.ButterKnife;

public abstract class BaseAnswerItemView extends FrameLayout {

    public static final int SINGLE = 0;
    public static final int MULTI = 1;

    @IntDef({SINGLE, MULTI})
    @Retention(RetentionPolicy.SOURCE)
    public @interface TypeAnswer {
    }

    @TypeAnswer
    int currentTypeAnswer = SINGLE;

    AnswerItemListener answerItemListener = new AnswerItemListener() {
        public void onItemAnswerClick(View paramView, int paramInt, boolean paramBoolean) {
        }
    };

    @Bind(R.id.dividerLong)
    View dividerLong;

    @Bind(R.id.dividerShort)
    View dividerShort;

    @Bind(R.id.imvCorrect)
    ImageView imvCorrect;

    @Bind(R.id.imvIncorrect)
    ImageView imvIncorrect;
    int index;
    boolean isCorrect;
    private boolean isShowQuestion;

    @Bind(R.id.lyAnswerContent)
    LinearLayout lyAnswerContent;

    @Bind(R.id.lyBoundAnswer)
    FrameLayout lyBoundAnswer;

    @Bind(R.id.tvAnswerContent)
    TextView tvAnswerContent;

    @Bind(R.id.tvIcon)
    CTextView tvIcon;

    public BaseAnswerItemView(Context paramContext) {
        super(paramContext);
        init();
    }

    public BaseAnswerItemView(Context paramContext, AttributeSet paramAttributeSet) {
        super(paramContext, paramAttributeSet);
        init();
    }

    public BaseAnswerItemView(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
        super(paramContext, paramAttributeSet, paramInt);
        init();
    }

    public BaseAnswerItemView(Context paramContext, boolean paramBoolean) {
        super(paramContext);
        init();
        this.isCorrect = paramBoolean;
    }

    public BaseAnswerItemView(Context paramContext, boolean paramBoolean1, int paramInt, boolean paramBoolean2) {
        super(paramContext);
        init();
        setIsCorrect(paramBoolean1);
        setIndex(paramInt);
        setIcon(paramInt);
        setIsShowQuestion(paramBoolean2);
    }

    public BaseAnswerItemView(Context paramContext, boolean paramBoolean1, int paramInt, boolean paramBoolean2, String paramString) {
        super(paramContext);
        init();
        setIsCorrect(paramBoolean1);
        setIndex(paramInt);
        setIcon(paramInt);
        setIsShowQuestion(paramBoolean2);
        setAnswer(paramString);
    }

    private void init() {
        LayoutInflater.from(getContext()).inflate(R.layout.view_answer_item, this, true);
        ButterKnife.bind(this);
        setStatusNormal();
        this.lyAnswerContent.setOnClickListener(new OnClickListener() {
            public void onClick(View paramView) {
                BaseAnswerItemView.this.onAnswerClick(BaseAnswerItemView.this, BaseAnswerItemView.this.getIndex(), BaseAnswerItemView.this.isCorrect);
                BaseAnswerItemView.this.answerItemListener.onItemAnswerClick(BaseAnswerItemView.this, BaseAnswerItemView.this.getIndex(), BaseAnswerItemView.this.isCorrect);
            }
        });
        if (getTypeAnswer() == SINGLE) {
            this.tvIcon.setBackgroundResource(R.drawable.xml_singlechoise_answer_bg);
            return;
        }
        if (getTypeAnswer() == MULTI) {
            this.tvIcon.setBackgroundResource(R.drawable.xml_multichoice_answer_bg);
            return;
        }
        this.tvIcon.setBackgroundResource(R.drawable.xml_singlechoise_answer_bg);
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

    public void hideAllDivider() {
        this.dividerLong.setVisibility(View.GONE);
        this.dividerShort.setVisibility(View.GONE);
    }

    public boolean iCorrect() {
        return this.isCorrect;
    }

    public void initData(boolean paramBoolean1, int paramInt, boolean paramBoolean2, String paramString) {
        setIsCorrect(paramBoolean1);
        setIndex(paramInt);
        setIcon(paramInt);
        setIsShowQuestion(paramBoolean2);
        setAnswer(paramString);
    }

    public boolean isShowQuestion() {
        return this.isShowQuestion;
    }

    abstract void onAnswerClick(BaseAnswerItemView paramBaseAnswerItemView, int paramInt, boolean paramBoolean);

    public void setAnswer(String paramString) {
        this.tvAnswerContent.setText(paramString);
    }

    public void setAnswerItemListener(AnswerItemListener paramAnswerItemListener) {
        this.answerItemListener = paramAnswerItemListener;
    }

    public void setClickable(boolean paramBoolean) {
        this.lyAnswerContent.setClickable(false);
        this.lyAnswerContent.setEnabled(false);
    }

    public void setIcon(int paramInt) {
        switch (paramInt) {
            default:
                return;
            case 0:
                this.tvIcon.setText("A");
                if (!isShowQuestion()) {
                    hideAllDivider();
                    return;
                }
                showLongDivider();
                return;
            case 1:
                showShortDivider();
                this.tvIcon.setText("B"/*ICON.B.toString()*/);
                return;
            case 2:
                showShortDivider();
                this.tvIcon.setText("C");
                return;
            case 3:
                showShortDivider();
                this.tvIcon.setText("D");
                return;
            case 4:
        }
        showShortDivider();
        this.tvIcon.setText("E");
    }

    public void setIndex(int paramInt) {
        this.index = paramInt;
    }

    public void setIsCorrect(boolean paramBoolean) {
        this.isCorrect = paramBoolean;
    }

    public void setIsShowQuestion(boolean paramBoolean) {
        this.isShowQuestion = paramBoolean;
        setIcon(getIndex());
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
        this.lyBoundAnswer.setBackgroundColor(getContext().getResources().getColor(R.color.transparent));
        this.tvAnswerContent.setTextColor(getContext().getResources().getColor(R.color.blackAnswer));
        this.imvCorrect.setVisibility(View.GONE);
        this.imvIncorrect.setVisibility(View.GONE);
    }

    public void showLongDivider() {
        this.dividerLong.setVisibility(View.VISIBLE);
        this.dividerShort.setVisibility(View.GONE);
    }

    public void showShortDivider() {
        this.dividerLong.setVisibility(View.GONE);
        this.dividerShort.setVisibility(View.VISIBLE);
    }

    public static abstract interface AnswerItemListener {
        public abstract void onItemAnswerClick(View paramView, int paramInt, boolean paramBoolean);
    }

    public void setTypeAnswer(@TypeAnswer int currentTab) {
        this.currentTypeAnswer = currentTab;
    }

    @TypeAnswer
    public int getTypeAnswer() {
        return currentTypeAnswer;
    }
}