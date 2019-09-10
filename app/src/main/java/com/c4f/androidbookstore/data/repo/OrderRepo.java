package com.c4f.androidbookstore.data.repo;

import com.c4f.androidbookstore.data.local.OrderTable;
import com.c4f.androidbookstore.data.service.OrderService;

public class OrderRepo {
    private OrderTable orderTable;
    private OrderService orderService;

    public OrderRepo(OrderTable orderTable, OrderService orderService) {
        this.orderTable = orderTable;
        this.orderService = orderService;
    }



}
