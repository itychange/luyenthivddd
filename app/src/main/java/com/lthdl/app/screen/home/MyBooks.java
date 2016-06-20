package com.lthdl.app.screen.home;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import com.lthdl.app.R;
import com.lthdl.app.model.IMyBooks;
import com.lthdl.app.screen.home.adapter.BookListAdapter;

import java.util.ArrayList;

import butterknife.Bind;


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
        toolbar = (Toolbar) findViewById(R.id.toolbar);

    }
}
