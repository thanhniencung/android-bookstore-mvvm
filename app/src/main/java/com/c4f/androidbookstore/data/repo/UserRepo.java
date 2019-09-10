package com.c4f.androidbookstore.data.repo;

import com.c4f.androidbookstore.data.local.OrderTable;
import com.c4f.androidbookstore.data.local.UserTable;
import com.c4f.androidbookstore.data.service.OrderService;
import com.c4f.androidbookstore.data.service.UserService;
import com.c4f.androidbookstore.model.BaseResponse;
import com.c4f.androidbookstore.model.User;
import com.c4f.androidbookstore.network.BookStoreApi;
import com.c4f.androidbookstore.network.RestResponse;

import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import okhttp3.RequestBody;

public class UserRepo {
    private UserTable userTable;
    private UserService userService;

    public UserRepo(UserTable userTable, UserService userService) {
        this.userTable = userTable;
        this.userService = userService;
    }

    public Single<BaseResponse<User>> signIn(RequestBody requestBody) {
        return userService.signIn(requestBody)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }
}
