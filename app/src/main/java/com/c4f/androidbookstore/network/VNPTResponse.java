package com.c4f.androidbookstore.network;

import com.c4f.androidbookstore.model.RestError;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public abstract class VNPTResponse<T> implements Callback<T> {
    private static final int UNKNOWN = -1;
    @Override
    public void onResponse(Call<T> call, Response<T> response) {
        if (response.isSuccessful()) {
            onData(response.body());
        } else {
            RestError restError = new RestError();
            restError.code = response.code();
            restError.errMsg = "Đăng nhập không thành công";
            onError(restError);
        }
    }

    @Override
    public void onFailure(Call<T> call, Throwable t) {
        RestError restError = new RestError();
        restError.code = UNKNOWN;
        restError.errMsg = t.getMessage();
        onError(restError);
    }

    public abstract void onData(T data);
    public abstract void onError(RestError error);
}