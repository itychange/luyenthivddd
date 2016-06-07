package com.lthdl.app.common;

import android.support.annotation.IntDef;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public class EventBusBase {
    public Object data;
    public String from;
    public int type;
    public static final int SUBCHAPTER_CONTENT_CLICKED = 0;
    public static final int SUBCHAPTER_SETTING_CLICKED = 1;

    @IntDef({SUBCHAPTER_CONTENT_CLICKED, SUBCHAPTER_SETTING_CLICKED})
    @Retention(RetentionPolicy.SOURCE)
    public @interface TYPE {
    }

    public EventBusBase() {
    }

    public EventBusBase(@TYPE int paramTYPE) {
        this.type = paramTYPE;
    }

    public EventBusBase(Object paramObject, String paramString, @TYPE int paramTYPE) {
        this.data = paramObject;
        this.from = paramString;
        this.type = paramTYPE;
    }
}