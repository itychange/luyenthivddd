package com.lthdl.app.screen.home.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.lthdl.app.BaseFragment;
import com.lthdl.app.R;
import com.lthdl.app.model.IMyBooks;
import com.lthdl.app.model.ItemBook;
import com.lthdl.app.network.ApiClient;
import com.lthdl.app.network.ApiInterface;
import com.lthdl.app.screen.home.adapter.BookListAdapter;

import java.util.ArrayList;

import butterknife.Bind;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MyBoook extends BaseFragment {
    BookListAdapter adapter;
    @Bind(R.id.rcvBook)
    RecyclerView rcvBook;
    ArrayList<IMyBooks> myBookses=null;
    ImageView btnBack;
    protected void init(View paramView) {
        LinearLayoutManager localLinearLayoutManager = new LinearLayoutManager(getActivity().getBaseContext());
        rcvBook.setLayoutManager(localLinearLayoutManager);
     /*   this.adapter = new BookListAdapter();
        this.rcvBook.setAdapter(this.adapter);
        this.rcvBook.setHasFixedSize(true);*/
        getMyBook();
    }

    @Nullable
    public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle) {
        View view=paramLayoutInflater.inflate(R.layout.fragment_my_boook, paramViewGroup, false);
        btnBack= (ImageView) view.findViewById(R.id.btnBack);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().onBackPressed();
            }
        });
        return view;
    }

    public void getMyBook() {
        myBookses=new ArrayList<>();
        ApiInterface apiService = ApiClient.getClient().create(ApiInterface.class);
        Call call = apiService.getMybooks("5670405876482048");
        call.enqueue(new Callback<ItemBook>() {
            @Override
            public void onResponse(Call<ItemBook> call, Response<ItemBook> response) {
                ItemBook itemBook = response.body();
                for(int i=0;i<itemBook.getMyBookses().size();i++){
                    IMyBooks modeMyBooks=new IMyBooks();
                    modeMyBooks.setName(itemBook.getMyBookses().get(i).getName());
                    modeMyBooks.setAuthor(itemBook.getMyBookses().get(i).getAuthor());
                    modeMyBooks.setCat_id(itemBook.getMyBookses().get(i).getCat_id());
                    modeMyBooks.setConver(itemBook.getMyBookses().get(i).getConver());
                    modeMyBooks.setDescription(itemBook.getMyBookses().get(i).getDescription());
                    modeMyBooks.setId(itemBook.getMyBookses().get(i).getId());
                    modeMyBooks.setIs_buy(itemBook.getMyBookses().get(i).getIs_buy());
                    modeMyBooks.setIsbanner(itemBook.getMyBookses().get(i).getIsbanner());
                    modeMyBooks.setOderby(itemBook.getMyBookses().get(i).getOderby());
                    modeMyBooks.setPrice(itemBook.getMyBookses().get(i).getPrice());
                    modeMyBooks.setUser_buy(itemBook.getMyBookses().get(i).getUser_buy());
                    modeMyBooks.setRole(itemBook.getMyBookses().get(i).getRole());
                    modeMyBooks.setRate(itemBook.getMyBookses().get(i).getRate());
                    myBookses.add(modeMyBooks);
                }
                adapter = new BookListAdapter(myBookses);
                rcvBook.setAdapter(adapter);

            }

            @Override
            public void onFailure(Call<ItemBook> call, Throwable t) {

            }

        });
    }
}