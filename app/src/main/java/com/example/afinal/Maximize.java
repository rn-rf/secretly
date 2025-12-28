package com.example.afinal;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;

import android.graphics.BitmapFactory;

import java.io.ByteArrayOutputStream;


public class Maximize extends AppCompatActivity {

    ImageView CB;
    ImageView DI;
    byte[] byteArray1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.max);
//        getWindow().setFlags(WindowManager.LayoutParams.FLAG_SECURE, WindowManager.LayoutParams.FLAG_SECURE);

        Intent intent = getIntent();
        byte[] byteArray = intent.getByteArrayExtra("imageBytes");
        Bitmap receivedBitmap = BitmapFactory.decodeByteArray(byteArray, 0, byteArray.length);
        ImageView imageView = findViewById(R.id.maxImage);
        imageView.setImageBitmap(receivedBitmap);


        CB = findViewById(R.id.cancel_button);
        CB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                ByteArrayOutputStream stream = new ByteArrayOutputStream();
//                receivedBitmap.compress(Bitmap.CompressFormat.PNG, 100, stream);
//                byteArray1 = stream.toByteArray();

                Intent intent = new Intent(Maximize.this, SecondActivity.class);
//                intent.putExtra("imageBytes1", byteArray1);
                startActivity(intent);


            }
        });
    }
    public void onBackPressed() {
        Intent intent = new Intent(Maximize.this, SecondActivity.class);
//        intent.putExtra("imageBytes1", byteArray1);
        startActivity(intent);
        finish();
    }
}