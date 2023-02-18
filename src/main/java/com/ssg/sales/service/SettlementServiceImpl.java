package com.ssg.sales.service;

import com.ssg.sales.model.Settlement;
import com.ssg.sales.repository.SettlementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SettlementServiceImpl implements SettlementService {

    @Autowired
    SettlementRepository settlementRepository;

    @Override
    public Settlement addSettlement(Settlement settlement) {
        settlement.getSettlementDetails().forEach(settlementDetail -> {
            settlementDetail.setSettlement(settlement);
        });
        return settlementRepository.save(settlement);
    }
}
