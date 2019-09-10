package com.c4f.androidbookstore.module.signin;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.c4f.androidbookstore.R;
import com.c4f.androidbookstore.model.BaseResponse;
import com.c4f.androidbookstore.model.RestError;
import com.c4f.androidbookstore.model.User;

import javax.xml.transform.Templates;

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

        btnSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // handle click
                String phone = editPhone.getEditableText().toString();
                String password = editPassword.getEditableText().toString();

                signViewViewModel.doLogin(phone, password);
            }
        });

        handleSignSuccess();
        handleSignInFail();
    }

    void handleSignSuccess() {
        signViewViewModel.getSignInResponse().observe(this, new Observer<BaseResponse<User>>() {
            @Override
            public void onChanged(BaseResponse<User> userBaseResponse) {
                tvSignStatus.setVisibility(View.INVISIBLE);
                Toast.makeText(SignInActivity.this, "ok", Toast.LENGTH_SHORT).show();
            }
        });
    }

    void handleSignInFail() {
        signViewViewModel.getSignInRestError().observe(this, new Observer<RestError>() {
            @Override
            public void onChanged(RestError restError) {
                tvSignStatus.setVisibility(View.VISIBLE);
                tvSignStatus.setText(restError.errMsg);
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
