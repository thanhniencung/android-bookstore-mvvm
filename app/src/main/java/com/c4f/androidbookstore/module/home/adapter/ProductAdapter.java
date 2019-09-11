package com.c4f.androidbookstore.module.home.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.c4f.androidbookstore.R;
import com.c4f.androidbookstore.event.ImageClickEvent;
import com.c4f.androidbookstore.model.Product;
import com.squareup.picasso.Picasso;

import org.greenrobot.eventbus.EventBus;

import java.util.ArrayList;
import java.util.List;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.RepoViewHolder> {
    private List<Product> productList = new ArrayList<>();

    public void setData(List<Product> productList) {
        this.productList.addAll(productList);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public RepoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // khởi tạo UI của 1 row thông qua xml
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.adapter_product, parent, false);
        return new RepoViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull RepoViewHolder holder, int position) {
        // bind dữ liệu từ bên ngoài vào file xml
        Product product = productList.get(position);

        Picasso.get().load(product.productImage).into(holder.ivProduct);
        holder.tvProductitle.setText(product.productName);
        holder.tvProductPrice.setText(String.valueOf(product.price));
    }

    @Override
    public int getItemCount() {
        // listview có bao nhiêu phần tử
        return productList.size();
    }

    public class RepoViewHolder extends RecyclerView.ViewHolder {
        public ImageView ivProduct;
        public TextView tvProductitle;
        public TextView tvProductPrice;

        public RepoViewHolder(@NonNull View itemView) {
            super(itemView);

            ivProduct = itemView.findViewById(R.id.ivProduct);
            tvProductitle = itemView.findViewById(R.id.tvProductTitle);
            tvProductPrice = itemView.findViewById(R.id.tvProductPrice);

            ivProduct.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    EventBus.getDefault().post(
                            new ImageClickEvent());
                }
            });
        }
    }
}
