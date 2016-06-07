package com.lthdl.app.screen.home.event;

public class OnEventUpdateUI {
    public boolean isSearchShow = true;

    public OnEventUpdateUI setMenuSearchItem(boolean paramBoolean) {
        this.isSearchShow = paramBoolean;
        return this;
    }
}