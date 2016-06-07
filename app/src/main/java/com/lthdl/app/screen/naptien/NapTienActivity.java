package com.lthdl.app.screen.naptien;

import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import com.h6ah4i.android.widget.advrecyclerview.animator.RefactoredDefaultItemAnimator;
import com.h6ah4i.android.widget.advrecyclerview.expandable.RecyclerViewExpandableItemManager;
import com.lthdl.app.BaseActivity;
import com.lthdl.app.R;
import com.lthdl.app.common.widget.anim.OnBaseAnimationListener;
import com.lthdl.app.global.Constant;
import com.lthdl.app.screen.naptien.adapter.NapTienAdapter;
import com.lthdl.app.screen.naptien.event.OnEventShowSupport;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import butterknife.Bind;
import butterknife.OnClick;
import butterknife.OnTouch;

public class NapTienActivity extends BaseActivity
        implements RecyclerViewExpandableItemManager.OnGroupExpandListener {
    public static final String CLASS_NAME = " NapTienActivity ";
    NapTienAdapter adapter;

    @Bind(R.id.layoutSupport)
    View layoutSupport;
    private RecyclerViewExpandableItemManager mRecyclerViewExpandableItemManager;
    RecyclerView.Adapter mWrappedAdapter;

    @Bind(R.id.rcvNapTien)
    RecyclerView rcvNapTien;

    protected void init() {
        this.mRecyclerViewExpandableItemManager = new RecyclerViewExpandableItemManager(null);
        this.adapter = new NapTienAdapter();
        this.mWrappedAdapter = this.mRecyclerViewExpandableItemManager.createWrappedAdapter(this.adapter);
        RefactoredDefaultItemAnimator localRefactoredDefaultItemAnimator = new RefactoredDefaultItemAnimator();
        localRefactoredDefaultItemAnimator.setSupportsChangeAnimations(false);
        LinearLayoutManager localLinearLayoutManager = new LinearLayoutManager(getBaseContext());
        this.rcvNapTien.setLayoutManager(localLinearLayoutManager);
        this.rcvNapTien.setAdapter(this.mWrappedAdapter);
        this.rcvNapTien.setItemAnimator(localRefactoredDefaultItemAnimator);
        this.rcvNapTien.setHasFixedSize(false);
        this.mRecyclerViewExpandableItemManager.attachRecyclerView(this.rcvNapTien);
        this.mRecyclerViewExpandableItemManager.collapseAll();
        this.mRecyclerViewExpandableItemManager.setOnGroupExpandListener(this);
        EventBus.getDefault().post(new OnEventShowSupport(false).setAnim(false));
    }

    protected void onCreate(Bundle paramBundle) {
        super.onCreate(paramBundle);
        setContentView(R.layout.naptien_activity);
        setSupportActionBar((Toolbar) findViewById(R.id.toolbar));
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_action_icon_arrowleft);
    }

    public boolean onCreateOptionsMenu(Menu paramMenu) {
        getMenuInflater().inflate(R.menu.bookdetail, paramMenu);
        return true;
    }

    @Subscribe
    public void onEvent(OnEventShowSupport paramOnEventShowSupport) {
        Log.e(Constant.TAG, CLASS_NAME + " onEvent()-> start");
        Log.e(Constant.TAG, CLASS_NAME + " onEvent()->isAnim == " + paramOnEventShowSupport.isAnim + " isShow== " + paramOnEventShowSupport.isShow);
        if (paramOnEventShowSupport.isAnim) {
            this.layoutSupport.setVisibility(View.VISIBLE);
            OnBaseAnimationListener localOnBaseAnimationListener = new OnBaseAnimationListener() {
                public void onAnimationEnd(Animation paramAnimation) {
//                    for (int i = View.VISIBLE; ; i = View.GONE) {
//                        NapTienActivity.this.layoutSupport.setVisibility(i);
//                        return;
//                    }
                }
            };
            if (paramOnEventShowSupport.isShow) {
                Animation localAnimation;
//                for (localAnimation = AnimationUtils.loadAnimation(this, R.anim.enter_from_bottom); ; localAnimation = AnimationUtils.loadAnimation(this, R.anim.exit_to_bottom)) {
//                    localAnimation.setAnimationListener(localOnBaseAnimationListener);
//                    this.layoutSupport.startAnimation(localAnimation);
//                    return;
//                }
            }
        }
        if (!paramOnEventShowSupport.isShow) {
            this.layoutSupport.setVisibility(View.INVISIBLE);
        }
        Log.e(Constant.TAG, CLASS_NAME + " onEvent()-> end");
    }

    public void onGroupExpand(int paramInt, boolean paramBoolean) {
        final int groupPosition = paramInt;
        this.rcvNapTien.postDelayed(new Runnable() {
            public void run() {
                int i = 0;
                while (i < NapTienActivity.this.adapter.getGroupCount()) {
                    if (i != groupPosition)
                        NapTienActivity.this.mRecyclerViewExpandableItemManager.collapseGroup(i);
                    i += 1;
                }
            }
        }
                , 20L);
    }

    @OnClick(R.id.btnOk)
    public void onOkClick(View paramView) {
        EventBus.getDefault().post(new OnEventShowSupport(false));
    }

    public boolean onOptionsItemSelected(MenuItem paramMenuItem) {
        int i = paramMenuItem.getItemId();
        if (i == R.id.menuSupport) {
            Snackbar.make(this.rcvNapTien, "Support Clicked", Snackbar.LENGTH_SHORT).show();
            return true;
        }
        if (i == android.R.id.home) {
            finish();
        }
        return super.onOptionsItemSelected(paramMenuItem);
    }

    public void onSupportClick(View paramView) {
        EventBus.getDefault().post(new OnEventShowSupport(true));
    }

    @OnTouch(R.id.layoutSupport)
    public boolean onSupportTouch(View paramView, MotionEvent paramMotionEvent) {
        return true;
    }
}