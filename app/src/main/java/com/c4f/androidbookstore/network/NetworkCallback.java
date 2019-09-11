package com.c4f.androidbookstore.network;

public interface NetworkCallback<T> {
    void onSuccess(T data);
    void onError(int code, String msg);
}
