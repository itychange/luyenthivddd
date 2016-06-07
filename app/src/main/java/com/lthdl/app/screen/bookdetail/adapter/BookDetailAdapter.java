package com.lthdl.app.screen.bookdetail.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import android.view.ViewGroup;

import com.lthdl.app.screen.bookdetail.model.BookModel;
import com.lthdl.app.screen.bookdetail.model.BookOverViewModel;
import com.lthdl.app.screen.bookdetail.model.ChapterModel;
import com.lthdl.app.screen.bookdetail.view.BookOverView;
import com.lthdl.app.screen.bookdetail.view.ChapterView;

import java.util.ArrayList;
import java.util.List;

public class BookDetailAdapter extends Adapter<ViewHolder> {
    BookModel bookModel;
    Context mContext;
    List<Object> objects = new ArrayList();

    public BookDetailAdapter(BookModel paramBookModel, Context paramContext) {
        this.bookModel = paramBookModel;
        this.mContext = paramContext;
        this.objects.add(paramBookModel.overView);
        this.objects.addAll(paramBookModel.chapterModels);
    }

    public int getItemCount() {
        return this.objects.size();
    }

    public int getItemViewType(int paramInt) {
        if (paramInt == 0)
            return 0;
        return 1;
    }

    public void onBindViewHolder(ViewHolder paramViewHolder, int paramInt) {
        if ((paramViewHolder instanceof BookOverviewViewHolder))
            ((BookOverviewViewHolder) paramViewHolder).overView.setData((BookOverViewModel) this.objects.get(paramInt));
        if ((paramViewHolder instanceof ChapterViewHolder))
            ((ChapterViewHolder) paramViewHolder).chapterView.seData((ChapterModel) this.objects.get(paramInt), paramInt - 1);
    }

    public ViewHolder onCreateViewHolder(ViewGroup paramViewGroup, int paramInt) {
        if (paramInt == 0)
            return new BookOverviewViewHolder(new BookOverView(this.mContext));
        return new ChapterViewHolder(new ChapterView(this.mContext));
    }

    public class BookOverviewViewHolder extends ViewHolder {
        BookOverView overView;

        public BookOverviewViewHolder(View arg2) {
            super(arg2);
            this.overView = ((BookOverView) arg2);
        }
    }

    public class ChapterViewHolder extends ViewHolder {
        ChapterView chapterView;

        public ChapterViewHolder(View arg2) {
            super(arg2);
            this.chapterView = ((ChapterView) arg2);
        }
    }
}