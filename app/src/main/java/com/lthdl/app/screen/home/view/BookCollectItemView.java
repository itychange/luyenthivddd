package com.lthdl.app.screen.home.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.github.aakira.expandablelayout.ExpandableRelativeLayout;
import com.lthdl.app.R;
import com.lthdl.app.model.Book_id;
import com.lthdl.app.model.IMyBooks;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class BookCollectItemView extends FrameLayout {
    public static final int MAX_BOOK_VISIBLE = 3;

    @Bind(R.id.imvExpandChapter)
    ImageView imvExpandChapter;

    @Bind(R.id.lyBookGroupInVisiable)
    LinearLayout lyBookGroupInVisiable;

    @Bind(R.id.lyBookGroupInVisiableBound)
    ExpandableRelativeLayout lyBookGroupInVisiableBound;

    @Bind(R.id.lyBookGroupVisiable)
    LinearLayout lyBookGroupVisiable;

    @Bind(R.id.lyExpand)
    LinearLayout lyExpand;

    @Bind(R.id.text1)
    TextView text1;

    String title;
    Book_id book_id;
    public BookCollectItemView(Context paramContext,Book_id book_id,String title) {
        super(paramContext);
        this.title=title;
        this.book_id=book_id;
        init();
    }

    public BookCollectItemView(Context paramContext, AttributeSet paramAttributeSet) {
        super(paramContext, paramAttributeSet);
        init();
    }

    public BookCollectItemView(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
        super(paramContext, paramAttributeSet, paramInt);
        init();
    }

    private void init() {
        View view=LayoutInflater.from(getContext()).inflate(R.layout.home_view_book_collect_item, this, true);
        text1= (TextView) view.findViewById(R.id.text1);
        text1.setText(title);
        ButterKnife.bind(this);

        setData();
        this.lyBookGroupInVisiableBound.setExpanded(false);
        this.lyExpand.setVisibility(GONE);

    }

    @OnClick(R.id.lyExpand)
    public void onExpandClick(View paramView) {
        this.lyBookGroupInVisiableBound.toggle();
        if (this.lyBookGroupInVisiableBound.isExpanded()) {
            this.imvExpandChapter.setImageResource(R.drawable.icon_arrowdown);
            return;
        }
        this.imvExpandChapter.setImageResource(R.drawable.icon_arrow_up);
    }

    public void setData() {
      //  ArrayList<IMyBooks> arrayList, String url, String title, String author, String rating, String cost
        ArrayList<IMyBooks> arrayList=book_id.getMyBookses();
        for (int i = 0; i < book_id.getMyBookses().size(); i++) {
            BookItemView localBookItemView = new BookItemView(getContext(),arrayList,
                    book_id.getMyBookses().get(i).getConver(),book_id.getMyBookses().get(i).getName()
            ,book_id.getMyBookses().get(i).getAuthor(),book_id.getMyBookses().get(i).getRate(),book_id.getMyBookses().get(i).getRole(),book_id.getMyBookses().get(i).getUser_buy());
            //if (i < MAX_BOOK_VISIBLE) {
                this.lyBookGroupVisiable.addView(localBookItemView);
            /*} else {
                this.lyBookGroupInVisiable.addView(localBookItemView);
            }*/
        }
    }
}