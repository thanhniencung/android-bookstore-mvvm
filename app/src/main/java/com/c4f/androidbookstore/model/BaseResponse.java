package com.c4f.androidbookstore.model;

import com.google.gson.annotations.SerializedName;

/**
 * {
 *     "code": 200,
 *     "message": "OK",
 *     "data": {
 *         "displayName": "Ryan Nguyen",
 *         "avatar": "https://static2.yan.vn/YanThumbNews/2167221/201711/300x300_3c55ff92-b133-4729-8ce3-2f3d881d5841.jpg",
 *         "token": "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VySWQiOiJlMjRkNjkxZC0wYWE3LTQ4NTItYmIzNC1mOWEyNzkwZTA2NGIiLCJyb2xlIjoiTUVNQkVSIiwicGhvbmVOdW5iZXIiOiIwOTczOTAxNzg5IiwiZXhwIjoxNTgxMDU5MTIxfQ.jMB2jP8RIn7UTR9AiQYMm5fWdZxnE-3fZkyS2lYeKWo"
 *     }
 * }
 */
public class BaseResponse<T> {
    @SerializedName("code")
    int code;

    @SerializedName("message")
    String message;

    @SerializedName("data")
    T data;

    public T getData() {
        return data;
    }
}
