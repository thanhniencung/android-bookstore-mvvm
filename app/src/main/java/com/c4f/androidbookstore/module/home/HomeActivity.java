package com.c4f.androidbookstore.module.home;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.c4f.androidbookstore.R;
import com.c4f.androidbookstore.base.BaseActivity;
import com.c4f.androidbookstore.data.repo.ProductRepo;
import com.c4f.androidbookstore.data.service.ProductService;
import com.c4f.androidbookstore.model.Product;
import com.c4f.androidbookstore.module.home.adapter.ProductAdapter;
import com.c4f.androidbookstore.network.BookStoreApi;
import com.c4f.androidbookstore.network.NetworkCallback;

import java.util.List;

public class HomeActivity extends BaseActivity {
    private RecyclerView recyclerView;

    private HomeViewModel homeViewModel;
    private ProductAdapter productAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        homeViewModel = new HomeViewModel();
        homeViewModel.inject(new ProductRepo(
                BookStoreApi.getProductService()
        ));

        homeViewModel.getProductList(new NetworkCallback<List<Product>>() {
            @Override
            public void onSuccess(List<Product> data) {
                // display to listview
                displayProductList(data);
            }

            @Override
            public void onError(int code, String msg) {

            }
        });
    }

    @Override
    public int getViewId() {
        return R.layout.activity_home;
    }

    @Override
    public void initView() {
        recyclerView = findViewById(R.id.productListView);
    }

    private void displayProductList(List<Product> data) {
        LinearLayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        layoutManager.setOrientation(RecyclerView.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);

        productAdapter = new ProductAdapter();
        recyclerView.setAdapter(productAdapter);

        productAdapter.setData(data);
    }
}
