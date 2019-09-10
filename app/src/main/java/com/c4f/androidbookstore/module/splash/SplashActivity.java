package com.c4f.androidbookstore.module.splash;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.c4f.androidbookstore.R;
import com.c4f.androidbookstore.module.signin.SignInActivity;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(
                        SplashActivity.this,
                        SignInActivity.class);

                startActivity(intent);
            }
        }, 2000);
    }
}
