package com.example.valentine;

import androidx.appcompat.app.AppCompatActivity;

import android.app.TaskStackBuilder;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

public class SplashScreen extends AppCompatActivity {

    SharedPreferences preferences;
    SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        preferences = this.getSharedPreferences("splash", MODE_PRIVATE);
        editor = preferences.edit();

        ImageView imageView = findViewById(R.id.splash_img);
        Glide.with(this).asGif().load(R.raw.couple).into(imageView);

        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
            @Override
            public void run() {

                if (preferences.getBoolean("isMain",false)){
                    startActivity(new Intent(SplashScreen.this, MainActivity.class));
                    finish();
                }else {
                    editor.putBoolean("isMain",true);
                    editor.apply();

                    TaskStackBuilder.create(SplashScreen.this)
                            .addNextIntentWithParentStack(new Intent(SplashScreen.this, MainActivity.class))
                            .addNextIntent(new Intent(SplashScreen.this, IntroActivity.class))
                            .startActivities();
                }


            }
        },5000);

    }
}