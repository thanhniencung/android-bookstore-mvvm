package com.c4f.androidbookstore.data.repo;

import com.c4f.androidbookstore.data.local.UserTable;
import com.c4f.androidbookstore.data.service.ProductService;
import com.c4f.androidbookstore.data.service.UserService;
import com.c4f.androidbookstore.model.BaseResponse;
import com.c4f.androidbookstore.model.Product;
import com.c4f.androidbookstore.model.User;

import java.util.List;

import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import okhttp3.RequestBody;

public class ProductRepo {
    private ProductService productService;

    public ProductRepo(ProductService productService) {
        this.productService = productService;
    }

    public Single<BaseResponse<List<Product>>> getProductList() {
        return productService.getProductList()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }
}
