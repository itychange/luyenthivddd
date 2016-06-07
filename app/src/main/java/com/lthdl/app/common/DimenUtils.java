package com.lthdl.app.common;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.util.TypedValue;

public class DimenUtils {
    public static float dpToPx(Context paramContext, float paramFloat) {
        return TypedValue.applyDimension(1, paramFloat, paramContext.getResources().getDisplayMetrics());
    }

    public static int dpToPx(Context paramContext, int paramInt) {
        return Math.round(paramInt * (paramContext.getResources().getDisplayMetrics().xdpi / 160.0F));
    }

    public static float pxToDp(float paramFloat) {
        return Math.round(paramFloat / (Resources.getSystem().getDisplayMetrics().densityDpi / 160.0F));
    }

    public static int pxToDp(int paramInt) {
        return Math.round(paramInt / (Resources.getSystem().getDisplayMetrics().xdpi / 160.0F));
    }
}