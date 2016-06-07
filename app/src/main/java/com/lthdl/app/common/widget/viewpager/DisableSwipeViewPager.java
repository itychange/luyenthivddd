package com.lthdl.app.common.widget.viewpager;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;

public class DisableSwipeViewPager extends ViewPager {
    private boolean swipeable = true;

    public DisableSwipeViewPager(Context paramContext) {
        super(paramContext);
    }

    public DisableSwipeViewPager(Context paramContext, AttributeSet paramAttributeSet) {
        super(paramContext, paramAttributeSet);
    }

    public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent) {
        if (this.swipeable)
            return super.onInterceptTouchEvent(paramMotionEvent);
        return false;
    }

    public void setSwipeable(boolean paramBoolean) {
        this.swipeable = paramBoolean;
    }
}