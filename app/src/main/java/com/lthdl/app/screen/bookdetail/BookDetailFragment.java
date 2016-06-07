package com.lthdl.app.screen.bookdetail;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.Bind;
import butterknife.OnClick;

import com.lthdl.app.BaseFragment;
import com.lthdl.app.R;
import com.lthdl.app.common.widget.taskbar.SupportBar;
import com.lthdl.app.global.Constant;
import com.lthdl.app.screen.bookdetail.api.IFlowScreen;
import com.lthdl.app.screen.bookdetail.event.OnEventOpenBuyBookDialog;

import org.greenrobot.eventbus.Subscribe;

import java.util.Iterator;

public class BookDetailFragment extends BaseFragment
        implements IFlowScreen {
    public static final String KEY_BOOK_ID = "BOOK_ID";
    public static final String CLASS_NAME = " BookDetailFragment ";

    @Bind(R.id.content)
    View content;
    String currentFragment = "";
    protected FragmentManager fragmentManager;

    @Bind(R.id.supportBar)
    SupportBar supportBar;

    protected void init(View paramView) {
        this.fragmentManager = getChildFragmentManager();
        toBookDetailScreen(null, false, false, null);
    }

    @OnClick(R.id.btnBack)
    public void onBackPress(View paramView) {
        this.supportBar.hide();
        getActivity().onBackPressed();
    }

    public boolean onBackPressed() {
        if (this.supportBar.isShow()) {
            this.supportBar.hide();
            return true;
        }
        return false;
    }

    @Nullable
    public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle) {
        setRetainInstance(true);
        return paramLayoutInflater.inflate(R.layout.book_activity, paramViewGroup, false);
    }

    @Subscribe
    public void onEvent(OnEventOpenBuyBookDialog paramOnEventOpenBuyBookDialog) {
//        Log.e(Constant.TAG, CLASS_NAME + " onEvent(OnEventOpenBuyBookDialog)->start");
//        Log.e(Constant.TAG, CLASS_NAME + " onEvent(OnEventOpenBuyBookDialog)-> status==" + paramOnEventOpenBuyBookDialog.status);
        Iterator iterator = this.fragmentManager.getFragments().iterator();
        switch (paramOnEventOpenBuyBookDialog.status) {
            case OnEventOpenBuyBookDialog.SCRN_SETTING:
//                Log.e(Constant.TAG, CLASS_NAME + " onEvent(OnEventOpenBuyBookDialog)->SCRN_SETTING");
                while (iterator.hasNext()) {
                    toSettingScreen(null, true, false, null);
                }
                return;
            case OnEventOpenBuyBookDialog.SCRN_BUY_BOOK_CONFIRM:
                toBookBuyConfirm(null, true, false, null);
                break;
            case OnEventOpenBuyBookDialog.SCRN_BUY_BOOK_FAILED:
                toBookBuyFail(null, true, false, null);
                break;
            case OnEventOpenBuyBookDialog.SCRN_BUY_BOOK_SUCCESS:
                toBookBuySuccess(null, false, false, null);
                return;
            case OnEventOpenBuyBookDialog.SCRN_SUGGEST_BUY_BOOK:
//                Log.e(Constant.TAG, CLASS_NAME + " onEvent(OnEventOpenBuyBookDialog)->SCRN_SUGGEST_BUY_BOOK");
                toSuggestBuyBook(null, false, true, null);
                break;
            case OnEventOpenBuyBookDialog.SCRN_NOTHING:
                while (iterator.hasNext()) {
                    Fragment localFragment = (Fragment) iterator.next();
                    if ((!(localFragment instanceof BookBuyConfirm)) && (!(localFragment instanceof BookSuggestByFragment)) && (!(localFragment instanceof BookBuyFailFragment)) && (!(localFragment instanceof BookBuySuccessFragment)) && (!(localFragment instanceof BookSettingFragment)))
                        continue;
                    FragmentTransaction localFragmentTransaction = this.fragmentManager.beginTransaction();
                    localFragmentTransaction.hide(localFragment);
                    localFragmentTransaction.commitAllowingStateLoss();
                }
                break;
            default:
                break;
        }
//        Log.e(Constant.TAG, CLASS_NAME + " onEvent(OnEventOpenBuyBookDialog)->end");
    }

    @OnClick(R.id.btnSupport)
    public void onSupportClick(View paramView) {
        this.supportBar.toggle();
    }

    public void toBookBuyConfirm(BaseFragment paramBaseFragment, boolean paramBoolean1, boolean paramBoolean2, Bundle paramBundle) {
        String str = BookBuyConfirm.class.getName();
        BookBuyConfirm localBookBuyConfirm = (BookBuyConfirm) this.fragmentManager.findFragmentByTag(str);
        FragmentTransaction localFragmentTransaction = this.fragmentManager.beginTransaction();
        localFragmentTransaction.setCustomAnimations(R.anim.enter_from_bottom, R.anim.exit_to_bottom, R.anim.enter_from_bottom, R.anim.exit_to_bottom);
        if (localBookBuyConfirm == null) {
            localBookBuyConfirm = new BookBuyConfirm();
            localBookBuyConfirm.setBundle(paramBundle);
            localFragmentTransaction.add(R.id.content, localBookBuyConfirm, str);
            if (paramBaseFragment != null) {
//        if (!paramBoolean1)
//          break label135;
                localFragmentTransaction.remove(paramBaseFragment);
            }
        }
        //while (true)
        {
            if (paramBoolean2)
                localFragmentTransaction.addToBackStack(str);
            localFragmentTransaction.commitAllowingStateLoss();
            this.currentFragment = str;
            //return;
            localBookBuyConfirm.setBundle(paramBundle);
            localFragmentTransaction.show(localBookBuyConfirm);
            //break;
            //label135: localFragmentTransaction.hide(paramBaseFragment);
        }
    }

    public void toBookBuyFail(BaseFragment paramBaseFragment, boolean paramBoolean1, boolean paramBoolean2, Bundle paramBundle) {
        String str = BookBuyFailFragment.class.getName();
        BookBuyFailFragment localBookBuyFailFragment = (BookBuyFailFragment) this.fragmentManager.findFragmentByTag(str);
        FragmentTransaction localFragmentTransaction = this.fragmentManager.beginTransaction();
        localFragmentTransaction.setCustomAnimations(R.anim.enter_from_bottom, R.anim.exit_to_bottom, R.anim.enter_from_bottom, R.anim.exit_to_bottom);
        if (localBookBuyFailFragment == null) {
            localBookBuyFailFragment = new BookBuyFailFragment();
            localBookBuyFailFragment.setBundle(paramBundle);
            localFragmentTransaction.add(R.id.content, localBookBuyFailFragment, str);
            if (paramBaseFragment != null) {
//        if (!paramBoolean1)
//          break label135;
                localFragmentTransaction.remove(paramBaseFragment);
            }
        }
        //while (true)
        {
            if (paramBoolean2)
                localFragmentTransaction.addToBackStack(str);
            localFragmentTransaction.commitAllowingStateLoss();
            this.currentFragment = str;
            //return;
            localBookBuyFailFragment.setBundle(paramBundle);
            localFragmentTransaction.show(localBookBuyFailFragment);
            //break;
            //label135: localFragmentTransaction.hide(paramBaseFragment);
        }
    }

    public void toBookBuySuccess(BaseFragment paramBaseFragment, boolean paramBoolean1, boolean paramBoolean2, Bundle paramBundle) {
        String str = BookBuySuccessFragment.class.getName();
        BookBuySuccessFragment localBookBuySuccessFragment = (BookBuySuccessFragment) this.fragmentManager.findFragmentByTag(str);
        FragmentTransaction localFragmentTransaction = this.fragmentManager.beginTransaction();
        localFragmentTransaction.setCustomAnimations(R.anim.enter_from_bottom, R.anim.exit_to_bottom, R.anim.enter_from_bottom, R.anim.exit_to_bottom);
        if (localBookBuySuccessFragment == null) {
            localBookBuySuccessFragment = new BookBuySuccessFragment();
            localBookBuySuccessFragment.setBundle(paramBundle);
            localFragmentTransaction.add(R.id.content, localBookBuySuccessFragment, str);
            if (paramBaseFragment != null) {
//        if (!paramBoolean1)
//          break label135;
                localFragmentTransaction.remove(paramBaseFragment);
            }
        }
        //while (true)
        {
            if (paramBoolean2)
                localFragmentTransaction.addToBackStack(str);
            localFragmentTransaction.commitAllowingStateLoss();
            this.currentFragment = str;
            //return;
            localBookBuySuccessFragment.setBundle(paramBundle);
            localFragmentTransaction.show(localBookBuySuccessFragment);
            //break;
            //label135: localFragmentTransaction.hide(paramBaseFragment);
        }
    }

    public void toBookDetailScreen(BaseFragment paramBaseFragment, boolean paramBoolean1, boolean paramBoolean2, Bundle paramBundle) {
        String str = BookDetailContentFragment.class.getName();
        BookDetailContentFragment localBookDetailContentFragment = (BookDetailContentFragment) this.fragmentManager.findFragmentByTag(str);
        FragmentTransaction localFragmentTransaction = this.fragmentManager.beginTransaction();
        if (localBookDetailContentFragment == null) {
            localBookDetailContentFragment = new BookDetailContentFragment();
            localBookDetailContentFragment.setBundle(paramBundle);
            localFragmentTransaction.add(R.id.content, localBookDetailContentFragment, str);
            if (paramBaseFragment != null) {
//        if (!paramBoolean1)
//          break label121;
                localFragmentTransaction.remove(paramBaseFragment);
            }
        }
        //while (true)
        {
            if (paramBoolean2)
                localFragmentTransaction.addToBackStack(str);
            localFragmentTransaction.commitAllowingStateLoss();
            this.currentFragment = str;
            //return;
            localBookDetailContentFragment.setBundle(paramBundle);
            localFragmentTransaction.show(localBookDetailContentFragment);
            //break;
            //label121: localFragmentTransaction.hide(paramBaseFragment);
        }
    }

    public void toSettingScreen(BaseFragment paramBaseFragment, boolean paramBoolean1, boolean paramBoolean2, Bundle paramBundle) {
//        Log.e(Constant.TAG, CLASS_NAME + " toSettingScreen()->start");
        String str = BookSettingFragment.class.getName();
        BookSettingFragment localBookSettingFragment = (BookSettingFragment) this.fragmentManager.findFragmentByTag(str);
        FragmentTransaction localFragmentTransaction = this.fragmentManager.beginTransaction();
        localFragmentTransaction.setCustomAnimations(R.anim.enter_from_bottom, R.anim.exit_to_bottom, R.anim.enter_from_bottom, R.anim.exit_to_bottom);
        if (paramBaseFragment != null) {
            if (paramBoolean1)
                localFragmentTransaction.remove(paramBaseFragment);
        } else {
            if (localBookSettingFragment != null) {
                localBookSettingFragment.setBundle(paramBundle);
                localFragmentTransaction.show(localBookSettingFragment);
            } else {
                paramBaseFragment = new BookSettingFragment();
                paramBaseFragment.setBundle(paramBundle);
                localFragmentTransaction.add(R.id.content, paramBaseFragment, str);
            }
//            paramBaseFragment = new BookSettingFragment();
//            paramBaseFragment.setBundle(paramBundle);
//            localFragmentTransaction.add(R.id.content, paramBaseFragment, str);
        }
        //while (true)
        {
            if (paramBoolean2)
                localFragmentTransaction.addToBackStack(str);
            localFragmentTransaction.commitAllowingStateLoss();
            this.currentFragment = str;
            //return;
//            localFragmentTransaction.hide(paramBaseFragment);
            //break;
            //label124: localBookSettingFragment.setBundle(paramBundle);
//            localFragmentTransaction.show(localBookSettingFragment);
        }
//        Log.e(Constant.TAG, CLASS_NAME + " toSettingScreen()->end");
    }

    public void toSuggestBuyBook(BaseFragment paramBaseFragment, boolean paramBoolean1, boolean paramBoolean2, Bundle paramBundle) {
//        Log.e(Constant.TAG, CLASS_NAME + " toSuggestBuyBook()->start");
        String str = BookSuggestByFragment.class.getName();
        BookSuggestByFragment localBookSuggestByFragment = (BookSuggestByFragment) this.fragmentManager.findFragmentByTag(str);
        FragmentTransaction localFragmentTransaction = this.fragmentManager.beginTransaction();
        localFragmentTransaction.setCustomAnimations(R.anim.enter_from_bottom, R.anim.exit_to_bottom, R.anim.enter_from_bottom, R.anim.exit_to_bottom);
        if (localBookSuggestByFragment == null) {
            localBookSuggestByFragment = new BookSuggestByFragment();
            localBookSuggestByFragment.setBundle(paramBundle);
            localFragmentTransaction.add(R.id.content, localBookSuggestByFragment, str);
            if (paramBaseFragment != null) {
//        if (!paramBoolean1)
//          break label135;
//                localFragmentTransaction.remove(paramBaseFragment);
            }
        }
        //while (true)
        {
            if (paramBoolean2)
                localFragmentTransaction.addToBackStack(str);
            localFragmentTransaction.commitAllowingStateLoss();
            this.currentFragment = str;
            //return;
            localBookSuggestByFragment.setBundle(paramBundle);
            localFragmentTransaction.show(localBookSuggestByFragment);
            //break;
            //label135: localFragmentTransaction.hide(paramBaseFragment);
        }
//        Log.e(Constant.TAG, CLASS_NAME + " toSuggestBuyBook()->end");
    }
}