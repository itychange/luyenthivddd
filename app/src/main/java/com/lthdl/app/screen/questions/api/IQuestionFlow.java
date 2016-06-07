package com.lthdl.app.screen.questions.api;

import android.os.Bundle;

public abstract interface IQuestionFlow {
    public static final int GROUP_QUESTION = 7;
    public static final int JUMP_ORDER_ANSWER = 6;
    public static final int JUMP_TEXT_IN_PLACE = 5;
    public static final int MULTI_CHOICE = 2;
    public static final int ORDER_ANSWER = 3;
    public static final int SINGLE_CHOICE = 1;
    public static final int TEXT_IN_PLACE = 4;
    public static final int TEXT_SINGLE_CHOICE = 0;
    public static final String TYPE_QUESTION = "question_type";

    public abstract void buildQuestion(int paramInt, Bundle paramBundle, boolean paramBoolean);

    public abstract void discardQuestion();

    public abstract void finishQuestion();

    public abstract void toFirstQuestion();

    public abstract void toNextQuestion();

    public abstract void toPrevQuestion();
}