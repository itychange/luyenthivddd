package com.lthdl.app.screen.questions.view.order_answer.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView.Adapter;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

public class MyAdapterRecyclerView extends Adapter<MyViewHolder> {
    private List<Integer> correctList;
    private List<String> data;
    Context mContext;
    List<OrderAnswerItem> orderAnswerItems = new ArrayList();

    public MyAdapterRecyclerView(List<String> paramList, List<Integer> paramList1, Context paramContext) {
        this.data = paramList;
        this.correctList = paramList1;
        this.mContext = paramContext;
    }

    public List<Integer> getCorrectList() {
        return this.correctList;
    }

    public List<String> getData() {
        return this.data;
    }

    public int getItemCount() {
        return this.data.size();
    }

    public List<OrderAnswerItem> getOrderAnswerItems() {
        return this.orderAnswerItems;
    }

    public Context getmContext() {
        return this.mContext;
    }

    public void onBindViewHolder(MyViewHolder paramMyViewHolder, int paramInt) {
        paramMyViewHolder.orderAnswerItem.setIndex(paramInt);
        paramMyViewHolder.orderAnswerItem.setContentAnswer(this.data.get(paramInt));
        paramMyViewHolder.orderAnswerItem.setCorrectIndex(this.correctList.get(paramInt));
    }

    public MyViewHolder onCreateViewHolder(ViewGroup paramViewGroup, int paramInt) {
        OrderAnswerItem orderAnswerItem = new OrderAnswerItem(this.mContext);
        if (!this.orderAnswerItems.contains(orderAnswerItem))
            this.orderAnswerItems.add(orderAnswerItem);
        return new MyViewHolder(orderAnswerItem);
    }

    public void setCorrectList(List<Integer> paramList) {
        this.correctList = paramList;
    }

    public void setData(List<String> paramList) {
        this.data = paramList;
    }

    public void setmContext(Context paramContext) {
        this.mContext = paramContext;
    }
}