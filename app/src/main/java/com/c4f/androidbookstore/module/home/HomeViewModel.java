package com.c4f.androidbookstore.module.home;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProviders;

import com.c4f.androidbookstore.data.repo.ProductRepo;
import com.c4f.androidbookstore.data.repo.UserRepo;
import com.c4f.androidbookstore.model.BaseResponse;
import com.c4f.androidbookstore.model.Product;
import com.c4f.androidbookstore.module.signin.SignViewViewModel;
import com.c4f.androidbookstore.network.NetworkCallback;
import com.c4f.androidbookstore.network.RestResponse;

import java.util.List;

import io.reactivex.Single;

public class HomeViewModel extends ViewModel {
    private ProductRepo productRepo;

    public static HomeViewModel of(AppCompatActivity activity) {
        return ViewModelProviders.of(activity)
                .get(HomeViewModel.class);
    }

    void inject(ProductRepo productRepo) {
        this.productRepo = productRepo;
    }

    void getProductList(final NetworkCallback<List<Product>> callback) {
        productRepo.getProductList()
                .subscribe(new RestResponse<BaseResponse<List<Product>>>() {
                    @Override
                    public void onData(BaseResponse<List<Product>> data) {
                        callback.onSuccess(data.getData());
                    }

                    @Override
                    public void onError(int code, String msg) {
                        callback.onError(code, msg);
                    }
                });
    }

}
