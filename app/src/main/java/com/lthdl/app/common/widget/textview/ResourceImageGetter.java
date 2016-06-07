package com.lthdl.app.common.widget.textview;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.Html.ImageGetter;

import com.lthdl.app.R;

public class ResourceImageGetter
        implements ImageGetter {
    private final Context context;

    public ResourceImageGetter(Context paramContext) {
        this.context = paramContext;
    }

    public Drawable getDrawable(String paramString) {
        Drawable localDrawable;
        if (paramString.startsWith("icon_info/")) {
            localDrawable = this.context.getResources().getDrawable(R.drawable.icon_info);
            localDrawable.setBounds(10, 10, localDrawable.getIntrinsicWidth() / 3, localDrawable.getIntrinsicHeight() / 3);
            return localDrawable;
        }else if (paramString.startsWith("icon_fomular/")) {
            localDrawable = this.context.getResources().getDrawable(R.drawable.icon_fomular);
             localDrawable.setBounds(0, 0, 600, 180);
            return localDrawable;
        } else {
            return null;
        }
    }
}