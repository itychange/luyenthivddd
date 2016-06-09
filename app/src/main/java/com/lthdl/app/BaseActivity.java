package com.lthdl.app;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import butterknife.ButterKnife;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import icepick.Icepick;

public abstract class BaseActivity extends AppCompatActivity {
    protected abstract void init();

    public void onContentChanged() {
        super.onContentChanged();
        ButterKnife.bind(this);
        init();
    }

    protected void onCreate(Bundle paramBundle) {
        super.onCreate(paramBundle);
        if (!EventBus.getDefault().isRegistered(this))
            EventBus.getDefault().register(this);
        Icepick.restoreInstanceState(this, paramBundle);
    }

    protected void onDestroy() {
        EventBus.getDefault().unregister(this);
        ButterKnife.unbind(this);
        super.onDestroy();
    }

    @Subscribe
    public void onEvent(Object paramObject) {
    }

    protected void onSaveInstanceState(Bundle paramBundle) {
        super.onSaveInstanceState(paramBundle);
        Icepick.saveInstanceState(this, paramBundle);
    }
}
