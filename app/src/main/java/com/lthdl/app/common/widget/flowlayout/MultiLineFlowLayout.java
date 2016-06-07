package com.lthdl.app.common.widget.flowlayout;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.os.Build;

import com.lthdl.app.R;
import com.lthdl.app.R.styleable;
import com.lthdl.app.common.DimenUtils;

import java.util.List;
//import com.wefika.flowlayout.FlowLayout;

@TargetApi(Build.VERSION_CODES.JELLY_BEAN)
public class MultiLineFlowLayout extends FlowLayout {
    private int dividerColor = 0;
    private int dividerHeight = 2;
    private int itemHeight = 70;
    private int itemMargin = 20;
    private Paint mPaint;
    private Rect mRect;
    private int minLines = 3;

    public MultiLineFlowLayout(Context paramContext) {
        super(paramContext);
        init(null);
    }

    public MultiLineFlowLayout(Context paramContext, AttributeSet paramAttributeSet) {
        super(paramContext, paramAttributeSet);
        init(paramAttributeSet);
    }

    public MultiLineFlowLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
        super(paramContext, paramAttributeSet, paramInt);
        init(paramAttributeSet);
    }

    private void init(AttributeSet paramAttributeSet) {
        this.itemMargin = DimenUtils.dpToPx(getContext(), this.itemMargin);
        this.itemHeight = DimenUtils.dpToPx(getContext(), this.itemHeight);
        if (paramAttributeSet != null) {
            TypedArray localTypedArray  = getContext().obtainStyledAttributes(paramAttributeSet, R.styleable.MultiLineFlowLayout, 0, 0);
            this.itemMargin = localTypedArray.getDimensionPixelSize(2, this.itemMargin);
            this.dividerColor = localTypedArray.getColor(3, this.dividerColor);
            this.dividerHeight = localTypedArray.getDimensionPixelSize(4, this.dividerHeight);
            this.itemHeight = localTypedArray.getDimensionPixelSize(0, this.itemHeight);
            this.minLines = localTypedArray.getInteger(1, this.minLines);
            localTypedArray.recycle();
        }
        this.mRect = new Rect();
        this.mPaint = new Paint();
        this.mPaint.setStyle(Style.FILL);
        this.mPaint.setColor(this.dividerColor);
    }

    protected void dispatchDraw(Canvas paramCanvas) {
        int j = getLineCount();
        Rect localRect = this.mRect;
        Paint localPaint = this.mPaint;
        int i = 0;
        while (i < j) {
            getLineBounds(i, localRect);
            paramCanvas.drawRect(localRect, localPaint);
            i += 1;
        }
        super.dispatchDraw(paramCanvas);
    }

    public int getLineBounds(int paramInt, Rect paramRect) {
        paramInt = this.itemHeight * (paramInt + 1) - this.itemMargin;
        paramRect.left = 0;
        paramRect.right = getMeasuredWidth();
        paramRect.top = (paramInt - 3);
        paramRect.bottom = (this.dividerHeight + paramInt - 3);
        return paramInt;
    }

    public int getLineCount() {
        return Math.max(this.minLines, this.mLines.size());
    }

    protected void onMeasure(int paramInt1, int paramInt2) {
        super.onMeasure(paramInt1, paramInt2);
        setMeasuredDimension(paramInt1, resolveSize(getMinimumHeight(), paramInt2));
    }
}