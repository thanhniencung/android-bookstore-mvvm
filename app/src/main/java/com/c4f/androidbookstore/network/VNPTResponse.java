package com.c4f.androidbookstore.network;

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
            onError(response.code());
        }
    }

    @Override
    public void onFailure(Call<T> call, Throwable t) {
        onError(UNKNOWN);
    }

    public abstract void onData(T data);
    public abstract void onError(int code);
}