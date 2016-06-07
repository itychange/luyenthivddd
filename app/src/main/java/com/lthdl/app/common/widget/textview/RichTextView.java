package com.lthdl.app.common.widget.textview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.Rect;
import android.text.Html;
import android.text.Layout;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.TextView;

import com.lthdl.app.R.styleable;
import com.lthdl.app.common.DimenUtils;
import com.lthdl.app.global.Constant;

public class RichTextView extends TextView {
    public static final String CLASS_NAME = " RichTextView ";
    public static final String THREE_DOTS_STR = ".....";
    private int calibrationX = 15;
    private int calibrationY = 105;
    private final boolean debug = false;
    Point firstPoint = new Point();
    Rect firstThreeDots = new Rect();
    Paint paint = new Paint(1);
    ResourceImageGetter resourceGetter;
    Spanned sa;
    ResourceTagHandler tagHandler;

    public RichTextView(Context paramContext) {
        super(paramContext);
        init(null);
    }

    public RichTextView(Context paramContext, AttributeSet paramAttributeSet) {
        super(paramContext, paramAttributeSet);
        init(paramAttributeSet);
    }

    public RichTextView(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
        super(paramContext, paramAttributeSet, paramInt);
        init(paramAttributeSet);
    }

    private void init(AttributeSet paramAttributeSet) {
        setMovementMethod(LinkMovementMethod.getInstance());
        this.tagHandler = new ResourceTagHandler(getContext());
        this.resourceGetter = new ResourceImageGetter(getContext());
        if (paramAttributeSet != null)
            getContext().obtainStyledAttributes(paramAttributeSet, styleable.RichTextView, 0, 0).recycle();
        this.calibrationX = DimenUtils.dpToPx(getContext(), this.calibrationX);
        this.calibrationY = DimenUtils.dpToPx(getContext(), this.calibrationY);
    }

    protected void dispatchDraw(Canvas paramCanvas) {
        super.dispatchDraw(paramCanvas);
    }

    public Point getFirstPosThreeDot() {
        Log.e(Constant.TAG, CLASS_NAME + " getFirstPosThreeDot()->start");
        // Correct later
        Rect localRect = new Rect();
        SpannableString localSpannableString = (SpannableString) getText();
        Log.e(Constant.TAG, CLASS_NAME + " getFirstPosThreeDot()->localSpannableString==" + localSpannableString);
        Layout localLayout = getLayout();
        ClickableSpan[] arrayOfClickableSpan = localSpannableString.getSpans(0, localSpannableString.length(), ClickableSpan.class);
        Log.e(Constant.TAG, CLASS_NAME + " getFirstPosThreeDot()->localSpannableString==" + localSpannableString);
        ClickableSpan localClickableSpan = arrayOfClickableSpan[0];
        int j = arrayOfClickableSpan.length;
        int i = 0;
        Object localObject = localClickableSpan;
        double d3;
        double d1;
        double d2;
        if (i < j) {
            localObject = arrayOfClickableSpan[i];
            if (!THREE_DOTS_STR.equalsIgnoreCase(localSpannableString.subSequence(localSpannableString.getSpanStart(localObject), localSpannableString.getSpanEnd(localObject)).toString()))
                ;
        } else {
            d3 = localSpannableString.getSpanStart(localObject);
            double d4 = localSpannableString.getSpanEnd(localObject);
            d1 = localLayout.getPrimaryHorizontal((int) d3);
            d2 = localLayout.getPrimaryHorizontal((int) d4);
            j = localLayout.getLineForOffset((int) d3);
            if (j == localLayout.getLineForOffset((int) d4)) {
//                for (i = 1; ; i = 0)
                {
                    localLayout.getLineBounds(j, localRect);
                    localObject = new int[2];
                    localRect.top = (int) (localRect.top + d3);
                    localRect.bottom += (int) d3;
                    localRect.right = (int) (localRect.left + d2 - d1);
                    j = (localRect.left + localRect.right) / 2 - this.calibrationX;
                    int k = localRect.bottom - this.calibrationY;
                    if (i != 0)
                        j = localRect.left;
                    Log.d("TAG", "location2:" + j + "," + k);
                    return new Point(j, k);
                }
            }
        }
        return new Point();
    }

    public void setOnClickableListener(ResourceTagHandler.OnClickableListener paramOnClickableListener) {
        this.tagHandler.setOnClickableListener(paramOnClickableListener);
    }

    public void setRichText(String paramString) {
        this.sa = Html.fromHtml(paramString, this.resourceGetter, this.tagHandler);
        super.setText(this.sa);
    }

    public Spanned span() {
        return this.sa;
    }
}