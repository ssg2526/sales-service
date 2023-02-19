package com.ssg.sales.controller;

import com.ssg.sales.model.CustomerDetails;
import com.ssg.sales.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("customer/api/v1")
public class CustomerController {

    @Autowired
    CustomerService customerService;

    @RequestMapping(value = "/addCustomer", method = RequestMethod.POST)
    public ResponseEntity<CustomerDetails> addCustomer(@RequestBody CustomerDetails customerDetails,
                                                       @RequestHeader Map<String, Object> headers){
        CustomerDetails customerDetails1 = customerService.addCustomer(customerDetails);
        return new ResponseEntity<>(customerDetails1, HttpStatus.CREATED);
    }
}
