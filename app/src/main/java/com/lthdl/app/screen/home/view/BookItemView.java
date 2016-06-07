package com.lthdl.app.screen.home.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.lthdl.app.R;
import com.lthdl.app.screen.bookdetail.event.OnEventOpenBookDetailActivity;

import org.greenrobot.eventbus.EventBus;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class BookItemView extends LinearLayout {

    @Bind(R.id.tvBookId)
    public TextView tvBookId;

    public BookItemView(Context paramContext) {
        super(paramContext);
        init();
    }

    public BookItemView(Context paramContext, AttributeSet paramAttributeSet) {
        super(paramContext, paramAttributeSet);
        init();
    }

    public BookItemView(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
        super(paramContext, paramAttributeSet, paramInt);
        init();
    }

    private void init() {
        LayoutInflater.from(getContext()).inflate(R.layout.home_view_book_item, this, true);
        ButterKnife.bind(this);
    }

    public String getBookId() {
        return this.tvBookId.getText().toString();
    }

    @OnClick(R.id.lyMain)
    public void onBookClick(View paramView) {
        EventBus.getDefault().post(new OnEventOpenBookDetailActivity(getBookId()));
    }
}