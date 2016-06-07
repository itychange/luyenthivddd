package com.lthdl.app;

import android.content.Context;
import android.graphics.Point;
import android.support.multidex.MultiDex;
import android.support.multidex.MultiDexApplication;
import android.view.Display;
import android.view.WindowManager;

import com.activeandroid.ActiveAndroid;
import com.activeandroid.Configuration;
import com.activeandroid.Configuration.Builder;
import com.facebook.FacebookSdk;
import com.lthdl.app.global.Global;
import com.lthdl.app.model.User;

public class MainApplication extends MultiDexApplication {
    public void onCreate() {
        MultiDex.install(this);
        super.onCreate();
        ActiveAndroid.initialize(new Configuration.Builder(this).setDatabaseName("ltApp.db").setDatabaseVersion(1).create());
        FacebookSdk.sdkInitialize(getApplicationContext());
        Display localDisplay = ((WindowManager) getSystemService(Context.WINDOW_SERVICE)).getDefaultDisplay();
        Global.SCREEN = new Point();
        localDisplay.getSize(Global.SCREEN);
        Global.USER = new User();
    }
}