package com.c4f.androidbookstore.module.signin;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.c4f.androidbookstore.MainActivity;
import com.c4f.androidbookstore.R;
import com.c4f.androidbookstore.data.local.UserTable;
import com.c4f.androidbookstore.data.repo.UserRepo;
import com.c4f.androidbookstore.data.service.UserService;
import com.c4f.androidbookstore.network.BookStoreApi;

public class SignInActivity extends AppCompatActivity {
    private TextView tvSignStatus;
    private EditText editPhone;
    private EditText editPassword;
    private Button btnSignIn;

    private SignViewViewModel signViewViewModel;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_signin);
        initView();

        signViewViewModel =
                SignViewViewModel.of(this);

        signViewViewModel.inject(new UserRepo(
                new UserTable(),
                BookStoreApi.getUserService()
        ));

        btnSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String phone = editPhone.getEditableText().toString();
                String password = editPassword.getEditableText().toString();

                signViewViewModel.doLogin(phone, password,
                        new SignViewViewModel.SignInCallBack() {
                            @Override
                            public void onSuccess(Object data) {
                                Intent intent = new Intent(SignInActivity.this, MainActivity.class);
                                startActivity(intent);
                            }

                            @Override
                            public void onError(int code, String msg) {
                                tvSignStatus.setVisibility(View.VISIBLE);
                                tvSignStatus.setText(msg);
                            }
                   });
            }
        });
    }

    void initView() {
        tvSignStatus = findViewById(R.id.signStatus);
        editPhone = findViewById(R.id.phone);
        editPassword = findViewById(R.id.password);
        btnSignIn = findViewById(R.id.signIn);
    }
}
