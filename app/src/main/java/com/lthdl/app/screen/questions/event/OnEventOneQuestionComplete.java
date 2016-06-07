package com.lthdl.app.screen.questions.event;

public class OnEventOneQuestionComplete {
    public boolean isCorrect;
    public float score;
    public boolean isShowNextQuestion;

    public OnEventOneQuestionComplete() {
        isShowNextQuestion = true;
    }
//    public OnEventOneQuestionComplete(boolean bShowNextQuestion) {
//        isShowNextQuestion = bShowNextQuestion;
//    }

    public OnEventOneQuestionComplete setCorrect(boolean paramBoolean) {
        this.isCorrect = paramBoolean;
        return this;
    }

    public OnEventOneQuestionComplete setShowNextQuestion(boolean paramBoolean) {
        this.isShowNextQuestion = paramBoolean;
        return this;
    }
}