package com.ssg.sales.controller;

import com.ssg.sales.model.Item;
import com.ssg.sales.service.ItemService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
@Slf4j
@RestController
@RequestMapping("/item-service/api/v1")
public class ItemController {

    @Autowired
    ItemService itemService;

    @RequestMapping(method = RequestMethod.POST, value = "/addItem")
    public ResponseEntity<String> createItem(@RequestBody Item item, @RequestHeader Map<String, Object> headers) {
        itemService.createItem(item);
        return new ResponseEntity<>("Success", HttpStatus.CREATED);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/editItem")
    public ResponseEntity<String> updateItem(@RequestBody Item item, @RequestHeader Map<String, Object> headers) {
        itemService.updateItem(item);
        return new ResponseEntity<>("Success", HttpStatus.CREATED);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/contains")
    public ResponseEntity<List<Item>> getItemsContaining(@RequestParam("searchText") String searchText,
                                                         @RequestHeader Map<String, Object> headers){
        List<Item> itemList = itemService.searchItemsContaining(searchText);

        return new ResponseEntity<List<Item>>(itemList, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/getitem")
    public ResponseEntity<List<Item>> getItemsByCode(@RequestParam("itemCode") int itemCode,
                                                         @RequestHeader Map<String, Object> headers){
        List<Item> itemList = itemService.fetchItemByCode(itemCode);

        return new ResponseEntity<List<Item>>(itemList, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/getitembycategory")
    public ResponseEntity<List<Item>> getItemsByCategory(@RequestParam("categoryId") int categoryId,
                                                     @RequestHeader Map<String, Object> headers){
        List<Item> itemList = itemService.fetchItemByCategory(categoryId);

        return new ResponseEntity<List<Item>>(itemList, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/all-items")
    public ResponseEntity<List<Item>> getAllItems(@RequestHeader Map<String, Object> headers){
        List<Item> itemList = itemService.getAllItems();
        return new ResponseEntity<List<Item>>(itemList, HttpStatus.OK);
    }
}
