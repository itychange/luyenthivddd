package com.lthdl.app.screen.bookdetail.event;

public class OnEventOpenBookDetailActivity {
    public String bookId;
    public String user_buy;

    public OnEventOpenBookDetailActivity(String paramString) {
        this.bookId = paramString;
    }
    public OnEventOpenBookDetailActivity(String paramString,String paramsUserBuy) {
        this.bookId = paramString;
        this.user_buy=paramsUserBuy;
    }
}