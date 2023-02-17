package com.ssg.sales.controller;

import com.ssg.sales.model.InventoryItem;
import com.ssg.sales.service.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("inventory-service/api/v1")
public class InventoryController {

    @Autowired
    InventoryService inventoryService;

    @RequestMapping(method = RequestMethod.POST, value = "/addStock")
    public ResponseEntity<String> createInventory(@RequestBody InventoryItem inventoryItem, @RequestHeader Map<String, Object> headers){
        inventoryService.createInventoryItem(inventoryItem);
        return new ResponseEntity<>("Success", HttpStatus.CREATED);
    }

//    @RequestMapping(method = RequestMethod.GET, value = "/getallinventory"){
//        inventoryService.getInventoryItem()
//    }

    @RequestMapping(method = RequestMethod.PUT, value = "/editStock")
    public ResponseEntity<String> editInventory(@RequestBody InventoryItem inventoryItem, @RequestHeader Map<String, Object> headers){
        inventoryService.updateInventoryItem(inventoryItem);
        return new ResponseEntity<>("Success", HttpStatus.CREATED);
    }

}
