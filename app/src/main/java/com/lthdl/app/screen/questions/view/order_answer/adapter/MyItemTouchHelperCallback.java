package com.lthdl.app.screen.questions.view.order_answer.adapter;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.support.v7.widget.helper.ItemTouchHelper.Callback;

import com.lthdl.app.screen.questions.view.order_answer.interfaces.CallbackItemTouch;

public class MyItemTouchHelperCallback extends Callback {
    CallbackItemTouch callbackItemTouch;

    public MyItemTouchHelperCallback(CallbackItemTouch paramCallbackItemTouch) {
        this.callbackItemTouch = paramCallbackItemTouch;
    }

    public int getMovementFlags(RecyclerView paramRecyclerView, ViewHolder paramViewHolder) {
        return makeFlag(2, 3);
    }

    public boolean isItemViewSwipeEnabled() {
        return false;
    }

    public boolean isLongPressDragEnabled() {
        return true;
    }

    public boolean onMove(RecyclerView paramRecyclerView, ViewHolder paramViewHolder1, ViewHolder paramViewHolder2) {
        this.callbackItemTouch.itemTouchOnMove(paramViewHolder1.itemView, paramViewHolder1.getAdapterPosition(), paramViewHolder2.getAdapterPosition());
        return true;
    }

    public void onSwiped(ViewHolder paramViewHolder, int paramInt) {
    }
}