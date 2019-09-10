package com.c4f.androidbookstore.data.service;

import com.c4f.androidbookstore.model.BaseResponse;
import com.c4f.androidbookstore.model.User;

import io.reactivex.Completable;
import io.reactivex.Observable;
import io.reactivex.Single;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface UserService {
    @POST("user/sign-in")
    Single<BaseResponse<User>> signIn(@Body RequestBody body);
}
