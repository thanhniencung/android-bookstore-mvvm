package com.c4f.androidbookstore.network;

import com.c4f.androidbookstore.data.service.OrderService;
import com.c4f.androidbookstore.data.service.ProductService;
import com.c4f.androidbookstore.data.service.UserService;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

// retrofit => https://square.github.io/retrofit/
public class BookStoreApi {

    static Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("http://10.0.2.2:8000/")
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    public static UserService getUserService() {
        return retrofit.create(UserService.class);
    }

    public static OrderService getOrderService() {
        return retrofit.create(OrderService.class);
    }

    public static ProductService getProductService() {
        return retrofit.create(ProductService.class);
    }
}
