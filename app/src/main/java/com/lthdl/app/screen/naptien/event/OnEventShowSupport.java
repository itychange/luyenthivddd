package com.lthdl.app.screen.naptien.event;

public class OnEventShowSupport {
    public boolean isAnim = true;
    public boolean isShow = false;

    public OnEventShowSupport(boolean paramBoolean) {
        this.isShow = paramBoolean;
    }

    public OnEventShowSupport setAnim(boolean paramBoolean) {
        this.isAnim = paramBoolean;
        return this;
    }
}