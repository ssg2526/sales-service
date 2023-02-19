package com.ssg.sales.controller;

import com.ssg.sales.model.Kot;
import com.ssg.sales.model.Seating;
import com.ssg.sales.service.KotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("kot/api/v1")
public class KotController {

    @Autowired
    KotService kotService;

    @RequestMapping(method = RequestMethod.GET, value = "/getKotByOrder")
    public ResponseEntity<List<Kot>> getKotByOrder(@RequestParam("orderId") Long orderId,
                                                   @RequestHeader Map<String, Object> headers){
        List<Kot> kotList = kotService.getKotListByOrder(orderId);

        return new ResponseEntity<List<Kot>>(kotList, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/addKot")
    public ResponseEntity<Kot> generateKot(@RequestBody Kot kot,
                                           @RequestHeader Map<String, Object> headers) {
        return new ResponseEntity<Kot>(kotService.addKot(kot), HttpStatus.CREATED);
    }
}
