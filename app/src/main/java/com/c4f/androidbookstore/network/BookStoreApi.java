package com.c4f.androidbookstore.network;

import com.c4f.androidbookstore.data.service.OrderService;
import com.c4f.androidbookstore.data.service.ProductService;
import com.c4f.androidbookstore.data.service.UserService;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

// retrofit => https://square.github.io/retrofit/
public class BookStoreApi {
    private static Retrofit retrofit;

    static BookStoreApi instance = null;

    public static BookStoreApi getInstance() {
        if (instance == null) {
            instance = new BookStoreApi();
        }
        return instance;
    }

    public BookStoreApi() {
        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient client = new OkHttpClient.Builder()
                .addInterceptor(new RequestInterceptor())
                .addInterceptor(logging)
                .build();

        retrofit = new Retrofit.Builder()
                .baseUrl("http://10.0.2.2:8000/")
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
    }


    public UserService getUserService() {
        return retrofit.create(UserService.class);
    }

    public OrderService getOrderService() {
        return retrofit.create(OrderService.class);
    }

    public ProductService getProductService() {
        return retrofit.create(ProductService.class);
    }
}
