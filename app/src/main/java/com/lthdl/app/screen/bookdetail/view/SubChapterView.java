package com.lthdl.app.screen.bookdetail.view;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import butterknife.Bind;
import butterknife.ButterKnife;

import com.lthdl.app.R;
import com.lthdl.app.screen.bookdetail.model.SubChapterModel;

public class SubChapterView extends LinearLayout {

//    public static final String CLASS_NAME = " SubChapterView ";
    @Bind(R.id.imvContentSetting)
    ImageView imvContentSetting;

    @Bind(R.id.imvSubChapter)
    ImageView imvSubChapter;
    private SubChapterModel model;
    SubChapterListener subChapterListener = new SubChapterListener() {
        public void onItemClick(SubChapterModel paramSubChapterModel) {
        }

        public void onSettingClick(SubChapterModel paramSubChapterModel) {
        }
    };

    @Bind(R.id.tvDescritsion)
    TextView tvDescritsion;

    @Bind(R.id.tvStatus)
    TextView tvStatus;

    @Bind(R.id.tvSubTitle)
    TextView tvSubTitle;

    public SubChapterView(Context paramContext) {
        super(paramContext);
        init();
    }

    public SubChapterView(Context paramContext, AttributeSet paramAttributeSet) {
        super(paramContext, paramAttributeSet);
        init();
    }

    public SubChapterView(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
        super(paramContext, paramAttributeSet, paramInt);
        init();
    }

    public SubChapterView(Context paramContext, SubChapterModel paramSubChapterModel, int paramInt) {
        super(paramContext);
        init();
        setData(paramSubChapterModel, paramInt);
    }

    private void init() {
        ButterKnife.bind(this, LayoutInflater.from(getContext()).inflate(R.layout.item_sub_chapter, this, true));
        setOnClickListener(new OnClickListener() {
            public void onClick(View paramView) {
                SubChapterView.this.subChapterListener.onItemClick(SubChapterView.this.getModel());
            }
        });
        this.imvContentSetting.setOnClickListener(new OnClickListener() {
            public void onClick(View paramView) {
                SubChapterView.this.subChapterListener.onSettingClick(SubChapterView.this.model);
            }
        });
    }

    public SubChapterModel getModel() {
        return this.model;
    }

    public SubChapterListener getSubChapterListener() {
        return this.subChapterListener;
    }

    public void setData(SubChapterModel paramSubChapterModel, int paramInt) {
        setTag(Integer.valueOf(paramInt));
        setModel(paramSubChapterModel);
        switch (paramSubChapterModel.type) {
            default:
                this.tvStatus.setText(paramSubChapterModel.status);
                if (!paramSubChapterModel.status.equalsIgnoreCase("new"))
                    break;
                this.tvStatus.setTextColor(getContext().getResources().getColor(R.color.blue));
            case 0:
        }
        this.tvSubTitle.setText(paramSubChapterModel.subtitle);
        this.tvDescritsion.setText(paramSubChapterModel.description);
        this.imvSubChapter.setImageResource(R.drawable.icon_baikiemtra);
        //if (!paramSubChapterModel.status.equalsIgnoreCase("free"))
        this.tvStatus.setTextColor(getContext().getResources().getColor(R.color.red));
    }

    public void setModel(SubChapterModel paramSubChapterModel) {
        this.model = paramSubChapterModel;
    }

    public void setSubChapterListener(SubChapterListener paramSubChapterListener) {
        this.subChapterListener = paramSubChapterListener;
    }

    public static abstract interface SubChapterListener {
        public abstract void onItemClick(SubChapterModel paramSubChapterModel);

        public abstract void onSettingClick(SubChapterModel paramSubChapterModel);
    }
}