package com.c4f.androidbookstore.module.signin;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProviders;

import com.c4f.androidbookstore.model.BaseResponse;
import com.c4f.androidbookstore.model.User;
import com.c4f.androidbookstore.network.BookStoreApi;
import com.c4f.androidbookstore.network.VNPTResponse;

public class SignViewViewModel extends ViewModel {
    public static SignViewViewModel of(AppCompatActivity activity) {
        return ViewModelProviders.of(activity)
                        .get(SignViewViewModel.class);
    }
    void doLogin(String phone, String pass) {
        if (phone.isEmpty() || pass.isEmpty()) {
            return;
        }
        // call api
        BookStoreApi.getUserService()
                .signIn(User.signInRequestBody("", ""))
                .enqueue(new VNPTResponse<BaseResponse<User>>() {
                    @Override
                    public void onData(BaseResponse<User> data) {

                    }

                    @Override
                    public void onError(int code) {

                    }
                });

    }
}
