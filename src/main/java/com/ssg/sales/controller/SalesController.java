package com.ssg.sales.controller;

import com.ssg.sales.model.InventoryItem;
//import com.ssg.sales.model.InventoryLog;
import com.ssg.sales.model.Item;
import com.ssg.sales.model.Invoice;
import com.ssg.sales.service.InventoryService;
import com.ssg.sales.service.InvoiceService;
import com.ssg.sales.service.ItemService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("sales-service/api/v1")
@Slf4j
public class SalesController {


    @Autowired
    InvoiceService invoiceService;

    @Autowired
    InventoryService inventoryService;

    @Autowired
    ItemService itemService;

    @RequestMapping(value = "/getAllSales", method = RequestMethod.GET)
    public String getData(){
        return "hiiii";
    }

    @RequestMapping(value = "/addSales", method = RequestMethod.POST)
    public ResponseEntity<Invoice> createInvoice(@RequestBody Invoice invoice, @RequestHeader Map<String, Object> headers){
        Invoice res = invoiceService.addInvoice(invoice);
        return new ResponseEntity<>(res, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/updateSales/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Invoice> updateInvoice(@RequestBody Invoice order,
                                              @PathVariable("id") Integer orderId,
                                              @RequestHeader Map<String, Object> headers){
        order.setId(orderId);
        Invoice invoice = invoiceService.updateInvoice(order);
        return new ResponseEntity<>(invoice, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/getSales/{id}", method = RequestMethod.GET)
    public ResponseEntity<Invoice> getInvoiceDetailsById(@PathVariable("id") int id, @RequestHeader Map<String, Object> headers){
        Invoice po = invoiceService.getInvoiceDetailsById(id);
        return new ResponseEntity<>(po, HttpStatus.OK);
    }

    @RequestMapping(value = "/getInvoicesByDates", method = RequestMethod.GET)
    public ResponseEntity<List<Invoice>> getOrdersByDate(@RequestParam("from")
                                                               @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate from,
                                                               @RequestParam("to")
                                                               @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate to,
                                                               @RequestParam(value = "page", required = false, defaultValue = "0") int page,
                                                               @RequestParam(value = "size", required = false, defaultValue = "10") int size,
                                                               @RequestHeader Map<String, Object> headers){
        System.out.println("from: "+ from+ " to: "+to+ " headers"+ headers);
        List<Invoice> poList = invoiceService.getInvoicesByDates(from, to, page, size);
        System.out.println(poList);
        return new ResponseEntity<>(poList, HttpStatus.OK);

    }

    @RequestMapping(value = "/getInvoice", method = RequestMethod.GET)
    public ResponseEntity<Invoice> getOrderByInvoice(@RequestParam("invoice") String invoice,
                                                           @RequestHeader Map<String, Object> headers){
        Invoice po = invoiceService.getInvoiceByInvoiceNo(invoice);
        if(po != null)
            System.out.println(po.toString());
        return new ResponseEntity<>(po, HttpStatus.OK);
    }

    @RequestMapping(value = "/getInvoiceByOrder", method = RequestMethod.GET)
    public ResponseEntity<Invoice> getOrderByInvoice(@RequestParam("orderId") Integer orderId,
                                                     @RequestHeader Map<String, Object> headers){
        Invoice po = invoiceService.getInvoiceByOrderId(orderId);
        if(po != null)
            System.out.println(po.toString());
        return new ResponseEntity<>(po, HttpStatus.OK);
    }
}
