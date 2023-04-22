package com.ssg.sales.model.analytics;

import lombok.Data;

@Data
public class MonthlySalesCount extends SalesCountAgg {
    String month;

    public MonthlySalesCount(long count, String month){
        super(count);
        this.month = month;
    }
}
