package com.lthdl.app.common.widget.taskbar;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.lthdl.app.R;

public class SupportAdapter extends BaseAdapter {
    int[] icons;
    Context mContext;
    String[] names;

    public SupportAdapter(int[] paramArrayOfInt, String[] paramArrayOfString, Context paramContext) {
        this.icons = paramArrayOfInt;
        this.names = paramArrayOfString;
        this.mContext = paramContext;
    }

    public int getCount() {
        return this.icons.length;
    }

    public Object getItem(int paramInt) {
        return null;
    }

    public long getItemId(int paramInt) {
        return 0L;
    }

    public View getView(int paramInt, View paramView, ViewGroup paramViewGroup) {
        SupportHolder supportHolder = new SupportHolder();
        View localView = LayoutInflater.from(this.mContext).inflate(R.layout.item_support_adapter, null, false);
        supportHolder.imvIconSupportType = ((ImageView) localView.findViewById(R.id.imvIconSupportType));
        supportHolder.tvSupportName = ((TextView) localView.findViewById(R.id.tvSupportName));
        localView.setTag(supportHolder);
        supportHolder.imvIconSupportType.setImageResource(this.icons[paramInt]);
        supportHolder.tvSupportName.setText(this.names[paramInt]);
        return localView;
    }

    class SupportHolder {
        ImageView imvIconSupportType;
        TextView tvSupportName;

        SupportHolder() {
        }
    }
}