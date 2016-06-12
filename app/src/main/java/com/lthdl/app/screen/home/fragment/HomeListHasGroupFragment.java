package com.lthdl.app.screen.home.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.h6ah4i.android.widget.advrecyclerview.animator.RefactoredDefaultItemAnimator;
import com.lthdl.app.BaseFragment;
import com.lthdl.app.R;
import com.lthdl.app.model.BooksTrangChu;
import com.lthdl.app.model.ItemBookTrangChu;
import com.lthdl.app.network.ApiClient;
import com.lthdl.app.network.ApiInterface;
import com.lthdl.app.screen.home.adapter.BookCollectAdapter;

import java.util.ArrayList;

import butterknife.Bind;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomeListHasGroupFragment extends BaseFragment {
    BookCollectAdapter adapter;
    ArrayList<ItemBookTrangChu> arrayList=null;
    @Bind(R.id.rcvBook)
    RecyclerView rcvBook;
    ItemBookTrangChu itemBookTrangChu =null;
    protected void init(View paramView) {
        getBook();

    }

    @Nullable
    public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle) {
        return paramLayoutInflater.inflate(R.layout.home_homepage_fragment, paramViewGroup, false);
    }
    public void getBook(){
        final ApiInterface apiService = ApiClient.getClient().create(ApiInterface.class);
        Call call= apiService.getBookTrangChu("5637489247125504","5670405876482048");
        call.enqueue(new Callback<BooksTrangChu>() {
            @Override
            public void onResponse(Call<BooksTrangChu> call, Response<BooksTrangChu> response) {
                itemBookTrangChu =response.body().getItemBooks();
                if(itemBookTrangChu !=null){
                    adapter = new BookCollectAdapter(itemBookTrangChu);
                }else{
                    adapter = new BookCollectAdapter();
                }
                RefactoredDefaultItemAnimator LocalRefactoredDefaultItemAnimator = new RefactoredDefaultItemAnimator();
                LocalRefactoredDefaultItemAnimator.setSupportsChangeAnimations(false);
                LinearLayoutManager localLinearLayoutManager = new LinearLayoutManager(getActivity().getBaseContext());
                rcvBook.setLayoutManager(localLinearLayoutManager);
                rcvBook.setAdapter(adapter);
                rcvBook.setItemAnimator(LocalRefactoredDefaultItemAnimator);
                rcvBook.setHasFixedSize(true);
            }
            @Override
            public void onFailure(Call<BooksTrangChu> call, Throwable t) {
            }
        });
    }
}