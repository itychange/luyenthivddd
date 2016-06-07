package com.lthdl.app.screen.bookdetail.event;

public class OnEventOpenBuyBookDialog {
    public static final int SCRN_BOOK_DETAIL = 6;
    public static final int SCRN_BUY_BOOK_CONFIRM = 5;
    public static final int SCRN_BUY_BOOK_FAILED = 3;
    public static final int SCRN_BUY_BOOK_SUCCESS = 4;
    public static final int SCRN_NOTHING = 0;
    public static final int SCRN_SETTING = 1;
    public static final int SCRN_SUGGEST_BUY_BOOK = 2;
    public int status = 0;

    public OnEventOpenBuyBookDialog(int paramInt) {
        this.status = paramInt;
    }
}