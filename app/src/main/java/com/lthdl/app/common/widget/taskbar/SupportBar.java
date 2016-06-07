package com.lthdl.app.common.widget.taskbar;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;

import com.lthdl.app.R;

public class SupportBar extends LinearLayout {
    GridView grvSupport;
    int[] icons = {R.drawable.icon_messenger, R.drawable.icon_skype, R.drawable.icon_zalo};
    ImageView imvIconCloseSupport;
    String[] names = {"Messenger", "Skype", "Zalo"};

    public SupportBar(Context paramContext) {
        super(paramContext);
        init();
    }

    public SupportBar(Context paramContext, AttributeSet paramAttributeSet) {
        super(paramContext, paramAttributeSet);
        init();
    }

    public SupportBar(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
        super(paramContext, paramAttributeSet, paramInt);
        init();
    }

    private void init() {
        Object localObject = LayoutInflater.from(getContext()).inflate(R.layout.home_view_support_tool, this, true);
        this.imvIconCloseSupport = ((ImageView) ((View) localObject).findViewById(R.id.imvIconCloseSupport));
        this.grvSupport = ((GridView) ((View) localObject).findViewById(R.id.grvSupport));
        localObject = new SupportAdapter(this.icons, this.names, getContext());
        this.grvSupport.setAdapter((ListAdapter) localObject);
        this.grvSupport.setOnItemClickListener(new OnItemClickListener() {
            public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong) {
                switch (paramInt) {
                    case 0:
                    case 1:
                }
            }
        });
        setOnTouchListener(new OnTouchListener() {
            public boolean onTouch(View paramView, MotionEvent paramMotionEvent) {
                return true;
            }
        });
        this.imvIconCloseSupport.setOnClickListener(new OnClickListener() {
            public void onClick(View paramView) {
//                SupportBar.this.hide();
                hideImediately();
            }
        });
    }

    public void hide() {
        Animation localAnimation = AnimationUtils.loadAnimation(getContext(), R.anim.slide_down);
        localAnimation.setAnimationListener(new AnimationListener() {
            public void onAnimationEnd(Animation paramAnimation) {
                SupportBar.this.setVisibility(View.GONE);
            }

            public void onAnimationRepeat(Animation paramAnimation) {
            }

            public void onAnimationStart(Animation paramAnimation) {
            }
        });
        startAnimation(localAnimation);
    }

    public void hideImediately() {
        setVisibility(View.GONE);
    }

    public boolean isShow() {
        return getVisibility() == View.VISIBLE;
    }

    public void show() {
        setVisibility(View.VISIBLE);
        Animation localAnimation = AnimationUtils.loadAnimation(getContext(), R.anim.slide_up);
        localAnimation.setAnimationListener(new AnimationListener() {
            public void onAnimationEnd(Animation paramAnimation) {
                SupportBar.this.setVisibility(View.VISIBLE);
            }

            public void onAnimationRepeat(Animation paramAnimation) {
            }

            public void onAnimationStart(Animation paramAnimation) {
            }
        });
        startAnimation(localAnimation);
    }

    public void toggle() {
        if (getVisibility() == View.VISIBLE) {
            hide();
            return;
        }
        show();
    }
}