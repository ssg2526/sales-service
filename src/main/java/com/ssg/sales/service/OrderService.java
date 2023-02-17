package com.ssg.sales.service;

import com.ssg.sales.model.Order;

public interface OrderService {
    public Order generateOrder(Order order);
    public Order updateOrder(Order order);
}
