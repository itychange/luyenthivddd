package com.lthdl.app.screen.home;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;

import com.lthdl.app.R;
import com.lthdl.app.model.ItemBook;
import com.lthdl.app.model.IMyBooks;
import com.lthdl.app.network.ApiClient;
import com.lthdl.app.network.ApiInterface;
import com.lthdl.app.screen.home.adapter.BookListAdapter;

import java.util.ArrayList;

import butterknife.Bind;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MyBooks extends Activity {

    private RecyclerView rvMyBooks;
    BookListAdapter adapter;
    @Bind(R.id.rcvBook)
    RecyclerView rcvBook;
    private ArrayList<IMyBooks> myBookses = null;
    Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mybooks);
        rvMyBooks = (RecyclerView) findViewById(R.id.rcvMyBook);
        toolbar= (Toolbar) findViewById(R.id.toolbar);

        myBookses=new ArrayList<>();
        LinearLayoutManager localLinearLayoutManager = new LinearLayoutManager(this);
        this.rvMyBooks.setLayoutManager(localLinearLayoutManager);
        getMyBook();
    }

    public void getMyBook() {
        ApiInterface apiService = ApiClient.getClient().create(ApiInterface.class);
        Call call = apiService.getMybooks("5670405876482048");
        call.enqueue(new Callback<ItemBook>() {
            @Override
            public void onResponse(Call<ItemBook> call, Response<ItemBook> response) {
                ItemBook itemBook=response.body();
                Log.i("null","=====>"+itemBook.getMyBookses().size());
                for(int i=0;i<itemBook.getMyBookses().size();i++){
                    Log.i("null","=====>"+itemBook.getMyBookses().get(i).getName());

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
                rvMyBooks.setAdapter(adapter);

            }

            @Override
            public void onFailure(Call<ItemBook> call, Throwable t) {

            }

        });
    }
}
