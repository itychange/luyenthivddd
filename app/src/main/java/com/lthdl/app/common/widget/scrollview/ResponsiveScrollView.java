package com.lthdl.app.common.widget.scrollview;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ScrollView;

public class ResponsiveScrollView extends ScrollView {
    private boolean mIsFling;
    private OnEndScrollListener mOnEndScrollListener;

    public ResponsiveScrollView(Context paramContext) {
        this(paramContext, null, 0);
    }

    public ResponsiveScrollView(Context paramContext, AttributeSet paramAttributeSet) {
        this(paramContext, paramAttributeSet, 0);
    }

    public ResponsiveScrollView(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
        super(paramContext, paramAttributeSet, paramInt);
    }

    public void fling(int paramInt) {
        super.fling(paramInt);
        this.mIsFling = true;
    }

    public OnEndScrollListener getOnEndScrollListener() {
        return this.mOnEndScrollListener;
    }

    protected void onScrollChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
        super.onScrollChanged(paramInt1, paramInt2, paramInt3, paramInt4);
        if ((this.mIsFling) && ((Math.abs(paramInt2 - paramInt4) < 2) || (paramInt2 >= getMeasuredHeight()) || (paramInt2 == 0))) {
            if (this.mOnEndScrollListener != null)
                this.mOnEndScrollListener.onEndScroll();
            this.mIsFling = false;
        }
    }

    public void setOnEndScrollListener(OnEndScrollListener paramOnEndScrollListener) {
        this.mOnEndScrollListener = paramOnEndScrollListener;
    }

    public static abstract interface OnEndScrollListener {
        public abstract void onEndScroll();
    }
}