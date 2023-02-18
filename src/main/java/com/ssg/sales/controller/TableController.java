package com.ssg.sales.controller;

import com.ssg.sales.model.Item;
import com.ssg.sales.model.Seating;
import com.ssg.sales.service.SeatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("table/api/v1")
public class TableController {

    @Autowired
    SeatingService seatingService;

    @RequestMapping(method = RequestMethod.GET, value = "/getAllTables")
    public ResponseEntity<List<Seating>> getItemsByCode(@RequestHeader Map<String, Object> headers){
        List<Seating> seatingList = seatingService.getAllTables();

        return new ResponseEntity<List<Seating>>(seatingList, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/updateTable")
    public ResponseEntity<Seating> updateSeating(@RequestBody Seating seating,
                                                 @RequestHeader Map<String, Object> headers) {
        Seating seating1 = seatingService.updateTable(seating);
        return new ResponseEntity<>(seating1, HttpStatus.CREATED);
    }
}
