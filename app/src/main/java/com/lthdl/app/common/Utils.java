package com.lthdl.app.common;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Transformation;
import android.view.inputmethod.InputMethodManager;
import android.widget.Toast;

public class Utils {
    public static void collapse(View paramView) {
    }

    public static void expand(View paramView) {
        paramView.measure(-1, -2);
        int i = paramView.getMeasuredHeight();
        paramView.getLayoutParams().height = 1;
        paramView.setVisibility(View.VISIBLE);
        // Implement later
    }

    public static void hideKeyboard(Activity paramActivity) {
        InputMethodManager localInputMethodManager = (InputMethodManager) paramActivity.getSystemService(Context.INPUT_METHOD_SERVICE);
        View localView2 = paramActivity.getCurrentFocus();
        View localView1 = localView2;
        if (localView2 == null)
            localView1 = new View(paramActivity);
        localInputMethodManager.hideSoftInputFromWindow(localView1.getWindowToken(), 0);
    }

    public static void showToast(Context paramContext, String paramString, boolean paramBoolean) {
        int i = Toast.LENGTH_SHORT;
        if (paramBoolean) {
            i = Toast.LENGTH_LONG;
        }
        Toast.makeText(paramContext, paramString, i).show();
    }
}