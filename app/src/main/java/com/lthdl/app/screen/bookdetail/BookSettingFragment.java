package com.lthdl.app.screen.bookdetail;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RelativeLayout;
import android.widget.TextView;

import butterknife.Bind;

import com.lthdl.app.BaseFragment;
import com.lthdl.app.R;
import com.lthdl.app.global.Constant;
import com.lthdl.app.screen.bookdetail.event.OnEventOpenBuyBookDialog;

import org.greenrobot.eventbus.EventBus;

public class BookSettingFragment extends BaseFragment
        implements CompoundButton.OnCheckedChangeListener, View.OnClickListener {

    public static final String CLASS_NAME = " BookSettingFragment ";
    @Bind(R.id.lyContent)
    LinearLayout lyContent;

    @Bind(R.id.lyDapAnTruoc)
    RelativeLayout lyDanAnTruoc;

    @Bind(R.id.lyDapAnSau)
    RelativeLayout lyDapAnSau;

    @Bind(R.id.lyNgauNhien)
    RelativeLayout lyNgauNhien;

    @Bind(R.id.lyParent)
    RelativeLayout lyParent;

    @Bind(R.id.lyThuTu)
    RelativeLayout lyThuTu;

    @Bind(R.id.radioDapAnSau)
    RadioButton radioDapAnSau;

    @Bind(R.id.radioDapAnTruoc)
    RadioButton radioDapAnTruoc;

    @Bind(R.id.radioNgauNhien)
    RadioButton radioNgauNhien;

    @Bind(R.id.radioThuTu)
    RadioButton radioThuTu;

    @Bind(R.id.tvBackToDefault)
    TextView tvBackToDefault;

    @Bind(R.id.tvCancelSetting)
    TextView tvCancelSetting;

    @Bind(R.id.tvIntroSetting)
    TextView tvIntroSetting;

    @Bind(R.id.tvSaveSetting)
    TextView tvSaveSetting;

    @Bind(R.id.tvSubTitleSetting)
    TextView tvSubTitleSetting;

    protected void init(View paramView) {
        Log.e(Constant.TAG, CLASS_NAME + "init()->start");
        this.radioThuTu.setOnCheckedChangeListener(this);
        this.radioNgauNhien.setOnCheckedChangeListener(this);
        this.radioDapAnTruoc.setOnCheckedChangeListener(this);
        this.radioDapAnSau.setOnCheckedChangeListener(this);
        this.tvCancelSetting.setOnClickListener(this);
        this.tvBackToDefault.setOnClickListener(this);
        this.tvSaveSetting.setOnClickListener(this);
        this.lyThuTu.setOnClickListener(this);
        this.lyNgauNhien.setOnClickListener(this);
        this.lyDanAnTruoc.setOnClickListener(this);
        this.lyDapAnSau.setOnClickListener(this);
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
        Log.e(Constant.TAG, CLASS_NAME + "init()->end");
    }

    public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean) {
        Log.e(Constant.TAG, CLASS_NAME + "onCheckedChanged()->start");
        switch (paramCompoundButton.getId()) {
            case R.id.radioNgauNhien:
                radioNgauNhien.setChecked(paramBoolean);
                radioThuTu.setChecked(!paramBoolean);
                break;
            case R.id.radioThuTu:
                radioThuTu.setChecked(paramBoolean);
                radioNgauNhien.setChecked(!paramBoolean);
                break;
            case R.id.radioDapAnTruoc:
                radioDapAnTruoc.setChecked(paramBoolean);
                radioDapAnSau.setChecked(!paramBoolean);
                break;
            case R.id.radioDapAnSau:
                radioDapAnSau.setChecked(paramBoolean);
                radioDapAnTruoc.setChecked(!paramBoolean);
                break;
            default:
        }
        Log.e(Constant.TAG, CLASS_NAME + "onCheckedChanged()->end");
    }

    public void onClick(View paramView) {
        Log.e(Constant.TAG, CLASS_NAME + "onClick()->start");
        switch (paramView.getId()) {
            case R.id.radioThuTu:
            case R.id.radioNgauNhien:
            case R.id.radioDapAnTruoc:
            case R.id.radioDapAnSau:
            default:
                return;
            case R.id.tvCancelSetting:
                EventBus.getDefault().post(new OnEventOpenBuyBookDialog(OnEventOpenBuyBookDialog.SCRN_NOTHING));
                return;
            case R.id.tvBackToDefault:
                this.radioThuTu.performClick();
                this.radioDapAnTruoc.performClick();
                return;
            case R.id.tvSaveSetting:
                EventBus.getDefault().post(new OnEventOpenBuyBookDialog(OnEventOpenBuyBookDialog.SCRN_NOTHING));
                return;
            case R.id.lyThuTu:
                this.radioThuTu.performClick();
                return;
            case R.id.lyNgauNhien:
                this.radioNgauNhien.performClick();
                return;
            case R.id.lyDapAnTruoc:
                this.radioDapAnTruoc.performClick();
                return;
            case R.id.lyDapAnSau:
                this.radioDapAnSau.performClick();
                break;
        }
        Log.e(Constant.TAG, CLASS_NAME + "onClick()->end");
    }

    @Nullable
    public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle) {
        return paramLayoutInflater.inflate(R.layout.book_detail_setting_fragment, paramViewGroup, false);
    }
}