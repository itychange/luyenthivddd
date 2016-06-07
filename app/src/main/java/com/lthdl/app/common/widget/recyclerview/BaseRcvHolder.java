package com.lthdl.app.common.widget.recyclerview;

import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;

import com.h6ah4i.android.widget.advrecyclerview.expandable.ExpandableItemViewHolder;

import butterknife.ButterKnife;

public abstract class BaseRcvHolder extends ViewHolder
        implements ExpandableItemViewHolder {
    public BaseRcvHolder(View paramView) {
        super(paramView);
        ButterKnife.bind(this, paramView);
    }
}