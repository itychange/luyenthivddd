package com.lthdl.app.screen.questions.view;

import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.LayoutInflater;

import com.lthdl.app.R;
import com.lthdl.app.common.widget.textview.CEditText;
import com.lthdl.app.common.widget.textview.RichTextView;

import butterknife.Bind;
import butterknife.ButterKnife;

public class TextInPlaceLayout extends QuestionLayout {
    String answer;

    @Bind(R.id.edtAnswer)
    CEditText edtAnswer;
    String question;
    TextPlaceLayoutListener textPlaceLayoutListener = new TextPlaceLayoutListener() {
        public void onAnswerFilled(String paramString) {
        }

        public void onCompleteAnswer(boolean paramBoolean, int paramInt) {
        }
    };

    @Bind(R.id.tvQuestion)
    RichTextView tvQuestion;

    public TextInPlaceLayout(Context paramContext) {
        super(paramContext);
        init();
    }

    public TextInPlaceLayout(Context paramContext, AttributeSet paramAttributeSet) {
        super(paramContext, paramAttributeSet);
        init();
    }

    public TextInPlaceLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
        super(paramContext, paramAttributeSet, paramInt);
        init();
    }

    public boolean chekcAnswer() {
        boolean bool = this.edtAnswer.getText().toString().toLowerCase().trim().equals(this.answer.toLowerCase().trim());
        this.textPlaceLayoutListener.onCompleteAnswer(bool, 1);
        return bool;
    }

    public String getAnswer() {
        return this.answer;
    }

    public String getQuestion() {
        return this.question;
    }

    protected void init() {
        ButterKnife.bind(LayoutInflater.from(getContext()).inflate(R.layout.question_textinplace_layout, this, true));
        this.edtAnswer.addTextChangedListener(new TextWatcher() {
            public void afterTextChanged(Editable paramEditable) {
            }

            public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {
            }

            public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {
                TextInPlaceLayout.this.textPlaceLayoutListener.onAnswerFilled(paramCharSequence.toString());
            }
        });
    }

    public void initData() {
        this.tvQuestion.setText(this.question);
    }

    public void setAnswer(String paramString) {
        initData();
        this.answer = paramString;
    }

    public void setQuestion(String paramString) {
        this.question = paramString;
        initData();
    }

    public void setTextPlaceLayoutListener(TextPlaceLayoutListener paramTextPlaceLayoutListener) {
        this.textPlaceLayoutListener = paramTextPlaceLayoutListener;
    }

    public static abstract interface TextPlaceLayoutListener {
        public abstract void onAnswerFilled(String paramString);

        public abstract void onCompleteAnswer(boolean paramBoolean, int paramInt);
    }
}