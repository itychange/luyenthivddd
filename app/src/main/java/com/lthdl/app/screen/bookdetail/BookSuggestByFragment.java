package com.lthdl.app.screen.bookdetail;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

import butterknife.Bind;

import com.lthdl.app.BaseFragment;
import com.lthdl.app.R;
import com.lthdl.app.screen.bookdetail.event.OnEventOpenBuyBookDialog;

import org.greenrobot.eventbus.EventBus;

public class BookSuggestByFragment extends BaseFragment
        implements View.OnClickListener {

    @Bind(R.id.imvBookThumb)
    ImageView imvBookThumb;

    @Bind(R.id.lyContent)
    LinearLayout lyContent;

    @Bind(R.id.lyParent)
    RelativeLayout lyParent;

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

    @Bind(R.id.tvBuyNow)
    TextView tvBuyNow;

    @Bind(R.id.tvDoAfter)
    TextView tvDoAfter;

    protected void init(View paramView) {
        this.tvDoAfter.setOnClickListener(this);
        this.tvBuyNow.setOnClickListener(this);
        this.lyContent.setOnTouchListener(new View.OnTouchListener() {
            public boolean onTouch(View paramView, MotionEvent paramMotionEvent) {
                return true;
            }
        });
        this.lyParent.setOnTouchListener(new View.OnTouchListener() {
            public boolean onTouch(View paramView, MotionEvent paramMotionEvent) {
                if (paramMotionEvent.getAction() == 1) {
                    EventBus.getDefault().post(new OnEventOpenBuyBookDialog(OnEventOpenBuyBookDialog.SCRN_NOTHING));
                }
                return true;
            }
        });
    }

    public void onClick(View paramView) {
        switch (paramView.getId()) {
            case R.id.tvDoAfter:
                EventBus.getDefault().post(new OnEventOpenBuyBookDialog(OnEventOpenBuyBookDialog.SCRN_NOTHING));
                break;
            case R.id.tvBuyNow:
                EventBus.getDefault().post(new OnEventOpenBuyBookDialog(OnEventOpenBuyBookDialog.SCRN_BUY_BOOK_CONFIRM));
                break;
            default:
                break;
        }
    }

    @Nullable
    public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle) {
        return paramLayoutInflater.inflate(R.layout.book_detail_requestbuy_fragment, paramViewGroup, false);
    }
}