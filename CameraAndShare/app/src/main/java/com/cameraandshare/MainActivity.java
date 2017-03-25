package com.cameraandshare;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class MainActivity extends AppCompatActivity {

    private ImageView camera;
    private EditText text;
    private Button button;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        camera = (ImageView) findViewById(R.id.upload);
        text = (EditText) findViewById(R.id.komentar);
        button = (Button) findViewById(R.id.share);


        camera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent cameraIntent = new Intent();
                cameraIntent.setAction(
                        android.provider.MediaStore.ACTION_IMAGE_CAPTURE);

                startActivityForResult(cameraIntent, 1);
            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String getText = text.getText().toString();
                if (!getText.equals("") && getText.length() != 0) {
                    shareText(getText);
                }else{
                    Toast.makeText(MainActivity.this,"Please enter something to share.", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == 1) {
            Bitmap photo = (Bitmap) data.getExtras().get("data");

            camera.setImageBitmap(photo);

            try {
                photo.compress(Bitmap.CompressFormat.JPEG, 100, new FileOutputStream(Environment.getExternalStorageDirectory() + "/NameOfFile.jpg"));
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
    }

    // Share text
    private void shareText(String text) {

        Intent sharingIntent = new Intent(android.content.Intent.ACTION_SEND);
        sharingIntent.setType("text/plain");// Plain format text

        // You can add subject also
		/*
		 * sharingIntent.putExtra( android.content.Intent.EXTRA_SUBJECT,
		 * "Subject Here");
		 */
        sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT, text);
        startActivity(Intent.createChooser(sharingIntent, "Share Text Using"));
    }
}
