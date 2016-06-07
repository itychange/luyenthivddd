package com.lthdl.app.common.widget.textview;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import butterknife.Bind;
import butterknife.ButterKnife;

import com.lthdl.app.R;
import com.lthdl.app.R.styleable;

public class TextViewTag extends LinearLayout {
    private boolean isShow = true;
    public static final int[] TextViewTag = {2130772154, 2130772155};

    @Bind(R.id.tvTag)
    TextView tvTag;

    @Bind(R.id.tvTagDummy)
    TextView tvTagDummy;

    public TextViewTag(Context paramContext) {
        super(paramContext);
        init(null);
    }

    public TextViewTag(Context paramContext, AttributeSet paramAttributeSet) {
        super(paramContext, paramAttributeSet);
        init(paramAttributeSet);
    }

    public TextViewTag(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
        super(paramContext, paramAttributeSet, paramInt);
        init(paramAttributeSet);
    }

    private void init(AttributeSet paramAttributeSet) {
        TypedArray localTypedArray = null;
        LayoutInflater.from(getContext()).inflate(R.layout.view_layout_tag, this, true);
        ButterKnife.bind(this);
        if (paramAttributeSet != null) {
            localTypedArray = getContext().obtainStyledAttributes(paramAttributeSet, TextViewTag, 0, 0);
        }
        if (localTypedArray != null) {
            try {
                setText(localTypedArray.getString(0));
                this.isShow = localTypedArray.getBoolean(1, true);
                setVisible(this.isShow);
                return;
            } finally {
                localTypedArray.recycle();
            }
        }
//        throw ;
    }

    public String getText() {
        return this.tvTag.getText().toString();
    }

    public boolean isVisible() {
        return this.isShow;
    }

    public TextViewTag setText(String paramString) {
        this.tvTag.setText(paramString);
        this.tvTagDummy.setText(paramString);
        return this;
    }

    public void setVisible(boolean paramBoolean) {
        this.isShow = paramBoolean;
        if (paramBoolean) {
            this.tvTag.setVisibility(View.VISIBLE);
            return;
        }
        this.tvTag.setVisibility(View.INVISIBLE);
    }
}