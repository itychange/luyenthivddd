package com.lthdl.app.screen.bookdetail.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import android.widget.TextView;

import butterknife.Bind;
import butterknife.ButterKnife;

import com.github.aakira.expandablelayout.ExpandableRelativeLayout;
import com.lthdl.app.R;
import com.lthdl.app.screen.bookdetail.model.BookOverViewModel;

public class BookOverView extends LinearLayout
        implements OnClickListener {

    @Bind(R.id.imvBookThumb)
    ImageView imvBookThumb;

    @Bind(R.id.imvExpandBookDetail)
    ImageView imvExpandBookDetail;
    boolean isExpand = false;

    @Bind(R.id.lyExpandBookDetail)
    ExpandableRelativeLayout lyExpandBookDetail;

    @Bind(R.id.ratingBook)
    RatingBar ratingBook;

    @Bind(R.id.tvBookAuthor)
    TextView tvBookAuthor;

    @Bind(R.id.tvBookIntro)
    TextView tvBookIntro;

    @Bind(R.id.tvBookRateCount)
    TextView tvBookRateCount;

    @Bind(R.id.tvBookStatus)
    TextView tvBookStatus;

    @Bind(R.id.tvBookTitle)
    TextView tvBookTitle;

    @Bind(R.id.tvOverView)
    TextView tvOverView;

    public BookOverView(Context paramContext) {
        super(paramContext);
        init();
    }

    public BookOverView(Context paramContext, AttributeSet paramAttributeSet) {
        super(paramContext, paramAttributeSet);
        init();
    }

    public BookOverView(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
        super(paramContext, paramAttributeSet, paramInt);
        init();
    }

    public BookOverView(Context paramContext, BookOverViewModel paramBookOverViewModel) {
        super(paramContext);
        init();
        setData(paramBookOverViewModel);
    }

    private void init() {
        ButterKnife.bind(this, LayoutInflater.from(getContext()).inflate(R.layout.item_book_overview, this, true));
        this.imvExpandBookDetail.setOnClickListener(this);
        this.tvOverView.setOnClickListener(this);
    }

    public void onClick(View paramView) {
        switch (paramView.getId()) {
            default:
                return;
            case R.id.imvExpandBookDetail:
                if (!this.isExpand) {
                    this.lyExpandBookDetail.expand();
                    this.isExpand = true;
                    this.imvExpandBookDetail.setImageResource(R.drawable.icon_arrow_up);
                    return;
                }
                this.lyExpandBookDetail.collapse();
                this.isExpand = false;
                this.imvExpandBookDetail.setImageResource(R.drawable.icon_arrowdown);
                return;
            case R.id.tvOverView:
        }
        this.imvExpandBookDetail.performClick();
    }

    public void setData(BookOverViewModel paramBookOverViewModel) {
        this.tvOverView.setText(paramBookOverViewModel.overView);
        this.tvBookAuthor.setText(paramBookOverViewModel.author);
        this.tvBookTitle.setText(paramBookOverViewModel.title);
        this.imvBookThumb.setImageResource(paramBookOverViewModel.iconResource);
        this.tvBookRateCount.setText("(" + paramBookOverViewModel.rateCount + ")");
        this.tvBookStatus.setText(paramBookOverViewModel.status);
        this.tvBookIntro.setText(paramBookOverViewModel.intro);
    }
}