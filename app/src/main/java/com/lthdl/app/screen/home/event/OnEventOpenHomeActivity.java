package com.lthdl.app.screen.home.event;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

public class OnEventOpenHomeActivity  extends Activity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Toast.makeText(this, "Show", Toast.LENGTH_SHORT).show();

    }
}