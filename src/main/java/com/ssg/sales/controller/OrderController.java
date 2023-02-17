package com.ssg.sales.controller;

import com.ssg.sales.model.Order;
import com.ssg.sales.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/order/api/v1")
public class OrderController {

    @Autowired
    OrderService orderService;

    @RequestMapping(value = "/generateOrder", method = RequestMethod.POST)
    public Order generateOrder(@RequestBody Order order, @RequestHeader Map<String, Object> headers){
        return orderService.generateOrder(order);
    }

    @RequestMapping(value = "/updateOrder", method = RequestMethod.PUT)
    public Order updateOrder(@RequestBody Order order, @RequestHeader Map<String, Object> headers){
        return orderService.updateOrder(order);
    }
}
