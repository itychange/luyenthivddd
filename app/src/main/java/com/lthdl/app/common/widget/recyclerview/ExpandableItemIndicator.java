package com.lthdl.app.common.widget.recyclerview;

import android.content.Context;
import android.os.Build.VERSION;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.widget.FrameLayout;

public class ExpandableItemIndicator extends FrameLayout {
    private Impl mImpl;

    public ExpandableItemIndicator(Context paramContext) {
        super(paramContext);
        onInit(paramContext, null, 0);
    }

    public ExpandableItemIndicator(Context paramContext, AttributeSet paramAttributeSet) {
        super(paramContext, paramAttributeSet);
        onInit(paramContext, paramAttributeSet, 0);
    }

    public ExpandableItemIndicator(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
        super(paramContext, paramAttributeSet, paramInt);
        onInit(paramContext, paramAttributeSet, paramInt);
    }

    protected void dispatchRestoreInstanceState(SparseArray<Parcelable> paramSparseArray) {
        super.dispatchThawSelfOnly(paramSparseArray);
    }

    protected void dispatchSaveInstanceState(SparseArray<Parcelable> paramSparseArray) {
        super.dispatchFreezeSelfOnly(paramSparseArray);
    }

    protected void onInit(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
        if (VERSION.SDK_INT >= 21) {
            this.mImpl = new ExpandableItemIndicatorImplAnim();
        } else {
            this.mImpl = new ExpandableItemIndicatorImplNoAnim();
        }
        this.mImpl.onInit(paramContext, paramAttributeSet, paramInt, this);
    }

    public void setExpandedState(boolean paramBoolean1, boolean paramBoolean2) {
        this.mImpl.setExpandedState(paramBoolean1, paramBoolean2);
    }

    static abstract class Impl {
        public abstract void onInit(Context paramContext, AttributeSet paramAttributeSet, int paramInt, ExpandableItemIndicator paramExpandableItemIndicator);

        public abstract void setExpandedState(boolean paramBoolean1, boolean paramBoolean2);
    }
}