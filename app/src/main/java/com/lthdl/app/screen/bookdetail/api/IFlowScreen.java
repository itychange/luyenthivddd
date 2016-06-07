package com.lthdl.app.screen.bookdetail.api;

import android.os.Bundle;

import com.lthdl.app.BaseFragment;

public abstract interface IFlowScreen {
    public abstract void toBookBuyConfirm(BaseFragment paramBaseFragment, boolean paramBoolean1, boolean paramBoolean2, Bundle paramBundle);

    public abstract void toBookBuyFail(BaseFragment paramBaseFragment, boolean paramBoolean1, boolean paramBoolean2, Bundle paramBundle);

    public abstract void toBookBuySuccess(BaseFragment paramBaseFragment, boolean paramBoolean1, boolean paramBoolean2, Bundle paramBundle);

    public abstract void toBookDetailScreen(BaseFragment paramBaseFragment, boolean paramBoolean1, boolean paramBoolean2, Bundle paramBundle);

    public abstract void toSettingScreen(BaseFragment paramBaseFragment, boolean paramBoolean1, boolean paramBoolean2, Bundle paramBundle);

    public abstract void toSuggestBuyBook(BaseFragment paramBaseFragment, boolean paramBoolean1, boolean paramBoolean2, Bundle paramBundle);
}