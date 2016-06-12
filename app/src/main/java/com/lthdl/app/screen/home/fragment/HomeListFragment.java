package com.lthdl.app.screen.home.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.lthdl.app.BaseFragment;
import com.lthdl.app.R;
import com.lthdl.app.screen.home.adapter.BookListAdapter;

import butterknife.Bind;

public class HomeListFragment extends BaseFragment {
    BookListAdapter adapter;
    @Bind(R.id.rcvBook)
    RecyclerView rcvBook;

    protected void init(View paramView) {
        LinearLayoutManager localLinearLayoutManager = new LinearLayoutManager(getActivity().getBaseContext());
        this.rcvBook.setLayoutManager(localLinearLayoutManager);
        this.adapter = new BookListAdapter();
        this.rcvBook.setAdapter(this.adapter);
        this.rcvBook.setHasFixedSize(true);
    }

    @Nullable
    public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle) {
        return paramLayoutInflater.inflate(R.layout.home_homepage_fragment, paramViewGroup, false);
    }
}