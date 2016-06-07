package com.lthdl.app.common.widget.textview;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.TextView;
import com.lthdl.app.R;

public class CTextView extends TextView
{
  public static Typeface typeface = null;
  public static Typeface typefaceBold = null;

  public CTextView(Context paramContext)
  {
    super(paramContext);
    init(null);
  }

  public CTextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init(paramAttributeSet);
  }

  public CTextView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    init(paramAttributeSet);
  }

  private void init(AttributeSet paramAttributeSet)
  {
//    if (paramAttributeSet != null)
//      getContext().obtainStyledAttributes(paramAttributeSet, R.styleable.CEditText);
    if (typeface == null)
    {
      typeface = Typeface.createFromAsset(getContext().getAssets(), "font/SourceSansPro-Regular.otf");
      typefaceBold = Typeface.createFromAsset(getContext().getAssets(), "font/SourceSansPro-Bold.otf");
    }
    if ("bold".equalsIgnoreCase(paramAttributeSet.getAttributeValue("http://schemas.android.com/apk/res/android", "textStyle")))
    {
      setBold();
      return;
    }
    setNormal();
  }

  public void setBold()
  {
    setTypeface(null, 1);
  }

  public void setNormal()
  {
    setTypeface(null, 0);
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
    {
      super.setTypeface(paramTypeface, paramInt);
//      return;
      //paramTypeface = typeface;
      //continue;
      paramTypeface = typefaceBold;
    }
  }
}