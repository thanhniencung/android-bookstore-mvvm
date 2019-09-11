package com.c4f.androidbookstore.network;

import com.c4f.androidbookstore.BookStoreApplication;
import com.c4f.androidbookstore.data.constant.Constant;
import com.c4f.androidbookstore.helper.SPref;

import java.io.IOException;

import okhttp3.Headers;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

public class RequestInterceptor implements Interceptor {
    @Override
    public Response intercept(Interceptor.Chain chain) throws IOException {
        Request originalRequest = chain.request();

        String token = SPref.getSharedPreferenceString(
                BookStoreApplication.getApp(),
                Constant.User.KEY_TOKEN,
                ""
        );

        Request.Builder builder = originalRequest.newBuilder();
        if (!token.isEmpty()) {
            String bearer = String.format("Bearer %s", token);
            Headers headers = new Headers.Builder()
                    .add("Authorization", bearer)
                    .build();
            builder.headers(headers);
        }

        Request newRequest = builder.build();
        Response response = chain.proceed(newRequest);

        return response;
    }
}
