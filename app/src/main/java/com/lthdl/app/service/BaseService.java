package com.lthdl.app.service;

import android.app.IntentService;
import android.content.Intent;

public abstract class BaseService extends IntentService {
    public BaseService(String paramString) {
        super(paramString);
    }

    protected void onHandleIntent(Intent paramIntent) {
    }
}