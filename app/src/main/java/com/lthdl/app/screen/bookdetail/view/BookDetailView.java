package com.lthdl.app.screen.bookdetail.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;

import butterknife.Bind;
import butterknife.ButterKnife;

import com.lthdl.app.R;
import com.lthdl.app.common.widget.scrollview.ResponsiveScrollView;
import com.lthdl.app.common.widget.scrollview.ResponsiveScrollView.OnEndScrollListener;
import com.lthdl.app.screen.bookdetail.model.BookModel;
import com.lthdl.app.screen.bookdetail.model.SubChapterModel;

public class BookDetailView extends LinearLayout {
    private BookDetailListener bookDetailListener = new BookDetailListener() {
        public void onCollapse() {
        }

        public void onExpand() {
        }

        public void onScollEnd() {
        }

        public void onSubChapterItemClick(View paramView, SubChapterModel paramSubChapterModel, int paramInt1, int paramInt2) {
        }

        public void onSubChapterItemSettingClick(View paramView, SubChapterModel paramSubChapterModel, int paramInt1, int paramInt2) {
        }
    };

    @Bind(R.id.contentBookDetail)
    LinearLayout contentBookDetail;

    @Bind(R.id.scrollContentBookDetail)
    ResponsiveScrollView scrollContentBookDetail;

    public BookDetailView(Context paramContext) {
        super(paramContext);
        init();
    }

    public BookDetailView(Context paramContext, AttributeSet paramAttributeSet) {
        super(paramContext, paramAttributeSet);
        init();
    }

    public BookDetailView(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
        super(paramContext, paramAttributeSet, paramInt);
        init();
    }

    private void init() {
        ButterKnife.bind(this, LayoutInflater.from(getContext()).inflate(R.layout.book_detail_view, this, true));
        this.scrollContentBookDetail.setOnEndScrollListener(new ResponsiveScrollView.OnEndScrollListener() {
            public void onEndScroll() {
                BookDetailView.this.bookDetailListener.onScollEnd();
            }
        });
    }

    public void addBookDetailView(View paramView) {
        this.contentBookDetail.addView(paramView);
        this.contentBookDetail.invalidate();
        invalidate();
    }

    public BookDetailListener getBookDetailListener() {
        return this.bookDetailListener;
    }

    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
    }

    public void setBookDetailListener(BookDetailListener paramBookDetailListener) {
        this.bookDetailListener = paramBookDetailListener;
    }

    public void setData(BookModel paramBookModel) {
    }

    public static abstract interface BookDetailListener {
        public abstract void onCollapse();

        public abstract void onExpand();

        public abstract void onScollEnd();

        public abstract void onSubChapterItemClick(View paramView, SubChapterModel paramSubChapterModel, int paramInt1, int paramInt2);

        public abstract void onSubChapterItemSettingClick(View paramView, SubChapterModel paramSubChapterModel, int paramInt1, int paramInt2);
    }
}