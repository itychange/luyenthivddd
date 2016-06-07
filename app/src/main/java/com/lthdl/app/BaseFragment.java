package com.lthdl.app;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.res.AssetManager;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.Toolbar;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import java.lang.reflect.Field;

import butterknife.ButterKnife;

public abstract class BaseFragment extends Fragment {
    protected FragmentManager fragmentManager;

    public void finish() {
        getActivity().finish();
    }

    public AssetManager getAssets() {
        return getActivity().getAssets();
    }

    public ComponentName getComponentName() {
        return getActivity().getComponentName();
    }

    public MenuInflater getMenuInflater() {
        return getActivity().getMenuInflater();
    }

    public ActionBar getSupportActionBar() {
        return ((BaseActivity) getActivity()).getSupportActionBar();
    }

    public FragmentManager getSupportFragmentManager() {
        return ((BaseActivity) getActivity()).getSupportFragmentManager();
    }

    public Object getSystemService(String paramString) {
        return getActivity().getSystemService(paramString);
    }

    protected abstract void init(View paramView);

    @SuppressWarnings("deprecation")
    @Override
    public void onAttach(Activity paramActivity) {
        super.onAttach(paramActivity);
        //For android API < 23.
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.M) {
            this.fragmentManager = getActivity().getSupportFragmentManager();
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        // For android API 23.
        this.fragmentManager = getActivity().getSupportFragmentManager();
    }

    public boolean onBackPressed() {
        return false;
    }

    public void onCreate(@Nullable Bundle paramBundle) {
        super.onCreate(paramBundle);
        if (!EventBus.getDefault().isRegistered(this))
            EventBus.getDefault().register(this);
    }

    public boolean onCreateOptionsMenu(Menu paramMenu) {
        return false;
    }

    public void onDestroy() {
        EventBus.getDefault().unregister(this);
        super.onDestroy();
    }

    public void onDetach() {
        super.onDetach();
        IllegalAccessException localIllegalAccessException1 = null;
        try {
            Field localField = Fragment.class.getDeclaredField("mChildFragmentManager");
            localField.setAccessible(true);
            localField.set(this, null);
            return;
        } catch (NoSuchFieldException localNoSuchFieldException) {
            throw new RuntimeException(localNoSuchFieldException);
        } catch (IllegalAccessException localIllegalAccessException) {
        }
        throw new RuntimeException(localIllegalAccessException1);
    }

    @Subscribe
    public void onEvent(Object paramObject) {
    }

    public boolean onHardwareKeyDown(int paramInt, KeyEvent paramKeyEvent) {
        return false;
    }

    public void onHiddenChanged(boolean paramBoolean) {
        super.onHiddenChanged(paramBoolean);
    }

    public boolean onKeyBack() {
        return false;
    }

    public void onViewCreated(View paramView, @Nullable Bundle paramBundle) {
        super.onViewCreated(paramView, paramBundle);
        ButterKnife.bind(this, paramView);
        init(paramView);
    }

    public void setBundle(Bundle paramBundle) {
    }

    public void setSupportActionBar(Toolbar paramToolbar) {
        ((BaseActivity) getActivity()).setSupportActionBar(paramToolbar);
    }
}
