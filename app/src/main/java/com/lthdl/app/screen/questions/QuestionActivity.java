package com.lthdl.app.screen.questions;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.lthdl.app.BaseActivity;
import com.lthdl.app.R;
import com.lthdl.app.common.widget.taskbar.SupportBar;
import com.lthdl.app.global.Constant;
import com.lthdl.app.screen.questions.api.IQuestionFlow;
import com.lthdl.app.screen.questions.event.OnEventOneQuestionComplete;
import com.lthdl.app.screen.questions.fragment.GroupQuestionFragment;
import com.lthdl.app.screen.questions.fragment.JumpOrderAnswerFragment;
import com.lthdl.app.screen.questions.fragment.JumpTextInPlaceFragment;
import com.lthdl.app.screen.questions.fragment.MultiChoiceFragment;
import com.lthdl.app.screen.questions.fragment.OrderAnswerFragment;
import com.lthdl.app.screen.questions.fragment.SingleChoiceFragment;
import com.lthdl.app.screen.questions.fragment.TextInPlaceFragment;
import com.lthdl.app.screen.questions.fragment.TextSingleChoiseFragment;
import com.lthdl.app.screen.statistic.StatisticActivity;
import com.lthdl.app.screen.statistic.event.OnEventOpenStatisticActivity;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import java.util.LinkedList;
import java.util.Queue;

import butterknife.Bind;
import butterknife.OnClick;

public class QuestionActivity extends BaseActivity
        implements IQuestionFlow {
    Animation animEnter = null;
    Animation animExit = null;

    @Bind(R.id.imvNext)
    ImageView imvNext;

    @Bind(R.id.lyNext)
    RelativeLayout lyNext;
    Queue<Integer> queueQuestion = new LinkedList();

    @Bind(R.id.supportBar)
    SupportBar supportBar;

    public void buildQuestion(int paramInt, Bundle paramBundle, boolean paramBoolean) {
        FragmentTransaction localFragmentTransaction = getSupportFragmentManager().beginTransaction();
        Log.e(Constant.TAG, "QuestionActivity->buildQuestion() paramInt =[" + paramInt + "]");
        switch (paramInt) {
            case IQuestionFlow.TEXT_SINGLE_CHOICE:
                localFragmentTransaction.replace(R.id.container, new TextSingleChoiseFragment());
                break;
            case IQuestionFlow.SINGLE_CHOICE:
                localFragmentTransaction.replace(R.id.container, new SingleChoiceFragment());
                break;
            case IQuestionFlow.MULTI_CHOICE:
                localFragmentTransaction.replace(R.id.container, new MultiChoiceFragment());
                break;
            case IQuestionFlow.ORDER_ANSWER:
                localFragmentTransaction.replace(R.id.container, new OrderAnswerFragment());
                break;
            case IQuestionFlow.TEXT_IN_PLACE:
                localFragmentTransaction.replace(R.id.container, new TextInPlaceFragment());
                break;
            case IQuestionFlow.JUMP_TEXT_IN_PLACE:
                localFragmentTransaction.replace(R.id.container, new JumpTextInPlaceFragment());
                break;
            case IQuestionFlow.JUMP_ORDER_ANSWER:
                localFragmentTransaction.replace(R.id.container, new JumpOrderAnswerFragment());
                break;
            case IQuestionFlow.GROUP_QUESTION:
                localFragmentTransaction.replace(R.id.container, new GroupQuestionFragment());
                break;
            default:
                throw new UnsupportedOperationException("Can not build question with invalid type");
        }
        localFragmentTransaction.commitAllowingStateLoss();
    }

    public void discardQuestion() {
    }

    public void finishQuestion() {
        finish();
        EventBus.getDefault().post(new OnEventOpenStatisticActivity());
    }

    public void hideNext() {
        this.animExit.setAnimationListener(new AnimationListener() {
            public void onAnimationEnd(Animation paramAnimation) {
                QuestionActivity.this.imvNext.setVisibility(View.GONE);
            }

            public void onAnimationRepeat(Animation paramAnimation) {
            }

            public void onAnimationStart(Animation paramAnimation) {
            }
        });
        this.imvNext.startAnimation(this.animExit);
    }

    protected void init() {
        Log.e(Constant.TAG, "QuestionActivity->init() start");
        if (!getIntent().hasExtra("question_type"))
            throw new UnsupportedOperationException("Might you forgot parse TYPE_QUESTION in intent extra");
        this.queueQuestion.add(IQuestionFlow.TEXT_SINGLE_CHOICE/*Integer.valueOf(0)*/);
        this.queueQuestion.add(IQuestionFlow.GROUP_QUESTION);
        this.queueQuestion.add(IQuestionFlow.SINGLE_CHOICE);
        this.queueQuestion.add(IQuestionFlow.TEXT_IN_PLACE);
        this.queueQuestion.add(IQuestionFlow.MULTI_CHOICE);
        this.queueQuestion.add(IQuestionFlow.ORDER_ANSWER);
        this.queueQuestion.add(IQuestionFlow.JUMP_TEXT_IN_PLACE);
        this.queueQuestion.add(IQuestionFlow.JUMP_ORDER_ANSWER);
        toNextQuestion();
        Log.e(Constant.TAG, "QuestionActivity->init() end");
    }

    protected void onCreate(Bundle paramBundle) {
        super.onCreate(paramBundle);
        setContentView(R.layout.question_activity);
        setSupportActionBar((Toolbar) findViewById(R.id.toolbar));
        getSupportActionBar().setDisplayHomeAsUpEnabled(false);
        getSupportActionBar().setDisplayShowHomeEnabled(false);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        this.animEnter = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.enter_from_right);
        this.animExit = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.exit_to_right);
        this.animExit.setDuration(20L);
        this.animEnter.setDuration(20L);
        this.imvNext.setVisibility(View.GONE);
    }

    @Subscribe
    public void onEvent(OnEventOneQuestionComplete paramOnEventOneQuestionComplete) {
        if (paramOnEventOneQuestionComplete.isShowNextQuestion) {
            showNext();
        } else {
            hideNext();
        }

    }

    @Subscribe
    public void onEvent(OnEventOpenStatisticActivity paramOnEventOpenStatisticActivity) {
        startActivity(new Intent(this, StatisticActivity.class));
    }

    @OnClick(R.id.tvIndex)
    public void onIndexClick(View paramView) {
        Snackbar.make(paramView, "index", Snackbar.LENGTH_SHORT).show();
    }

    @OnClick(R.id.imvNext)
    public void onNextClick(View paramView) {
        hideNext();
        toNextQuestion();
    }

    public boolean onOptionsItemSelected(MenuItem paramMenuItem) {
        if (paramMenuItem.getItemId() == android.R.id.home) {
            finish();
        }
        return super.onOptionsItemSelected(paramMenuItem);
    }

    @OnClick(R.id.imvSupport)
    public void onSupportClick(View paramView) {
        this.supportBar.toggle();
    }

    @OnClick(R.id.tvTitle)
    public void onTitleClick() {
        finish();
    }

    public void showNext() {
        this.animEnter.setAnimationListener(new AnimationListener() {
            public void onAnimationEnd(Animation paramAnimation) {
                QuestionActivity.this.imvNext.setVisibility(View.VISIBLE);
            }

            public void onAnimationRepeat(Animation paramAnimation) {
            }

            public void onAnimationStart(Animation paramAnimation) {
            }
        });
        this.imvNext.startAnimation(this.animEnter);
    }

    public void toFirstQuestion() {
    }

    public void toNextQuestion() {
        if (this.queueQuestion.isEmpty()) {
            finishQuestion();
            return;
        }
        switch (this.queueQuestion.poll()) {
            case IQuestionFlow.TEXT_SINGLE_CHOICE:
                buildQuestion(IQuestionFlow.TEXT_SINGLE_CHOICE, new Bundle(), true);
                break;
            case IQuestionFlow.SINGLE_CHOICE:
                buildQuestion(IQuestionFlow.SINGLE_CHOICE, new Bundle(), true);
                break;
            case IQuestionFlow.MULTI_CHOICE:
                buildQuestion(IQuestionFlow.MULTI_CHOICE, new Bundle(), true);
                break;
            case IQuestionFlow.ORDER_ANSWER:
                buildQuestion(IQuestionFlow.ORDER_ANSWER, new Bundle(), true);
                break;
            case IQuestionFlow.TEXT_IN_PLACE:
                buildQuestion(IQuestionFlow.TEXT_IN_PLACE, new Bundle(), true);
                break;
            case IQuestionFlow.JUMP_TEXT_IN_PLACE:
                buildQuestion(IQuestionFlow.JUMP_TEXT_IN_PLACE, new Bundle(), true);
                break;
            case IQuestionFlow.JUMP_ORDER_ANSWER:
                buildQuestion(IQuestionFlow.JUMP_ORDER_ANSWER, new Bundle(), true);
                break;
            case IQuestionFlow.GROUP_QUESTION:
                buildQuestion(IQuestionFlow.GROUP_QUESTION, new Bundle(), true);
                break;
            default:
                throw new UnsupportedOperationException("Next question has an invalid type!");
        }
    }

    public void toPrevQuestion() {
    }
}