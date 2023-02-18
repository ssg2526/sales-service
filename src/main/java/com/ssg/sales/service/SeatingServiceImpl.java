package com.ssg.sales.service;

import com.ssg.sales.model.Seating;
import com.ssg.sales.model.context.model.ContextProps;
import com.ssg.sales.model.context.model.DBContext;
import com.ssg.sales.repository.SeatingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SeatingServiceImpl implements SeatingService{

    @Autowired
    SeatingRepository seatingRepository;

    @Override
    public List<Seating> getAllTables() {
        ContextProps cp = DBContext.getCurrentDBContext();
        return seatingRepository.findByOrgIdAndBranchIdOrderByTableNo(cp.getOrgId(), cp.getBranchId());
    }

    @Override
    public Seating updateTable(Seating seating) {
        return seatingRepository.save(seating);
    }


}
