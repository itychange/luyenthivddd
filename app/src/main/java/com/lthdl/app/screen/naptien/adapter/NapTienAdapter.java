package com.lthdl.app.screen.naptien.adapter;

import android.support.annotation.IntDef;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.h6ah4i.android.widget.advrecyclerview.utils.AbstractExpandableItemAdapter;
import com.lthdl.app.R;
import com.lthdl.app.screen.naptien.holder.GroupNapTienHolder;
import com.lthdl.app.screen.naptien.holder.ItemNapTienHolder;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public class NapTienAdapter extends AbstractExpandableItemAdapter<GroupNapTienHolder, ItemNapTienHolder> {
    public static final String TAG = "com.lthdl.app";
    public static final int PROFILE = 0;
    public static final int THE_DIEN_THOAI = 1;
    public static final int NGAN_HANG = 2;
    public static final int CHUYEN_ONLINE = 3;
    public static final int HO_TRO = 4;

    @IntDef({PROFILE, THE_DIEN_THOAI, NGAN_HANG, CHUYEN_ONLINE, HO_TRO})
    @Retention(RetentionPolicy.SOURCE)
    public @interface NapTienType {
    }

    public NapTienAdapter() {
        setHasStableIds(true);
    }

    public int getChildCount(int paramInt) {
        Log.e(TAG, "getChildCount()->[paramInt = ]" + paramInt);
        switch (paramInt) {
            default:
                return 1;
            case 0:
        }
        return 0;
    }

    public long getChildId(int paramInt1, int paramInt2) {
        Log.e(TAG, "getChildId()->[paramInt1 = ]" + paramInt1);
        Log.e(TAG, "getChildId()->[paramInt2 = ]" + paramInt2);
        return paramInt1 * 10 + paramInt2;
    }

    public int getChildItemViewType(int paramInt1, int paramInt2) {
        Log.e(TAG, "getChildItemViewType()->[paramInt1 = ]" + paramInt1);
        Log.e(TAG, "getChildItemViewType()->[paramInt2 = ]" + paramInt2);
        return paramInt1;
    }

    public int getGroupCount() {
        return 5;
    }

    public long getGroupId(int paramInt) {
        return paramInt;
    }

    public int getGroupItemViewType(int paramInt) {
        return paramInt;
    }

    public void onBindChildViewHolder(ItemNapTienHolder paramItemNapTienHolder, int paramInt1, int paramInt2, int paramInt3) {
    }

    public void onBindGroupViewHolder(GroupNapTienHolder paramGroupNapTienHolder, int paramInt1, int paramInt2) {
        Log.e(TAG, "onBindGroupViewHolder()->[paramInt1 = ]" + paramInt1);
        Log.e(TAG, "onBindGroupViewHolder()->[paramInt2 = ]" + paramInt2);
        ImageView localImageView;
        TextView localTextView1;
        TextView localTextView2;
        localImageView = (ImageView) paramGroupNapTienHolder.itemView.findViewById(R.id.imvIcon);
        localTextView1 = (TextView) paramGroupNapTienHolder.itemView.findViewById(R.id.tvTitle);
        localTextView2 = (TextView) paramGroupNapTienHolder.itemView.findViewById(R.id.tvDescription);
        if (paramInt2 == THE_DIEN_THOAI) {
            localImageView.setImageResource(R.drawable.icon_card);
            localTextView1.setText("Nạp bằng thẻ điện thoại");
            localTextView2.setText("Viettel, Vinaphone, Mobiphone");
            return;
        }
        if (paramInt2 == NGAN_HANG) {
            localImageView.setImageResource(R.drawable.icon_cash);
            localTextView1.setText("Chuyển khoản ngân hàng");
            localTextView2.setText("Chuyển vào một trong các tài khoản dưới đây");
            return;
        }
        if (paramInt2 == CHUYEN_ONLINE) {
            localImageView.setImageResource(R.drawable.icon_onlinebanking);
            localTextView1.setText("Chuyển khoản Online");
            localTextView2.setText("Nếu bạn đăng ký dịch vụ Internet Banking");
        }
        if (paramInt2 == HO_TRO && localImageView != null) {
            localImageView.setImageResource(R.drawable.icon_bigsupport);
            localTextView1.setText("Bạn cần hỗ trợ");
            localTextView2.setText("Giải đáp thắc mắc về giao dịch, dịch vụ");
        }
    }

    public boolean onCheckCanExpandOrCollapseGroup(GroupNapTienHolder paramGroupNapTienHolder, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean) {
        return paramInt1 != PROFILE;
    }

    public ItemNapTienHolder onCreateChildViewHolder(ViewGroup paramViewGroup, int paramInt) {
        Log.e(TAG, "onCreateChildViewHolder()->[paramInt1 = ]" + paramInt);
        View localView = null;
        if (paramInt == THE_DIEN_THOAI) {
            localView = LayoutInflater.from(paramViewGroup.getContext()).inflate(R.layout.naptien_item_dienthoai, paramViewGroup, false);
        } else if (paramInt == NGAN_HANG) {
            localView = LayoutInflater.from(paramViewGroup.getContext()).inflate(R.layout.naptien_item_nganhang, paramViewGroup, false);
        } else if (paramInt == CHUYEN_ONLINE) {
            localView = LayoutInflater.from(paramViewGroup.getContext()).inflate(R.layout.naptien_item_online, paramViewGroup, false);
        } else {
            localView = LayoutInflater.from(paramViewGroup.getContext()).inflate(R.layout.naptien_item_hotro, paramViewGroup, false);
        }
        return new ItemNapTienHolder(localView);
    }

    public GroupNapTienHolder onCreateGroupViewHolder(ViewGroup paramViewGroup, int paramInt) {
        Log.e(TAG, "onCreateGroupViewHolder()->[paramInt1 = ]" + paramInt);
        View localView = null;
        if (paramInt == PROFILE) {
            localView = LayoutInflater.from(paramViewGroup.getContext()).inflate(R.layout.naptien_group_profile, paramViewGroup, false);
        } else if (paramInt == THE_DIEN_THOAI) {
            localView = LayoutInflater.from(paramViewGroup.getContext()).inflate(R.layout.naptien_group_other, paramViewGroup, false);
        } else if (paramInt == NGAN_HANG) {
            localView = LayoutInflater.from(paramViewGroup.getContext()).inflate(R.layout.naptien_group_other, paramViewGroup, false);
        } else if (paramInt == CHUYEN_ONLINE) {
            localView = LayoutInflater.from(paramViewGroup.getContext()).inflate(R.layout.naptien_group_other, paramViewGroup, false);
        } else {
            localView = LayoutInflater.from(paramViewGroup.getContext()).inflate(R.layout.naptien_group_hotro, paramViewGroup, false);
        }
        return new GroupNapTienHolder(localView);
    }
}