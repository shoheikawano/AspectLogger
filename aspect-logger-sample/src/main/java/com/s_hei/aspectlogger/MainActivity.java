package com.s_hei.aspectlogger;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;

import com.s_hei.reveal.Reveal;

public class MainActivity extends ActionBarActivity {

    private static final String TAG = MainActivity.class.getSimpleName();

    @Reveal
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
