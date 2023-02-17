package com.ssg.sales.controller;

import com.ssg.sales.model.Settlement;
import com.ssg.sales.service.SettlementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("settlement/api/v1")
public class SettlementController {

    @Autowired
    SettlementService settlementService;

    @RequestMapping(method = RequestMethod.POST, value = "/settle")
    public ResponseEntity<Settlement> createSettlement(@RequestBody Settlement settlement,
                                                       @RequestHeader Map<String, Object> headers){
        Settlement settlementResp = settlementService.addSettlement(settlement);
        return new ResponseEntity<>(settlementResp, HttpStatus.CREATED);
    }
}
