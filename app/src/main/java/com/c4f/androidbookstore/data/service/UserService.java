package com.c4f.androidbookstore.data.service;

import com.c4f.androidbookstore.model.BaseResponse;
import com.c4f.androidbookstore.model.User;

import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface UserService {
    @POST("user/sign-in")
    Call<BaseResponse<User>> signIn(@Body RequestBody body);
}
