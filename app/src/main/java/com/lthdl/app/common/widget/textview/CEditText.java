package com.lthdl.app.common.widget.textview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.widget.EditText;

import com.lthdl.app.R.styleable;
//import com.lthdl.app.R;

public class CEditText extends EditText
{
    public static final int[] CEditText = new int[0];
    public static Typeface typeface = null;
    public static Typeface typefaceBold = null;
    private Paint mPaint;
    private OnKeyBackListener onKeyBackListener;

  public CEditText(Context paramContext)
  {
    super(paramContext);
    init(null);
  }

  public CEditText(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init(paramAttributeSet);
  }

  public CEditText(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    init(paramAttributeSet);
  }

  private void init(AttributeSet paramAttributeSet)
  {
    if (paramAttributeSet != null)
      getContext().obtainStyledAttributes(paramAttributeSet, styleable.CEditText);
    if (typeface == null)
    {
      typeface = Typeface.createFromAsset(getContext().getAssets(), "font/SourceSansPro-Regular.otf");
      typefaceBold = Typeface.createFromAsset(getContext().getAssets(), "font/SourceSansPro-Bold.otf");
    }
    setTypeface(typeface);
    this.mPaint = new Paint();
    this.mPaint.setStyle(Style.STROKE);
    //this.mPaint.setColor(-2147483393);
  }

  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
  }

  public boolean onKeyPreIme(int paramInt, KeyEvent paramKeyEvent)
  {
    if ((paramInt == 4) && (paramKeyEvent.getAction() == 1) && (this.onKeyBackListener != null))
    {
      this.onKeyBackListener.onKeyBack();
      return false;
    }
    return super.dispatchKeyEvent(paramKeyEvent);
  }

  public void setBold()
  {
    setTypeface(null, 1);
  }

  public void setNormal()
  {
    setTypeface(null, 0);
  }

  public void setOnKeyBackListener(OnKeyBackListener paramOnKeyBackListener)
  {
    this.onKeyBackListener = paramOnKeyBackListener;
  }

  public void setTypeface(Typeface paramTypeface)
  {
    int i = 0;
    if (paramTypeface != null)
      i = paramTypeface.getStyle();
    switch (i)
    {
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

  public void setTypeface(Typeface paramTypeface, int paramInt)
  {
    switch (paramInt)
    {
        default:
          paramTypeface = typeface;
        case 0:
        case 1:
    }
    //while (true)
    {
      super.setTypeface(paramTypeface, paramInt);
      //return;
//      paramTypeface = typeface;
      //continue;
      paramTypeface = typefaceBold;
    }
  }
}