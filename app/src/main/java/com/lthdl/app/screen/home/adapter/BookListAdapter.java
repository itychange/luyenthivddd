package com.lthdl.app.screen.home.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import com.lthdl.app.screen.home.holder.BookHolder;
import com.lthdl.app.screen.home.view.BookItemView;

public class BookListAdapter extends RecyclerView.Adapter<BookHolder> {
    public int getItemCount() {
        return 8;
    }

    public void onBindViewHolder(BookHolder paramBookHolder, int paramInt) {
    }

    public BookHolder onCreateViewHolder(ViewGroup paramViewGroup, int paramInt) {
        return new BookHolder(new BookItemView(paramViewGroup.getContext()));
    }
}