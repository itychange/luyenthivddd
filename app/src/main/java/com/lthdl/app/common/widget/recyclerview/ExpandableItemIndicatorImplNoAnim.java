package com.lthdl.app.common.widget.recyclerview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;

import com.lthdl.app.R;

class ExpandableItemIndicatorImplNoAnim extends ExpandableItemIndicator.Impl {
    private ImageView mImageView;

    public void onInit(Context paramContext, AttributeSet paramAttributeSet, int paramInt, ExpandableItemIndicator paramExpandableItemIndicator) {
        this.mImageView = ((ImageView) LayoutInflater.from(paramContext).inflate(R.layout.home_view_indicator, paramExpandableItemIndicator, true).findViewById(2131624156));
    }

    public void setExpandedState(boolean paramBoolean1, boolean paramBoolean2) {
        if (paramBoolean1) {
            this.mImageView.setImageResource(R.drawable.icon_arrowdown);
        }
        if (paramBoolean2) {
            this.mImageView.setImageResource(R.drawable.icon_arrownext);
        }
    }
}