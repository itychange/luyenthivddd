package com.lthdl.app.common.widget.button;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.Button;

import com.lthdl.app.R.styleable;

public class CButton extends Button {
    public static Typeface typeface = null;
    public static Typeface typefaceBold = null;
    public static final int[] CEditText = new int[0];

    public CButton(Context paramContext) {
        super(paramContext);
        init(null);
    }

    public CButton(Context paramContext, AttributeSet paramAttributeSet) {
        super(paramContext, paramAttributeSet);
        init(paramAttributeSet);
    }

    public CButton(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
        super(paramContext, paramAttributeSet, paramInt);
        init(paramAttributeSet);
    }

    private void init(AttributeSet paramAttributeSet) {
        if (paramAttributeSet != null)
            getContext().obtainStyledAttributes(paramAttributeSet, CEditText);
        if (typeface == null) {
            typeface = Typeface.createFromAsset(getContext().getAssets(), "font/SourceSansPro-Regular.otf");
            typefaceBold = Typeface.createFromAsset(getContext().getAssets(), "font/SourceSansPro-Bold.otf");
        }
        setTypeface(typeface);
    }

    public void setBold() {
        setTypeface(null, 1);
    }

    public void setNormal() {
        setTypeface(null, 0);
    }

    public void setTypeface(Typeface paramTypeface) {
        int i = 0;
        if (paramTypeface != null)
            i = paramTypeface.getStyle();
        switch (i) {
            default:
                super.setTypeface(typeface);
                return;
            case 0:
                super.setTypeface(typeface);
                return;
            case 1:
        }
        super.setTypeface(typefaceBold);
    }

    public void setTypeface(Typeface paramTypeface, int paramInt) {
        //Correct later
        switch (paramInt) {
            default:
                paramTypeface = typeface;
            case 0:
            case 1:
        }
        {
            super.setTypeface(paramTypeface, paramInt);
            //return;
            paramTypeface = typeface;
            //continue;
            paramTypeface = typefaceBold;
        }
    }
}