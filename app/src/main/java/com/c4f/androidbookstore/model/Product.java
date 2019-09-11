package com.c4f.androidbookstore.model;

import com.google.gson.annotations.SerializedName;

/*
 {
      "UserId": "84295389-3273-4180-b5a9-ccd609b6eaa2",
      "productId": "7bac4ce4-cff0-11e9-b736-8c8590cefb77",
      "productName": "MẸ BIẾT LƯỜI CON NÊN NGƯỜI",
      "productImage": "https://cdn0.fahasa.com/media/catalog/product/cache/1/image/9df78eab33525d08d6e5fb8d27136e95/5/d/5dd81967401bc87ed984defffbe63360.jpg",
      "quantity": 70,
      "soldItems": 0,
      "price": 400000,
      "cateId": "KIDS",
      "createdAt": "2019-09-05T22:18:58.580031+07:00",
      "updatedAt": "2019-09-05T22:18:58.580032+07:00"
    }
 */
public class Product {
    @SerializedName("UserId")
    public String userId;

    @SerializedName("productId")
    public String productId;

    @SerializedName("productName")
    public String productName;

    @SerializedName("productImage")
    public String productImage;

    @SerializedName("quantity")
    public int quantity;

    @SerializedName("price")
    public double price;
}
