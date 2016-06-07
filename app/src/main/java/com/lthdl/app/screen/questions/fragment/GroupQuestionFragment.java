package com.lthdl.app.screen.questions.fragment;

import android.content.res.Resources;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.ViewSwitcher;

import butterknife.Bind;
import butterknife.OnClick;

import com.lthdl.app.BaseFragment;
import com.lthdl.app.R;
import com.lthdl.app.common.StringUtils;
import com.lthdl.app.common.widget.textview.RichTextView;
import com.lthdl.app.common.widget.viewpager.DisableSwipeViewPager;
import com.lthdl.app.global.Constant;
import com.lthdl.app.screen.questions.event.OnEventOneQuestionComplete;
import com.lthdl.app.screen.questions.view.group_question.adapter.ChildFragmentQuestionAdapter;
import com.lthdl.app.screen.questions.view.group_question.event.OnEventChildQuestionComplete;
import com.lthdl.app.screen.questions.view.group_question.fragment.ChildGroupQuestionFragment;
import com.sothree.slidinguppanel.SlidingUpPanelLayout;
import com.sothree.slidinguppanel.SlidingUpPanelLayout.PanelState;
import com.sothree.slidinguppanel.SlidingUpPanelLayout.PanelSlideListener;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class GroupQuestionFragment extends BaseFragment {
    public static final String CLASS_NAME = " GroupQuestionFragment ";
    ChildFragmentQuestionAdapter adapter;
    Animation animEnter = null;
    Animation animExit = null;
    int currentQuestion;

    @Bind(R.id.imvNext)
    ImageView imvNext;

    @Bind(R.id.imvSlide)
    ImageView imvSlide;

    @Bind(R.id.imvSlide1)
    ImageView imvSlide1;
    boolean isSlideExpand = false;

    @Bind(R.id.slideLayout)
    SlidingUpPanelLayout slideLayout;

    @Bind(R.id.tvQuestionContent)
    RichTextView tvQuestionContent;

    @Bind(R.id.viewPagerChildQuestion)
    DisableSwipeViewPager viewPagerChildQuestion;

    @Bind(R.id.viewSwitcher)
    ViewSwitcher viewSwitcher;

    public void hideNext() {
        this.animExit.setAnimationListener(new AnimationListener() {
            public void onAnimationEnd(Animation paramAnimation) {
                GroupQuestionFragment.this.imvNext.setVisibility(View.GONE);
            }

            public void onAnimationRepeat(Animation paramAnimation) {
            }

            public void onAnimationStart(Animation paramAnimation) {
            }
        });
        this.imvNext.startAnimation(this.animExit);
    }

    protected void init(View paramView) {
        this.animEnter = AnimationUtils.loadAnimation(getActivity(), R.anim.enter_from_right);
        this.animExit = AnimationUtils.loadAnimation(getActivity(), R.anim.exit_to_right);
        this.animExit.setDuration(20L);
        this.animEnter.setDuration(20L);
        this.imvNext.setVisibility(View.GONE);
        this.slideLayout.setPressed(false);
        this.slideLayout.setCoveredFadeColor(getResources().getColor(R.color.transparent));
        this.slideLayout.addPanelSlideListener(new PanelSlideListener() {

            public void onPanelStateChanged(View panel, PanelState previousState, PanelState newState) {

            }

            public void onPanelAnchored(View paramView) {
            }

            public void onPanelCollapsed(View paramView) {
                if (GroupQuestionFragment.this.isSlideExpand) {
                    GroupQuestionFragment.this.viewSwitcher.showNext();
                    GroupQuestionFragment.this.slideLayout.setDragView(GroupQuestionFragment.this.imvSlide);
                    GroupQuestionFragment.this.isSlideExpand = false;
                }
            }

            public void onPanelExpanded(View paramView) {
                if (!GroupQuestionFragment.this.isSlideExpand) {
                    GroupQuestionFragment.this.viewSwitcher.showNext();
                    GroupQuestionFragment.this.slideLayout.setDragView(GroupQuestionFragment.this.imvSlide1);
                    GroupQuestionFragment.this.isSlideExpand = true;
                }
            }

            public void onPanelHidden(View paramView) {
            }

            public void onPanelSlide(View paramView, float paramFloat) {
            }
        });
        String strQuestionLong = StringUtils.getStringFromResouce(getContext(), R.string.question_long);
        this.tvQuestionContent.setRichText(strQuestionLong);
        this.slideLayout.setDragView(this.imvSlide);
        ArrayList localArrayList = new ArrayList();
        Object localObject = new ArrayList();
        ((List) localObject).add(0);
        ((List) localObject).add(1);
        ((List) localObject).add(1);
        ((List) localObject).add(0/*Integer.valueOf(0)*/);
        localObject = ((List) localObject).iterator();
        while (((Iterator) localObject).hasNext())
            localArrayList.add(ChildGroupQuestionFragment.newInstance(((Integer) ((Iterator) localObject).next()).intValue(), ""));
        this.adapter = new ChildFragmentQuestionAdapter(getSupportFragmentManager(), localArrayList);
        this.viewPagerChildQuestion.setAdapter(this.adapter);
        this.viewPagerChildQuestion.setSwipeable(false);
    }

    @Nullable
    public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle) {
        return paramLayoutInflater.inflate(R.layout.question_group_fragment, paramViewGroup, false);
    }

    @Subscribe
    public void onEvent(OnEventChildQuestionComplete paramOnEventChildQuestionComplete) {
//        Log.e(Constant.TAG, CLASS_NAME + " onEvent()->start ");
        this.currentQuestion = this.viewPagerChildQuestion.getCurrentItem();
        if (this.currentQuestion <= this.viewPagerChildQuestion.getChildCount()) {
//            Log.e(Constant.TAG, CLASS_NAME + " onEvent()->showNext [currentQuestion]=="+currentQuestion+" ChildCount=="+viewPagerChildQuestion.getChildCount());
            showNext();
            return;
        }
        OnEventOneQuestionComplete LocalOnEventOneQuestionComplete = new OnEventOneQuestionComplete();
        EventBus.getDefault().post(LocalOnEventOneQuestionComplete);
//        Log.e(Constant.TAG, CLASS_NAME + " onEvent()->end ");
    }

    @OnClick(R.id.imvNext)
    public void onNextClick(View paramView) {
        int i = this.currentQuestion + 1;
        this.currentQuestion = i;
        this.viewPagerChildQuestion.setCurrentItem(i);
        hideNext();
    }

    public void showNext() {
        this.animEnter.setAnimationListener(new AnimationListener() {
            public void onAnimationEnd(Animation paramAnimation) {
                GroupQuestionFragment.this.imvNext.setVisibility(View.VISIBLE);
            }

            public void onAnimationRepeat(Animation paramAnimation) {
            }

            public void onAnimationStart(Animation paramAnimation) {
            }
        });
        this.imvNext.startAnimation(this.animEnter);
    }
}