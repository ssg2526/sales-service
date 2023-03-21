package com.ssg.sales.controller.analytics;

import com.ssg.sales.enums.SalesAggType;
import com.ssg.sales.model.Category;
import com.ssg.sales.model.analytics.DailySales;
import com.ssg.sales.model.analytics.PaymentAgg;
import com.ssg.sales.model.analytics.SalesAgg;
import com.ssg.sales.model.analytics.SalesCountAgg;
import com.ssg.sales.service.analytics.AnalyticsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/analytics/api/v1")
public class AnalyticsController {

    @Autowired
    AnalyticsService analyticsService;

    @RequestMapping(method = RequestMethod.GET, value = "/getSales")
    public ResponseEntity<List<SalesAgg>> getSalesAggs(@RequestParam("salesAggType") SalesAggType salesAggType,
                                                       @RequestHeader Map<String, Object> headers){
        List<SalesAgg> salesAggs = analyticsService.getDailySalesAggregation(salesAggType);
        return new ResponseEntity<List<SalesAgg>>(salesAggs, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/getSalesCountAgg")
    public ResponseEntity<List<SalesCountAgg>> getSalesCountAggs(@RequestParam("salesAggType") SalesAggType salesAggType,
                                                                 @RequestHeader Map<String, Object> headers){
        List<SalesCountAgg> salesCountAggs = analyticsService.getDailySalesCountAggregation(salesAggType);
        return new ResponseEntity<List<SalesCountAgg>>(salesCountAggs, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/getPaymentModeAgg")
    public ResponseEntity<List<PaymentAgg>> getPaymentModeAggs(@RequestParam("salesAggType") SalesAggType salesAggType,
                                                               @RequestHeader Map<String, Object> headers){
        List<PaymentAgg> paymentModeAggs = analyticsService.getDailyPaymentAggregation(salesAggType);
        return new ResponseEntity<List<PaymentAgg>>(paymentModeAggs, HttpStatus.OK);
    }
}
