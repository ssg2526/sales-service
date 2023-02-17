package com.ssg.sales.service;

import com.ssg.sales.model.Kot;
import com.ssg.sales.model.context.model.ContextProps;
import com.ssg.sales.model.context.model.DBContext;
import com.ssg.sales.repository.KotRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class KotServiceImpl implements KotService{

    @Autowired
    KotRepository kotRepository;

    @Override
    public List<Kot> getKotListByOrder(int orderId) {
        ContextProps cp = DBContext.getCurrentDBContext();
        return kotRepository.findByOrgIdAndBranchIdAndOrderId(cp.getOrgId(), cp.getBranchId(), orderId);
    }
}