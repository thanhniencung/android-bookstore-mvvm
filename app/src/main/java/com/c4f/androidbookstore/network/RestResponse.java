package com.c4f.androidbookstore.network;

import io.reactivex.observers.DisposableSingleObserver;
import retrofit2.HttpException;

public abstract class RestResponse<T> extends DisposableSingleObserver<T> {
    public static final int UNKNOWN = -1;
    @Override
    public void onSuccess(T data) {
        onData(data);
    }

    @Override
    public void onError(Throwable e) {
        if (e instanceof HttpException) {
            HttpException httpException = ((HttpException) e);
            onError(httpException.code(), httpException.message());
        } else {
            onError(UNKNOWN, e.getMessage());
        }
    }

    public abstract void onData(T data);
    public abstract void onError(int code, String msg);
}
