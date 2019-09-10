package com.c4f.androidbookstore.module.signin;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProviders;

import com.c4f.androidbookstore.model.BaseResponse;
import com.c4f.androidbookstore.model.RestError;
import com.c4f.androidbookstore.model.User;
import com.c4f.androidbookstore.network.BookStoreApi;
import com.c4f.androidbookstore.network.VNPTResponse;

import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

public class SignViewViewModel extends ViewModel {
    public interface SignInCallBack<T> {
        void onSuccess(T data);
    }

    public static SignViewViewModel of(AppCompatActivity activity) {
        return ViewModelProviders.of(activity)
                        .get(SignViewViewModel.class);
    }
    void doLogin(String phone, String pass, final SignInCallBack callBack) {
        if (phone.isEmpty() || pass.isEmpty()) {
            return;
        }

        BookStoreApi.getUserService()
                .signIn(User.signInRequestBody(phone, pass))
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<BaseResponse<User>>() {
                    @Override
                    public void accept(BaseResponse<User> userBaseResponse) throws Exception {
                        callBack.onSuccess(userBaseResponse);
                    }
                });

    }
}
