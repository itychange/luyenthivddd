package com.lthdl.app.screen.home.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.github.aakira.expandablelayout.ExpandableRelativeLayout;
import com.lthdl.app.R;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class BookCollectItemView extends FrameLayout {
    public static final int MAX_BOOK_VISIBLE = 3;

    @Bind(R.id.imvExpandChapter)
    ImageView imvExpandChapter;

    @Bind(R.id.lyBookGroupInVisiable)
    LinearLayout lyBookGroupInVisiable;

    @Bind(R.id.lyBookGroupInVisiableBound)
    ExpandableRelativeLayout lyBookGroupInVisiableBound;

    @Bind(R.id.lyBookGroupVisiable)
    LinearLayout lyBookGroupVisiable;

    @Bind(R.id.lyExpand)
    LinearLayout lyExpand;

    public BookCollectItemView(Context paramContext) {
        super(paramContext);
        init();
    }

    public BookCollectItemView(Context paramContext, AttributeSet paramAttributeSet) {
        super(paramContext, paramAttributeSet);
        init();
    }

    public BookCollectItemView(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
        super(paramContext, paramAttributeSet, paramInt);
        init();
    }

    private void init() {
        LayoutInflater.from(getContext()).inflate(R.layout.home_view_book_collect_item, this, true);
        ButterKnife.bind(this);
        setData();
        this.lyBookGroupInVisiableBound.setExpanded(false);
        this.lyExpand.setVisibility(GONE);
    }

    @OnClick(R.id.lyExpand)
    public void onExpandClick(View paramView) {
        this.lyBookGroupInVisiableBound.toggle();
        if (this.lyBookGroupInVisiableBound.isExpanded()) {
            this.imvExpandChapter.setImageResource(R.drawable.icon_arrowdown);
            return;
        }
        this.imvExpandChapter.setImageResource(R.drawable.icon_arrow_up);
    }

    public void setData() {
        for (int i = 0; i < 10; i++) {
            BookItemView localBookItemView = new BookItemView(getContext());
            //if (i < MAX_BOOK_VISIBLE) {
                this.lyBookGroupVisiable.addView(localBookItemView);
            /*} else {
                this.lyBookGroupInVisiable.addView(localBookItemView);
            }*/
        }
    }
}