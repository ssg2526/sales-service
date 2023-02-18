package com.ssg.sales.controller.restaurant;

import com.ssg.sales.model.Invoice;
import com.ssg.sales.model.Kot;
import com.ssg.sales.model.Seating;
import com.ssg.sales.model.Settlement;
import com.ssg.sales.service.restaurant.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/restaurant/api/v1")
public class RestaurantController {

    @Autowired
    RestaurantService restaurantService;

    @RequestMapping(value = "/doKot", method = RequestMethod.POST)
    public ResponseEntity<Seating> doKot(@RequestBody Kot kot,
                                        @RequestParam("tableId") int tableId,
                                        @RequestHeader Map<String, Object> headers){

        Seating seating = restaurantService.doKot(kot, tableId);
        return new ResponseEntity<>(seating, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/doBill", method = RequestMethod.POST)
    public ResponseEntity<Seating> doBill(@RequestBody Invoice invoice,
                                          @RequestParam("tableId") int tableId,
                                          @RequestHeader Map<String, Object> headers){
        Seating seating = restaurantService.doBill(invoice, tableId);
        return new ResponseEntity<>(seating, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/settle", method = RequestMethod.POST)
    public ResponseEntity<Seating> settleBill(@RequestBody Settlement settlement,
                                              @RequestParam("tableId") int tableId,
                                              @RequestHeader Map<String, Object> headers){
        Seating seating = restaurantService.settleBill(settlement, tableId);
        return new ResponseEntity<>(seating, HttpStatus.CREATED);
    }
}
