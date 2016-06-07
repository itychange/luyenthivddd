package com.lthdl.app.screen.core;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;

import com.lthdl.app.BaseActivity;
import com.lthdl.app.BaseFragment;
import com.lthdl.app.R;
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
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.hide(this.fragmentHome);
        transaction.show(this.fragmentBookDetail);
        this.currentFragment = this.fragmentBookDetail;
        transaction.addToBackStack(BookDetailFragment.class.getName());
        transaction.commitAllowingStateLoss();
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
}