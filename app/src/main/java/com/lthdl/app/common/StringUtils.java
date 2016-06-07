package com.lthdl.app.common;

import android.content.Context;
import android.content.res.Resources;
import android.text.Html;

public class StringUtils {
    public static int countMatch(String paramString1, String paramString2) {
        int i = 0;
        int j = 0;
        while (i != -1) {
            int k = paramString1.indexOf(paramString2, i);
            i = k;
            if (k == -1)
                continue;
            j += 1;
            i = k + paramString2.length();
        }
        return j;
    }

    public static String getStringFromResouce(Context paramContext, int paramInt) {
        return paramContext.getResources().getString(paramInt);
    }

    public static CharSequence stripHtml(String paramString) {
        return Html.fromHtml(paramString).toString().replace('\n', ' ').replace(' ', ' ').replace('\uFFFC'/*65532*/, ' ').trim();
    }
}