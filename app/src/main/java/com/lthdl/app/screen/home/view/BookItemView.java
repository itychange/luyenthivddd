package com.lthdl.app.screen.home.view;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.lthdl.app.R;
import com.lthdl.app.common.widget.button.CButton;
import com.lthdl.app.common.widget.textview.CTextView;
import com.lthdl.app.model.IMyBooks;
import com.lthdl.app.screen.bookdetail.event.OnEventOpenBookDetailActivity;

import org.greenrobot.eventbus.EventBus;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class BookItemView extends LinearLayout {

    @Bind(R.id.tvBookId)
    public TextView tvBookId;
    @Bind(R.id.imvThumb)
    public ImageView imvThumb;
    @Bind(R.id.tvTitleBook)
    public CTextView tvTitleBook;
    @Bind(R.id.tvAuthor)
    public CTextView tvAuthor;
    @Bind(R.id.rbRating)
    public RatingBar rbRating;
    @Bind(R.id.tvCost)
    public CTextView tvCost;
    @Bind(R.id.btnDaMua)
    public CButton btnDaMua;
    @Bind(R.id.numrating)
    public CTextView numrating;



    String url;
    String title;
    String author;
    String rating;
    String cost;
    public ArrayList<IMyBooks> arrayList=null;
    public BookItemView(Context paramContext) {
        super(paramContext);
        init();
    }
    public BookItemView(Context paramContext, ArrayList<IMyBooks>arrayList, String url, String title, String author, String rating, String cost) {
        super(paramContext);
        this.arrayList=arrayList;
        this.url=url;
        this.title=title;
        this.author=author;
        this.rating=rating;
        this.cost=cost;
        init();
    }
    public BookItemView(Context paramContext, AttributeSet paramAttributeSet) {
        super(paramContext, paramAttributeSet);
        init();
    }

    public BookItemView(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
        super(paramContext, paramAttributeSet, paramInt);
        init();
    }

    private void init() {
        View view=LayoutInflater.from(getContext()).inflate(R.layout.home_view_book_item, this, true);
        imvThumb= (ImageView) view.findViewById(R.id.imvThumb);
        tvTitleBook= (CTextView) view.findViewById(R.id.tvTitleBook);
        tvAuthor= (CTextView) view.findViewById(R.id.tvAuthor);
        tvCost= (CTextView) view.findViewById(R.id.tvCost);
        rbRating= (RatingBar) view.findViewById(R.id.rbRating);
        numrating= (CTextView) view.findViewById(R.id.numrating);
        Log.i("null","===>"+rating);

        if(arrayList!=null){
            Glide.with(getContext())
                    .load(url)
                    .centerCrop()
                    .crossFade()
                    .into(imvThumb);
            tvTitleBook.setText(title);
            tvAuthor.setText(author);
            if(rating!=null) {
                rbRating.setRating(Float.parseFloat(rating));
            }
            else {
                rbRating.setRating(0);
            }
            tvCost.setText(cost);

        }
        ButterKnife.bind(this);
    }

    public String getBookId() {
        return this.tvBookId.getText().toString();
    }

    @OnClick(R.id.lyMain)
    public void onBookClick(View paramView) {
        EventBus.getDefault().post(new OnEventOpenBookDetailActivity(getBookId()));
    }
}