package com.lthdl.app.common.widget.recyclerview;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.drawable.Animatable;
import android.support.v4.content.ContextCompat;
import android.support.v4.graphics.drawable.DrawableCompat;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;

import com.lthdl.app.R;

@TargetApi(21)
class ExpandableItemIndicatorImplAnim extends ExpandableItemIndicator.Impl {
    private int mColor;
    private ImageView mImageView;

    public void onInit(Context paramContext, AttributeSet paramAttributeSet, int paramInt, ExpandableItemIndicator paramExpandableItemIndicator) {
        this.mImageView = ((ImageView) LayoutInflater.from(paramContext).inflate(R.layout.home_view_indicator, paramExpandableItemIndicator, true).findViewById(R.id.image_view));
        this.mColor = ContextCompat.getColor(paramContext, R.color.colorPrimary);
    }

    public void setExpandedState(boolean paramBoolean1, boolean paramBoolean2) {
        // Correct later
        int i = R.drawable.icon_arrownext;
        if (paramBoolean2) {
            {
                this.mImageView.setImageResource(i);
                DrawableCompat.setTint(this.mImageView.getDrawable(), this.mColor);
                ((Animatable) this.mImageView.getDrawable()).start();
                //return;
                i = R.drawable.icon_arrowdown;
            }
        }
        {
            this.mImageView.setImageResource(i);
            DrawableCompat.setTint(this.mImageView.getDrawable(), this.mColor);
            i = R.drawable.icon_arrowdown;
        }
    }
}