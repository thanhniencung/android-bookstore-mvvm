package com.c4f.androidbookstore.module.signin;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProviders;

import com.c4f.androidbookstore.data.repo.UserRepo;
import com.c4f.androidbookstore.model.BaseResponse;
import com.c4f.androidbookstore.model.User;
import com.c4f.androidbookstore.network.NetworkCallback;
import com.c4f.androidbookstore.network.RestResponse;

public class SignViewViewModel extends ViewModel {
    private UserRepo userRepo;

    public static SignViewViewModel of(AppCompatActivity activity) {
        return ViewModelProviders.of(activity)
                .get(SignViewViewModel.class);
    }

    void inject(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    void doLogin(String phone, String pass, final NetworkCallback callBack) {
        if (phone.isEmpty() || pass.isEmpty()) {
            return;
        }

        userRepo.signIn(User.signInRequestBody(phone, pass))
                .subscribe(new RestResponse<BaseResponse<User>>() {
                    @Override
                    public void onData(BaseResponse<User> data) {
                        callBack.onSuccess(data);
                    }

                    @Override
                    public void onError(int code, String msg) {
                        callBack.onError(code, msg);
                    }
                });

    }
}
