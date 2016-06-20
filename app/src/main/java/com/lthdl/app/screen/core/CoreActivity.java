package com.lthdl.app.screen.core;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.lthdl.app.BaseActivity;
import com.lthdl.app.BaseFragment;
import com.lthdl.app.R;
import com.lthdl.app.common.widget.textview.CTextView;
import com.lthdl.app.global.Constant;
import com.lthdl.app.screen.bookdetail.BookDetailFragment;
import com.lthdl.app.screen.bookdetail.event.OnEventOpenBookDetailActivity;
import com.lthdl.app.screen.home.HomeFragment;
import com.lthdl.app.screen.home.event.OnEventOpenHomeActivity;
import com.lthdl.app.screen.login.LoginActivity;
import com.lthdl.app.screen.login.event.OnEventOpenLoginActivity;
import com.lthdl.app.screen.naptien.NapTienActivity;
import com.lthdl.app.screen.naptien.event.OnEventOpenNapTienActivity;
import com.lthdl.app.screen.questions.QuestionActivity;
import com.lthdl.app.screen.questions.event.OnEventOpenQuestionActivity;

import org.greenrobot.eventbus.Subscribe;

public class CoreActivity extends BaseActivity {
    public static final String CLASS_NAME = " CoreActivity ";
    BaseFragment currentFragment = null;
    BookDetailFragment fragmentBookDetail;
    HomeFragment fragmentHome;

    protected void init() {
//        if (Global.isLoggedIn()) {
            this.fragmentHome = new HomeFragment();
            this.fragmentBookDetail = new BookDetailFragment();
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            transaction.add(R.id.container, this.fragmentHome);
            transaction.add(R.id.container, this.fragmentBookDetail);
            this.currentFragment = this.fragmentHome;
            transaction.hide(this.fragmentBookDetail);
            transaction.commitAllowingStateLoss();
//        }
    }

    public void onBackPressed() {
        Object localObject = getSupportFragmentManager();
        int i = ((FragmentManager) localObject).getBackStackEntryCount();
        if (i == 0)
            this.currentFragment = this.fragmentHome;
        while ((this.currentFragment != null) && (this.currentFragment.onBackPressed())) {
            if (i <= 0) {
                finish();
                break;
            }
            localObject = ((FragmentManager) localObject).getBackStackEntryAt(i - 1).getName();
            if (!BookDetailFragment.class.getName().equalsIgnoreCase((String) localObject))
                continue;
            this.currentFragment = this.fragmentBookDetail;
        }
        super.onBackPressed();
    }

    protected void onCreate(Bundle paramBundle) {
        super.onCreate(paramBundle);
        Log.e(Constant.TAG, CLASS_NAME + "onCreate()->start");
//        if(Global.isLoggedIn()){
        setContentView(R.layout.core_activity);
//        } else {
//            EventBus.getDefault().post(new OnEventOpenLoginActivity());
//        }
    }

    @Subscribe
    public void onEvent(OnEventOpenBookDetailActivity paramOnEventOpenBookDetailActivity) {
        if(paramOnEventOpenBookDetailActivity.user_buy.equals("0")){
            openBottomSheet();
        }else {
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            transaction.hide(this.fragmentHome);
            transaction.show(this.fragmentBookDetail);
            this.currentFragment = this.fragmentBookDetail;
            transaction.addToBackStack(BookDetailFragment.class.getName());
            transaction.commitAllowingStateLoss();
        }
    }

    @Subscribe
    public void onEvent(OnEventOpenHomeActivity paramOnEventOpenHomeActivity) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.hide(this.fragmentBookDetail);
        transaction.show(this.fragmentHome);
        this.currentFragment = this.fragmentHome;
        transaction.commitAllowingStateLoss();
    }

    @Subscribe
    public void onEvent(OnEventOpenLoginActivity paramOnEventOpenLoginActivity) {
        startActivity(new Intent(this, LoginActivity.class));
    }

    @Subscribe
    public void onEvent(OnEventOpenNapTienActivity paramOnEventOpenNapTienActivity) {
        startActivity(new Intent(this, NapTienActivity.class));
    }

    @Subscribe
    public void onEvent(OnEventOpenQuestionActivity paramOnEventOpenQuestionActivity) {
        Intent intent = new Intent(this, QuestionActivity.class);
        intent.putExtra("question_type", 2);
        startActivity(intent);
    }
    public void openBottomSheet () {

        View view = getLayoutInflater ().inflate (R.layout.bottom_sheet, null);
        CTextView btn_desau = (CTextView)view.findViewById( R.id.btn_desau);
        CTextView btn_muangay = (CTextView)view.findViewById( R.id.btn_muangay);

        final Dialog mBottomSheetDialog = new Dialog (this, R.style.MaterialDialogSheet);
        mBottomSheetDialog.setContentView (view);
        mBottomSheetDialog.setCancelable (true);
        mBottomSheetDialog.getWindow ().setLayout (LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        mBottomSheetDialog.getWindow ().setGravity (Gravity.BOTTOM);
        mBottomSheetDialog.show ();

        btn_desau.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Toast.makeText(CoreActivity.this,"btn_desau",Toast.LENGTH_SHORT).show();
                mBottomSheetDialog.dismiss();
            }
        });

        btn_muangay.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Toast.makeText(CoreActivity.this,"btn_muangay",Toast.LENGTH_SHORT).show();
                mBottomSheetDialog.dismiss();
                openMuaHetTien();
            }
        });

    }
    public void openMuaHetTien () {
        View view = getLayoutInflater ().inflate (R.layout.view_item_mua_het_cmn_tien, null);
        CTextView btn_huy = (CTextView)view.findViewById( R.id.huy);
        TextView navNapThem= (TextView) view.findViewById(R.id.navNapThem);
        final Dialog mMuahettien = new Dialog (this, R.style.MaterialDialogSheet);
        mMuahettien.setContentView (view);
        mMuahettien.setCancelable (true);
        mMuahettien.getWindow ().setLayout (LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        mMuahettien.getWindow ().setGravity (Gravity.BOTTOM);
        mMuahettien.show ();
        btn_huy.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Toast.makeText(CoreActivity.this,"Huy",Toast.LENGTH_SHORT).show();
                mMuahettien.dismiss();
            }
        });

    }
}