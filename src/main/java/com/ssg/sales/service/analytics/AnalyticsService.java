package com.ssg.sales.service.analytics;

import com.ssg.sales.enums.SalesAggType;
import com.ssg.sales.model.analytics.PaymentAgg;
import com.ssg.sales.model.analytics.SalesAgg;
import com.ssg.sales.model.analytics.SalesCountAgg;

import java.util.List;

public interface AnalyticsService {
    List<SalesAgg> getDailySalesAggregation(SalesAggType aggType);
    List<SalesCountAgg> getDailySalesCountAggregation(SalesAggType aggType);
    List<PaymentAgg> getDailyPaymentAggregation(SalesAggType aggType);
}
