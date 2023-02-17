package com.ssg.sales.service;

import com.ssg.sales.model.Order;
import com.ssg.sales.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    OrderRepository orderRepository;

    @Override
    public Order generateOrder(Order order) {
        return orderRepository.save(order);
    }

    @Override
    public Order updateOrder(Order order) {
        return orderRepository.save(order);
    }
}
