package com.lthdl.app.screen.bookdetail;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.lthdl.app.BaseFragment;
import com.lthdl.app.R;
import com.lthdl.app.screen.bookdetail.event.OnEventOpenBuyBookDialog;
import com.lthdl.app.screen.naptien.event.OnEventOpenNapTienActivity;

import org.greenrobot.eventbus.EventBus;

import butterknife.Bind;
import de.hdodenhof.circleimageview.CircleImageView;

public class BookBuyFailFragment extends BaseFragment
        implements View.OnClickListener {

    @Bind(R.id.lyCancel)
    RelativeLayout lyCancel;

    @Bind(R.id.lyContent)
    LinearLayout lyContent;

    @Bind(R.id.lyParent)
    RelativeLayout lyParent;

    @Bind(R.id.profile_image)
    CircleImageView profileImage;

    @Bind(R.id.tvMoney)
    TextView tvMoney;

    @Bind(R.id.tvNotification)
    TextView tvNotification;

    @Bind(R.id.tvPayment)
    TextView tvPayment;

    @Bind(R.id.tvUserName)
    TextView tvUserName;

    protected void init(View paramView) {
        this.lyCancel.setOnClickListener(this);
        this.tvPayment.setOnClickListener(this);
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
            case R.id.tvNotification:
                break;
            case R.id.lyCancel:
                EventBus.getDefault().post(new OnEventOpenBuyBookDialog(OnEventOpenBuyBookDialog.SCRN_NOTHING));
                break;
            case R.id.tvPayment:
                EventBus.getDefault().post(new OnEventOpenBuyBookDialog(OnEventOpenBuyBookDialog.SCRN_NOTHING));
                EventBus.getDefault().post(new OnEventOpenNapTienActivity());
                break;
            default:
                break;
        }
    }

    @Nullable
    public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle) {
        return paramLayoutInflater.inflate(R.layout.book_buy_fail_fragment, paramViewGroup, false);
    }
}