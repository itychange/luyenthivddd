package com.lthdl.app.screen.bookdetail.view;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import butterknife.Bind;
import butterknife.ButterKnife;

import com.github.aakira.expandablelayout.ExpandableRelativeLayout;
import com.lthdl.app.R;
import com.lthdl.app.global.Constant;
import com.lthdl.app.screen.bookdetail.model.ChapterModel;
import com.lthdl.app.screen.bookdetail.model.SubChapterModel;

import java.util.List;

public class ChapterView extends LinearLayout
        implements OnClickListener {
//    public static final String CLASS_NAME = " ChapterView ";
    public static final int MAX_VISBLE = 2;
    ChapterViewListener chapterViewListener = new ChapterViewListener() {
        public void onCollapse() {
        }

        public void onExpand() {
        }

        public void onSubChapterItemClick(View paramView, SubChapterModel paramSubChapterModel, int paramInt1, int paramInt2) {
        }

        public void onSubChapterItemSettingClick(View paramView, SubChapterModel paramSubChapterModel, int paramInt1, int paramInt2) {
        }
    };

    @Bind(R.id.imvExpandChapter)
    ImageView imvExpandChapter;
    boolean isExpand = false;
    boolean isHaveExpand = false;

    @Bind(R.id.lyChapterInVisiable)
    LinearLayout lyChapterInVisiable;

    @Bind(R.id.lyChapterInVisiableBound)
    ExpandableRelativeLayout lyChapterInVisiableBound;

    @Bind(R.id.lyChapterVisiable)
    LinearLayout lyChapterVisiable;

    @Bind(R.id.lyExpand)
    LinearLayout lyExpand;

    @Bind(R.id.tvChapterName)
    TextView tvChapterName;

    public ChapterView(Context paramContext) {
        super(paramContext);
        init();
    }

    public ChapterView(Context paramContext, AttributeSet paramAttributeSet) {
        super(paramContext, paramAttributeSet);
        init();
    }

    public ChapterView(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
        super(paramContext, paramAttributeSet, paramInt);
        init();
    }

    public ChapterView(Context paramContext, ChapterModel paramChapterModel, int paramInt) {
        super(paramContext);
        init();
        seData(paramChapterModel, paramInt);
    }

    private void init() {
        ButterKnife.bind(this, LayoutInflater.from(getContext()).inflate(R.layout.item_chapter, this, true));
        this.lyExpand.setOnClickListener(this);
    }

    public ChapterViewListener getChapterViewListener() {
        return this.chapterViewListener;
    }

    public void onClick(View paramView) {
        switch (paramView.getId()) {
            default:
                return;
            case R.id.lyExpand:
        }
        if (this.isExpand) {
            this.lyChapterInVisiableBound.collapse();
            this.isExpand = false;
            this.imvExpandChapter.setImageResource(R.drawable.icon_arrowdown);
            this.chapterViewListener.onCollapse();
            return;
        }
        this.lyChapterInVisiableBound.expand();
        this.isExpand = true;
        this.imvExpandChapter.setImageResource(R.drawable.icon_arrow_up);
        this.chapterViewListener.onExpand();
    }

    public void seData(ChapterModel paramChapterModel, int paramInt) {
//        Log.e(Constant.TAG, CLASS_NAME + " paramInt = " + paramInt);
        final int paramInt1 = paramInt;
        int maxVisible = MAX_VISBLE;
        setTag(Integer.valueOf(paramInt));
        this.tvChapterName.setText(paramChapterModel.name);
        List<SubChapterModel> subChapterModels = paramChapterModel.subChapterModels;
        Object localObject;
        SubChapterView localSubChapterView;
//        Log.e(Constant.TAG, CLASS_NAME + " subChapterModels.size = " + subChapterModels.size());

        if (subChapterModels.size() < MAX_VISBLE) {
            maxVisible = subChapterModels.size();
        }
        for (int i = 1; i <= maxVisible; i++) {
            this.lyExpand.setVisibility(View.GONE);
            this.isHaveExpand = false;
            localObject = subChapterModels.get(i - 1);
            localSubChapterView = new SubChapterView(getContext(), (SubChapterModel) localObject, i - 1);
            (localSubChapterView).setSubChapterListener(new SubChapterView.SubChapterListener() {
                public void onItemClick(SubChapterModel paramSubChapterModel) {
                    ChapterView.this.chapterViewListener.onSubChapterItemClick(ChapterView.this, paramSubChapterModel, paramInt1, ((Integer) ChapterView.this.getTag()).intValue());
                }

                public void onSettingClick(SubChapterModel paramSubChapterModel) {
                    ChapterView.this.chapterViewListener.onSubChapterItemSettingClick(ChapterView.this, paramSubChapterModel, paramInt1, ((Integer) ChapterView.this.getTag()).intValue());
                }
            });
            this.lyChapterVisiable.addView(localSubChapterView);
        }
        if (subChapterModels.size() > MAX_VISBLE) {
            for (int i = MAX_VISBLE + 1; i <= subChapterModels.size(); i++) {
                this.lyExpand.setVisibility(View.VISIBLE);
                this.isHaveExpand = true;
                localObject = subChapterModels.get(i - 1);
                localSubChapterView = new SubChapterView(getContext(), (SubChapterModel) localObject, i - 1);
                (localSubChapterView).setSubChapterListener(new SubChapterView.SubChapterListener() {
                    public void onItemClick(SubChapterModel paramSubChapterModel) {
                        ChapterView.this.chapterViewListener.onSubChapterItemClick(ChapterView.this, paramSubChapterModel, paramInt1, ((Integer) ChapterView.this.getTag()).intValue());
                    }

                    public void onSettingClick(SubChapterModel paramSubChapterModel) {
                        ChapterView.this.chapterViewListener.onSubChapterItemSettingClick(ChapterView.this, paramSubChapterModel, paramInt1, ((Integer) ChapterView.this.getTag()).intValue());
                    }
                });
                this.lyChapterInVisiable.addView(localSubChapterView);
            }
        }
    }

    public void setChapterViewListener(ChapterViewListener paramChapterViewListener) {
        this.chapterViewListener = paramChapterViewListener;
    }

    public static abstract interface ChapterViewListener {
        public abstract void onCollapse();

        public abstract void onExpand();

        public abstract void onSubChapterItemClick(View paramView, SubChapterModel paramSubChapterModel, int paramInt1, int paramInt2);

        public abstract void onSubChapterItemSettingClick(View paramView, SubChapterModel paramSubChapterModel, int paramInt1, int paramInt2);
    }
}