package com.lthdl.app.screen.core;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.view.View;
import android.view.View.OnClickListener;
import com.lthdl.app.R;

public class MainActivity extends AppCompatActivity {

    Button button;
    boolean isFaceBookOn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        isFaceBookOn = true;
        addListenerOnButton();
    }

    public void addListenerOnButton() {

        button = (Button) findViewById(R.id.button1);

        button.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View arg0) {
                if(isFaceBookOn)
                {
                    startActivity(new Intent(MainActivity.this, CoreActivity.class));
                } else {
                    // Call Login FaceBook here.
                }


            }

        });

    }
}
