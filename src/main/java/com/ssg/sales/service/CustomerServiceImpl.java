package com.ssg.sales.service;

import com.ssg.sales.model.CustomerDetails;
import com.ssg.sales.model.context.model.ContextProps;
import com.ssg.sales.model.context.model.DBContext;
import com.ssg.sales.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    CustomerRepository customerRepository;

    @Override
    public CustomerDetails addCustomer(CustomerDetails customerDetails) {
        ContextProps cp = DBContext.getCurrentDBContext();
        customerDetails.setOrgId(cp.getOrgId());
        customerDetails.setBranchId(cp.getBranchId());
        CustomerDetails customerDetails1 = customerRepository.getByOrgIdAndBranchIdAndContact(cp.getOrgId(), cp.getBranchId(), customerDetails.getContact());
        if(customerDetails1 != null){
            return customerDetails1;
        }
        return customerRepository.save(customerDetails);
    }
}
