package com.c4f.androidbookstore.data.service;

import com.c4f.androidbookstore.data.constant.Constant;
import com.c4f.androidbookstore.model.BaseResponse;
import com.c4f.androidbookstore.model.Product;
import com.c4f.androidbookstore.model.User;

import java.util.List;

import io.reactivex.Single;
import okhttp3.RequestBody;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface ProductService {
    @GET("product/list")
    Single<BaseResponse<List<Product>>> getProductList();
}
