package com.lthdl.app.screen.home.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import com.lthdl.app.model.IMyBooks;
import com.lthdl.app.screen.home.holder.BookHolder;
import com.lthdl.app.screen.home.view.BookItemView;

import java.util.ArrayList;

public class BookListAdapter extends RecyclerView.Adapter<BookHolder> {
    ArrayList<IMyBooks> arrayList=null;
    String url;
    String title;
    String author;
    String rating;
    String cost;
    String user_buy;
    int postion=0;
    public BookListAdapter(ArrayList<IMyBooks> arrayList){
        this.arrayList=arrayList;

    }public BookListAdapter(){}
    public int getItemCount() {
        return arrayList!=null?arrayList.size():8;
    }

    public int getPostion() {
        return postion;
    }

    public void setPostion(int postion) {
        this.postion = postion;
    }

    public void onBindViewHolder(BookHolder paramBookHolder, int paramInt) {
        postion=paramInt;
        postion++;
    }

    public BookHolder onCreateViewHolder(ViewGroup paramViewGroup, int paramInt) {
        if (arrayList!=null){
            IMyBooks modeMyBooks=arrayList.get(postion);
            url=modeMyBooks.getConver();
            title=modeMyBooks.getName();
            author=modeMyBooks.getAuthor();
            rating=modeMyBooks.getRate();
            cost=modeMyBooks.getPrice();
            user_buy=modeMyBooks.getUser_buy();
        }
        return arrayList!=null?new BookHolder(new BookItemView(paramViewGroup.getContext(),arrayList,url,title,author,rating,cost,user_buy)):new BookHolder(new BookItemView(paramViewGroup.getContext()));
    }
}