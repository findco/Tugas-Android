package com.example.findco.layoutandalert;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

/**
 * Created by findco on 25-Mar-17.
 */

public class DetailActivity extends AppCompatActivity {

    private static final String tag = "Event, ";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(tag, "The onPause() event");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(tag, "The onStop() event");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(tag, "The onRestart() event");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(tag, "The onResume() event");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(tag, "The onPause() event");
    }
}
