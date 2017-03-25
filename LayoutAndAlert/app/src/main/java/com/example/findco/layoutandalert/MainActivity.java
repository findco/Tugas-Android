package com.example.findco.layoutandalert;

import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private Button clickButton;
    private static final String tag = "findco";
    boolean wrongPass = true;
    boolean callDetail = false;
    EditText pass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(tag, "The onCreate() event");

        clickButton = (Button) findViewById(R.id.login_button);
        pass = (EditText) findViewById(R.id.password);

        //Action listener
        clickButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!pass.getText().toString().equals("findco")) {
                    AlertDialog.Builder dialog = new AlertDialog.Builder(MainActivity.this);
                    dialog.setTitle("Password Salah");
                    dialog.create().show();
                } else {
                    callDetail = true;
                    Intent intent = new Intent(MainActivity.this, DetailActivity.class);
                    startActivity(intent);
                }
            }
        });
        if (savedInstanceState != null) {
            wrongPass = savedInstanceState.getBoolean("Wrong Password");
        }
        if (wrongPass) {
            AlertDialog.Builder dialog = new AlertDialog.Builder(MainActivity.this);
            dialog.setTitle("Password Salah");
            dialog.create().show();
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        outState.putBoolean("Wrong Password", wrongPass);
        super.onSaveInstanceState(outState);
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(tag, "The onRestart() event");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(tag, "The onPause() event");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(tag, "The onResume() event");
        if(callDetail){
            finish();
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(tag, "The onStart() event");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(tag, "The onStop() event");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(tag, "The onDestroy() event");
    }

}
