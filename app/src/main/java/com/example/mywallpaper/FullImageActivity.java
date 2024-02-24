package com.example.mywallpaper;

import androidx.appcompat.app.AppCompatActivity;

import android.app.WallpaperManager;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.google.android.material.button.MaterialButton;

import java.io.IOException;

public class FullImageActivity extends AppCompatActivity {

    ImageView imageView;
    MaterialButton materialButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_full_image);

        imageView = findViewById(R.id.full_img);
        materialButton = findViewById(R.id.btn_apply);

        Glide.with(this).load(getIntent().getStringExtra("image")).into(imageView);

        materialButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                setBackground();

            }
        });
    }
    private void setBackground(){

        Bitmap bitmap =((BitmapDrawable)imageView.getDrawable()).getBitmap();

        WallpaperManager wallpaperManager = WallpaperManager.getInstance(getApplicationContext());

        try {
            wallpaperManager.setBitmap(bitmap);
        } catch (IOException e) {

            Toast.makeText(this, "Error"+e.getMessage(), Toast.LENGTH_SHORT).show();
            throw new RuntimeException(e);
        }

    }
}