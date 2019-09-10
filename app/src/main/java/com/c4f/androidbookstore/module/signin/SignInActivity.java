package com.c4f.androidbookstore.module.signin;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;

import com.c4f.androidbookstore.R;

public class SignInActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_signin);

        SignViewViewModel signViewViewModel =
                SignViewViewModel.of(this);

        signViewViewModel.doLogin("09739017890", "123456");
    }
}
