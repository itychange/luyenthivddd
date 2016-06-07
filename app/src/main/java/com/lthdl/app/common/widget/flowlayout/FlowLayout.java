package com.lthdl.app.common.widget.flowlayout;

//import android.annotation.TargetApi;
//import android.content.Context;
//import android.content.res.TypedArray;
//import android.os.Build.VERSION;
//import android.util.AttributeSet;
//import android.view.Gravity;
//import android.view.View;
//import android.view.View.MeasureSpec;
//import android.view.ViewGroup;
//import android.view.ViewGroup.LayoutParams;
//import android.view.ViewGroup.MarginLayoutParams;
//
//import com.lthdl.app.R;
//import com.lthdl.app.R.styleable;
//
//import java.util.ArrayList;
//import java.util.List;
//
//@TargetApi(14)
//public class FlowLayout extends ViewGroup {
//    protected int mGravity;
//    protected final List<Integer> mLineHeights;
//    protected final List<Integer> mLineMargins;
//    protected final List<List<View>> mLines;
//
//    public FlowLayout(Context paramContext) {
//        this(paramContext, null);
//    }
//
//    public FlowLayout(Context paramContext, AttributeSet paramAttributeSet) {
//        this(paramContext, paramAttributeSet, 0);
//    }
//
//    public FlowLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
//        // Correct later
//        super(paramContext, paramAttributeSet, paramInt);
//        int i = 0;
//        if (isIcs())
//            i = 8388611;
////        while (true)
//        {
//            this.mGravity = (i | 0x30);
//            this.mLines = new ArrayList();
//            this.mLineHeights = new ArrayList();
//            this.mLineMargins = new ArrayList();
////            paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.FlowLayout, paramInt, 0);
//            try {
////                paramInt = paramContext.getInt(0, -1);
//                if (paramInt > 0)
//                    setGravity(paramInt);
////                return;
////                i = 3;
////                continue;
//            } finally {
////                paramContext.recycle();
//            }
//        }
////        throw paramAttributeSet;
//    }
//
//    private static boolean isIcs() {
//        return VERSION.SDK_INT >= 14;
//    }
//
//    protected boolean checkLayoutParams(ViewGroup.LayoutParams paramLayoutParams) {
//        return (super.checkLayoutParams(paramLayoutParams)) && ((paramLayoutParams instanceof LayoutParams));
//    }
//
//    protected LayoutParams generateDefaultLayoutParams() {
//        return new LayoutParams(-1, -1);
//    }
//
//    public LayoutParams generateLayoutParams(AttributeSet paramAttributeSet) {
//        return new LayoutParams(getContext(), paramAttributeSet);
//    }
//
//    protected LayoutParams generateLayoutParams(ViewGroup.LayoutParams paramLayoutParams) {
//        return new LayoutParams(paramLayoutParams);
//    }
//
//    public int getGravity() {
//        return this.mGravity;
//    }
//
//    protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
////        this.mLines.clear();
////        this.mLineHeights.clear();
////        this.mLineMargins.clear();
////        int n = getWidth();
////        int m = getHeight();
////        paramInt4 = getPaddingTop();
////        paramInt1 = 0;
////        paramInt3 = 0;
////        Object localObject1 = new ArrayList();
////        float f;
////        int i = 0;
//////        label98:
////        Object localObject3 = getChildAt(0);
////        switch (this.mGravity & 0x7) {
////            default:
////                f = 0.0F;
////                i = 0;
//////                if (i >= getChildCount())
//////                    break label339;
////                localObject3 = getChildAt(i);
//////                if (((View) localObject3).getVisibility() != View.GONE)
//////                    break;
////                paramInt2 = paramInt4;
////            case 1:
////            case 5:
////        }
////        Object localObject2;
////        int i4;
////        int i1;
////        int i2;
////        int i3;
////        int j;
////        int k;
//////        while (true)
////        {
////            i += 1;
////            paramInt4 = paramInt2;
//////            break label98;
////            f = 0.5F;
//////            break;
//////            f = 1.0F;
//////            break;
//////            localObject2 = (LayoutParams) ((View) localObject3).getLayoutParams();
//////            i4 = ((View) localObject3).getMeasuredWidth() + ((LayoutParams) localObject2).leftMargin + ((LayoutParams) localObject2).rightMargin;
//////            i1 = ((View) localObject3).getMeasuredHeight();
//////            i2 = ((LayoutParams) localObject2).bottomMargin;
//////            i3 = ((LayoutParams) localObject2).topMargin;
////            j = paramInt3;
////            localObject2 = localObject1;
////            k = paramInt1;
////            paramInt2 = paramInt4;
//////            if (paramInt1 + i4 > n)
////            {
////                this.mLineHeights.add(Integer.valueOf(paramInt3));
////                this.mLines.add((ArrayList) localObject1);
////                this.mLineMargins.add(Integer.valueOf((int) ((n - paramInt1) * f) + getPaddingLeft()));
////                paramInt2 = paramInt4 + paramInt3;
////                j = 0;
////                k = 0;
////                localObject2 = new ArrayList();
////            }
//////            paramInt1 = k + i4;
//////            paramInt3 = Math.max(j, i1 + i2 + i3);
////            ((List) localObject2).add(localObject3);
////            localObject1 = localObject2;
////        }
//////        label339:
////        this.mLineHeights.add(Integer.valueOf(paramInt3));
////        this.mLines.add((List) localObject1);
////        this.mLineMargins.add(Integer.valueOf((int) ((n - paramInt1) * f) + getPaddingLeft()));
////        paramInt3 = paramInt4 + paramInt3;
////        paramInt2 = 0;
////        switch (this.mGravity & 0x70) {
////            default:
////                n = this.mLines.size();
////                i = getPaddingTop();
////                paramInt4 = 0;
////            case 16:
////            case 80:
////        }
//////        while (true)
////        {
////            if (paramInt4 >= n)
////                return;
////            i1 = ((Integer) this.mLineHeights.get(paramInt4)).intValue();
////            localObject1 = (List) this.mLines.get(paramInt4);
////            k = ((Integer) this.mLineMargins.get(paramInt4)).intValue();
////            i2 = ((List) localObject1).size();
////            j = 0;
//////            while (true)
////            {
//////                if (j >= i2)
//////                    break label879;
////                localObject2 = (View) ((List) localObject1).get(j);
////                if (((View) localObject2).getVisibility() == View.GONE) {
////                    j += 1;
//////                    continue;
////                    paramInt2 = (m - paramInt3) / 2;
//////                    break;
////                    paramInt2 = m - paramInt3;
//////                    break;
////                }
////            }
////            localObject3 = (LayoutParams) ((View) localObject2).getLayoutParams();
////            if (((LayoutParams) localObject3).height == -1) {
////                paramInt3 = -2147483648;
////                m = paramInt1;
////                if (((LayoutParams) localObject3).width == -1) {
////                    paramInt3 = 1073741824;
//////                    label628:
//////                    ((View) localObject2).measure(MeasureSpec.makeMeasureSpec(m, paramInt3), MeasureSpec.makeMeasureSpec(i1 - ((LayoutParams) localObject3).topMargin - ((LayoutParams) localObject3).bottomMargin, MeasureSpec.AT_MOST));
////                }
////            } else {
////                i3 = ((View) localObject2).getMeasuredWidth();
////                i4 = ((View) localObject2).getMeasuredHeight();
////                m = 0;
////                paramInt3 = m;
////                if (Gravity.isVertical(((LayoutParams) localObject3).gravity))
////                    switch (((LayoutParams) localObject3).gravity) {
////                        default:
////                            paramInt3 = m;
////                        case 16:
////                        case 17:
////                        case 80:
////                    }
////            }
//////            while (true)
////            {
//////                ((View) localObject2).layout(((LayoutParams) localObject3).leftMargin + k, ((LayoutParams) localObject3).topMargin + i + paramInt3 + paramInt2, k + i3 + ((LayoutParams) localObject3).leftMargin, i + i4 + ((LayoutParams) localObject3).topMargin + paramInt3 + paramInt2);
//////                k += ((LayoutParams) localObject3).leftMargin + i3 + ((LayoutParams) localObject3).rightMargin;
//////                break;
//////                if (((LayoutParams) localObject3).width < 0)
//////                    break label628;
////                    paramInt3 = 1073741824;
////                m = ((LayoutParams) localObject3).width;
//////                break label628;
//////                paramInt3 = (i1 - i4 - ((LayoutParams) localObject3).topMargin - ((LayoutParams) localObject3).bottomMargin) / 2;
//////                continue;
//////                paramInt3 = i1 - i4 - ((LayoutParams) localObject3).topMargin - ((LayoutParams) localObject3).bottomMargin;
////            }
//////            label879:
////            i += i1;
////            paramInt4 += 1;
////        }
//    }
//
//    protected void onMeasure(int paramInt1, int paramInt2) {
//        super.onMeasure(paramInt1, paramInt2);
////        int i3 = MeasureSpec.getSize(paramInt1) - getPaddingLeft() - getPaddingRight();
////        int i2 = MeasureSpec.getSize(paramInt2);
////        int i11 = MeasureSpec.getMode(paramInt1);
////        int i10 = MeasureSpec.getMode(paramInt2);
////        int m = 0;
////        int i = getPaddingTop() + getPaddingBottom();
////        int i7 = 0;
////        int i5 = 0;
////        int i12 = getChildCount();
////        int i4 = 0;
////        if (i4 < i12) {
////            View localView = getChildAt(i4);
////            if (i4 == i12 - 1) ;
////            int i8;
////            int i9;
////            int j = -2147483648;;
////            int k = i3;
//////            for (int i6 = 1; ; i6 = 0)
////            {
////                int i6 = 1;//DongPT
//////                if (localView.getVisibility() != View.GONE)
//////                    break label180;
////                i8 = i7;
////                j = i;
////                i9 = i5;
////                k = m;
////                if (i6 != 0) {
////                    k = Math.max(m, i7);
////                    j = i + i5;
////                    i9 = i5;
////                    i8 = i7;
////                }
////                i4 += 1;
////                i7 = i8;
////                i = j;
////                i5 = i9;
////                m = k;
//////                break;
////            }
//////            label180:
////            measureChildWithMargins(localView, paramInt1, i7, paramInt2, i);
////            LayoutParams localLayoutParams = (LayoutParams) localView.getLayoutParams();
//////            int j = -2147483648;
//////            int k = i3;
////            int n = -2147483648;
////            int i1 = i2;
////            if (localLayoutParams.width == -1) {
////                j = MeasureSpec.AT_MOST;
////                k -= localLayoutParams.leftMargin + localLayoutParams.rightMargin;
//////                label245:
//////                if (localLayoutParams.height < 0)
//////                    break label414;
////                n = MeasureSpec.AT_MOST;
////                i1 = localLayoutParams.height;
//////                label264:
////                localView.measure(MeasureSpec.makeMeasureSpec(k, j), MeasureSpec.makeMeasureSpec(i1, n));
////                n = localView.getMeasuredWidth() + localLayoutParams.leftMargin + localLayoutParams.rightMargin;
//////                if (i7 + n <= i3)
//////                    break label428;
////                m = Math.max(m, i7);
////                i1 = i + i5;
////            }
//////            for (i = localView.getMeasuredHeight() + localLayoutParams.topMargin + localLayoutParams.bottomMargin; ; i = j)
////            {
////                i8 = n;
////                j = i1;
////                i9 = i;
////                k = m;
//////                if (i6 == 0)
//////                    break;
////                k = Math.max(m, n);
////                j = i1 + i;
////                i8 = n;
////                i9 = i;
//////                break;
//////                if (localLayoutParams.width < 0)
//////                    break label245;
////                j = MeasureSpec.AT_MOST;
////                k = localLayoutParams.width;
//////                break label245;
//////                label414:
//////                if (i10 != 0)
//////                    break label264;
////                n = 0;
////                i1 = 0;
//////                break label264;
//////                label428:
////                n = i7 + n;
////                j = Math.max(i5, localView.getMeasuredHeight() + localLayoutParams.topMargin + localLayoutParams.bottomMargin);
////                i1 = i;
////            }
////        }
////        paramInt1 = getPaddingLeft();
////        paramInt2 = getPaddingRight();
////        if (i11 == 1073741824)
//////            if (i10 != 1073741824)
//////                break label513;
//////        while (true)
////        {
////            setMeasuredDimension(i3, i2);
//////            return;
////            i3 = m + (paramInt1 + paramInt2);
//////            break;
//////            label513:
////            i2 = i;
////        }
//    }
//
//    @TargetApi(14)
//    public void setGravity(int paramInt) {
//        if (this.mGravity != paramInt) {
////            i = paramInt;
////            if ((0x800007 & paramInt) == 0)
////                if (!isIcs())
////                    break label54;
//        }
////        label54:
////        for (int i = 8388611; ; i = 3)
//        {
//            int i = 8388611; //Dongpt
//            i = paramInt | i;
//            paramInt = i;
//            if ((i & 0x70) == 0)
//                paramInt = i | 0x30;
//            this.mGravity = paramInt;
//            requestLayout();
//            return;
//        }
//    }
//
//    public static class LayoutParams extends ViewGroup.MarginLayoutParams {
//        public int gravity = -1;
//
//        public LayoutParams(int paramInt1, int paramInt2) {
//            super(paramInt1, paramInt2);
//        }
//
//        public LayoutParams(Context paramContext, AttributeSet paramAttributeSet) {
//            super(paramContext, paramAttributeSet);
//            TypedArray localTypedArray = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.FlowLayout_Layout);
//            try {
//                this.gravity = localTypedArray.getInt(0, -1);
//                return;
//            } finally {
//                localTypedArray.recycle();
//            }
////            throw paramAttributeSet;
//        }
//
//        public LayoutParams(ViewGroup.LayoutParams paramLayoutParams) {
//            super(paramLayoutParams);
//        }
//    }
//}

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;

import com.lthdl.app.R;

import java.util.ArrayList;
import java.util.List;

/**
 * FlowLayout will arrange child elements horizontally one next to another. If there is not enough
 * space for next view new line will be added.
 * <p/>
 * User: Blaz Solar
 * Date: 5/6/13
 * Time: 8:17 PM
 */
@TargetApi(Build.VERSION_CODES.ICE_CREAM_SANDWICH)
public class FlowLayout extends ViewGroup {

    private int mGravity = (isIcs() ? Gravity.START : Gravity.LEFT) | Gravity.TOP;
    //    private final List<List<View>> mLines = new ArrayList<List<View>>();
    protected final List<List<View>> mLines = new ArrayList<List<View>>();
    private final List<Integer> mLineHeights = new ArrayList<Integer>();
    private final List<Integer> mLineMargins = new ArrayList<Integer>();

    public FlowLayout(Context context) {
        this(context, null);
    }

    public FlowLayout(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public FlowLayout(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);

        TypedArray a = context.obtainStyledAttributes(attrs,
                R.styleable.FlowLayout, defStyle, 0);

        try {
            int index = a.getInt(R.styleable.FlowLayout_android_gravity, -1);
            if (index > 0) {
                setGravity(index);
            }
        } finally {
            a.recycle();
        }

    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);

        int sizeWidth = MeasureSpec.getSize(widthMeasureSpec) - getPaddingLeft() - getPaddingRight();
        int sizeHeight = MeasureSpec.getSize(heightMeasureSpec);

        int modeWidth = MeasureSpec.getMode(widthMeasureSpec);
        int modeHeight = MeasureSpec.getMode(heightMeasureSpec);

        int width = 0;
        int height = getPaddingTop() + getPaddingBottom();

        int lineWidth = 0;
        int lineHeight = 0;

        int childCount = getChildCount();

        for (int i = 0; i < childCount; i++) {

            View child = getChildAt(i);
            boolean lastChild = i == childCount - 1;

            if (child.getVisibility() == View.GONE) {

                if (lastChild) {
                    width = Math.max(width, lineWidth);
                    height += lineHeight;
                }

                continue;
            }

            measureChildWithMargins(child, widthMeasureSpec, lineWidth, heightMeasureSpec, height);

            LayoutParams lp = (LayoutParams) child.getLayoutParams();

            int childWidthMode = MeasureSpec.AT_MOST;
            int childWidthSize = sizeWidth;

            int childHeightMode = MeasureSpec.AT_MOST;
            int childHeightSize = sizeHeight;

            if (lp.width == LayoutParams.MATCH_PARENT) {
                childWidthMode = MeasureSpec.EXACTLY;
                childWidthSize -= lp.leftMargin + lp.rightMargin;
            } else if (lp.width >= 0) {
                childWidthMode = MeasureSpec.EXACTLY;
                childWidthSize = lp.width;
            }

            if (lp.height >= 0) {
                childHeightMode = MeasureSpec.EXACTLY;
                childHeightSize = lp.height;
            } else if (modeHeight == MeasureSpec.UNSPECIFIED) {
                childHeightMode = MeasureSpec.UNSPECIFIED;
                childHeightSize = 0;
            }

            child.measure(
                    MeasureSpec.makeMeasureSpec(childWidthSize, childWidthMode),
                    MeasureSpec.makeMeasureSpec(childHeightSize, childHeightMode)
            );

            int childWidth = child.getMeasuredWidth() + lp.leftMargin + lp.rightMargin;

            if (lineWidth + childWidth > sizeWidth) {

                width = Math.max(width, lineWidth);
                lineWidth = childWidth;

                height += lineHeight;
                lineHeight = child.getMeasuredHeight() + lp.topMargin + lp.bottomMargin;

            } else {
                lineWidth += childWidth;
                lineHeight = Math.max(lineHeight, child.getMeasuredHeight() + lp.topMargin + lp.bottomMargin);
            }

            if (lastChild) {
                width = Math.max(width, lineWidth);
                height += lineHeight;
            }

        }

        width += getPaddingLeft() + getPaddingRight();

        setMeasuredDimension(
                (modeWidth == MeasureSpec.EXACTLY) ? sizeWidth : width,
                (modeHeight == MeasureSpec.EXACTLY) ? sizeHeight : height);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {

        mLines.clear();
        mLineHeights.clear();
        mLineMargins.clear();

        int width = getWidth();
        int height = getHeight();

        int linesSum = getPaddingTop();

        int lineWidth = 0;
        int lineHeight = 0;
        List<View> lineViews = new ArrayList<View>();

        float horizontalGravityFactor;
        switch ((mGravity & Gravity.HORIZONTAL_GRAVITY_MASK)) {
            case Gravity.LEFT:
            default:
                horizontalGravityFactor = 0;
                break;
            case Gravity.CENTER_HORIZONTAL:
                horizontalGravityFactor = .5f;
                break;
            case Gravity.RIGHT:
                horizontalGravityFactor = 1;
                break;
        }

        for (int i = 0; i < getChildCount(); i++) {

            View child = getChildAt(i);

            if (child.getVisibility() == View.GONE) {
                continue;
            }

            LayoutParams lp = (LayoutParams) child.getLayoutParams();

            int childWidth = child.getMeasuredWidth() + lp.leftMargin + lp.rightMargin;
            int childHeight = child.getMeasuredHeight() + lp.bottomMargin + lp.topMargin;

            if (lineWidth + childWidth > width) {
                mLineHeights.add(lineHeight);
                mLines.add(lineViews);
                mLineMargins.add((int) ((width - lineWidth) * horizontalGravityFactor) + getPaddingLeft());

                linesSum += lineHeight;

                lineHeight = 0;
                lineWidth = 0;
                lineViews = new ArrayList<View>();
            }

            lineWidth += childWidth;
            lineHeight = Math.max(lineHeight, childHeight);
            lineViews.add(child);
        }

        mLineHeights.add(lineHeight);
        mLines.add(lineViews);
        mLineMargins.add((int) ((width - lineWidth) * horizontalGravityFactor) + getPaddingLeft());

        linesSum += lineHeight;

        int verticalGravityMargin = 0;
        switch ((mGravity & Gravity.VERTICAL_GRAVITY_MASK)) {
            case Gravity.TOP:
            default:
                break;
            case Gravity.CENTER_VERTICAL:
                verticalGravityMargin = (height - linesSum) / 2;
                break;
            case Gravity.BOTTOM:
                verticalGravityMargin = height - linesSum;
                break;
        }

        int numLines = mLines.size();

        int left;
        int top = getPaddingTop();

        for (int i = 0; i < numLines; i++) {

            lineHeight = mLineHeights.get(i);
            lineViews = mLines.get(i);
            left = mLineMargins.get(i);

            int children = lineViews.size();

            for (int j = 0; j < children; j++) {

                View child = lineViews.get(j);

                if (child.getVisibility() == View.GONE) {
                    continue;
                }

                LayoutParams lp = (LayoutParams) child.getLayoutParams();

                // if height is match_parent we need to remeasure child to line height
                if (lp.height == LayoutParams.MATCH_PARENT) {
                    int childWidthMode = MeasureSpec.AT_MOST;
                    int childWidthSize = lineWidth;

                    if (lp.width == LayoutParams.MATCH_PARENT) {
                        childWidthMode = MeasureSpec.EXACTLY;
                    } else if (lp.width >= 0) {
                        childWidthMode = MeasureSpec.EXACTLY;
                        childWidthSize = lp.width;
                    }

                    child.measure(
                            MeasureSpec.makeMeasureSpec(childWidthSize, childWidthMode),
                            MeasureSpec.makeMeasureSpec(lineHeight - lp.topMargin - lp.bottomMargin, MeasureSpec.EXACTLY)
                    );
                }

                int childWidth = child.getMeasuredWidth();
                int childHeight = child.getMeasuredHeight();

                int gravityMargin = 0;

                if (Gravity.isVertical(lp.gravity)) {
                    switch (lp.gravity) {
                        case Gravity.TOP:
                        default:
                            break;
                        case Gravity.CENTER_VERTICAL:
                        case Gravity.CENTER:
                            gravityMargin = (lineHeight - childHeight - lp.topMargin - lp.bottomMargin) / 2;
                            break;
                        case Gravity.BOTTOM:
                            gravityMargin = lineHeight - childHeight - lp.topMargin - lp.bottomMargin;
                            break;
                    }
                }

                child.layout(left + lp.leftMargin,
                        top + lp.topMargin + gravityMargin + verticalGravityMargin,
                        left + childWidth + lp.leftMargin,
                        top + childHeight + lp.topMargin + gravityMargin + verticalGravityMargin);

                left += childWidth + lp.leftMargin + lp.rightMargin;

            }

            top += lineHeight;
        }

    }

    @Override
    protected LayoutParams generateLayoutParams(ViewGroup.LayoutParams p) {
        return new LayoutParams(p);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public LayoutParams generateLayoutParams(AttributeSet attrs) {
        return new LayoutParams(getContext(), attrs);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT);
    }

    @Override
    protected boolean checkLayoutParams(ViewGroup.LayoutParams p) {
        return super.checkLayoutParams(p) && p instanceof LayoutParams;
    }

    @TargetApi(Build.VERSION_CODES.ICE_CREAM_SANDWICH)
    public void setGravity(int gravity) {
        if (mGravity != gravity) {
            if ((gravity & Gravity.RELATIVE_HORIZONTAL_GRAVITY_MASK) == 0) {
                gravity |= isIcs() ? Gravity.START : Gravity.LEFT;
            }

            if ((gravity & Gravity.VERTICAL_GRAVITY_MASK) == 0) {
                gravity |= Gravity.TOP;
            }

            mGravity = gravity;
            requestLayout();
        }
    }

    public int getGravity() {
        return mGravity;
    }

    /**
     * @return <code>true</code> if device is running ICS or grater version of Android.
     */
    private static boolean isIcs() {
        return Build.VERSION.SDK_INT >= Build.VERSION_CODES.ICE_CREAM_SANDWICH;
    }

    public static class LayoutParams extends MarginLayoutParams {

        public int gravity = -1;

        public LayoutParams(Context c, AttributeSet attrs) {
            super(c, attrs);

            TypedArray a = c.obtainStyledAttributes(attrs, R.styleable.FlowLayout_Layout);

            try {
                gravity = a.getInt(R.styleable.FlowLayout_Layout_android_layout_gravity, -1);
            } finally {
                a.recycle();
            }
        }

        public LayoutParams(int width, int height) {
            super(width, height);
        }

        public LayoutParams(ViewGroup.LayoutParams source) {
            super(source);
        }

    }
}
