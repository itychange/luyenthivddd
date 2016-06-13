package com.lthdl.app.screen.home.adapter;

import android.support.v7.widget.RecyclerView.Adapter;
import android.view.ViewGroup;

import com.lthdl.app.model.Book_id;
import com.lthdl.app.model.ItemBookTrangChu;
import com.lthdl.app.screen.home.holder.BookCollectViewHolder;
import com.lthdl.app.screen.home.view.BookCollectItemView;

public class BookCollectAdapter extends Adapter<BookCollectViewHolder> {
    ItemBookTrangChu itemBookTrangChu =null;
    String title;
    int pos=0;
    public BookCollectAdapter(){

    }
    Book_id itemBook;
    public BookCollectAdapter(ItemBookTrangChu itemBookTrangChu){
        this.itemBookTrangChu = itemBookTrangChu;
    }
    public int getItemCount() {
        return itemBookTrangChu !=null? itemBookTrangChu.getMyBookses().size():4;
    }

    public void onBindViewHolder(BookCollectViewHolder paramBookCollectViewHolder, int paramInt) {
        pos=paramInt;
        pos++;
    }

    public BookCollectViewHolder onCreateViewHolder(ViewGroup paramViewGroup, int paramInt) {

        return new BookCollectViewHolder(new BookCollectItemView(paramViewGroup.getContext(),itemBookTrangChu.getMyBookses().get(pos).getBook_ids(),itemBookTrangChu.getMyBookses().get(pos).getName()));
    }
}