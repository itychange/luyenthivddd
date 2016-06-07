package com.lthdl.app.screen.bookdetail;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.lthdl.app.BaseFragment;
import com.lthdl.app.R;
import com.lthdl.app.screen.bookdetail.event.OnEventOpenBuyBookDialog;

import org.greenrobot.eventbus.EventBus;

import butterknife.Bind;

public class BookBuySuccessFragment extends BaseFragment
        implements View.OnClickListener {

    @Bind(R.id.imvBookThumb)
    ImageView imvBookThumb;

    @Bind(R.id.lyContent)
    LinearLayout lyContent;

    @Bind(R.id.lyOK)
    RelativeLayout lyOK;

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

    protected void init(View paramView) {
        this.lyOK.setOnClickListener(this);
        this.lyContent.setOnTouchListener(new View.OnTouchListener() {
            public boolean onTouch(View paramView, MotionEvent paramMotionEvent) {
                return true;
            }
        });
        this.lyParent.setOnTouchListener(new View.OnTouchListener() {
            public boolean onTouch(View paramView, MotionEvent paramMotionEvent) {
                if (paramMotionEvent.getAction() == 1)
                    EventBus.getDefault().post(new OnEventOpenBuyBookDialog(OnEventOpenBuyBookDialog.SCRN_NOTHING));
                return true;
            }
        });
    }

    public void onClick(View paramView) {
        switch (paramView.getId()) {
            case R.id.lyOK:
                EventBus.getDefault().post(new OnEventOpenBuyBookDialog(OnEventOpenBuyBookDialog.SCRN_BOOK_DETAIL));
                break;
            default:
        }
    }

    @Nullable
    public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle) {
        return paramLayoutInflater.inflate(R.layout.book_buy_success_fragment, paramViewGroup, false);
    }
}