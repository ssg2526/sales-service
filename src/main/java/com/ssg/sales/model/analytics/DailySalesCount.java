package com.ssg.sales.model.analytics;

import lombok.Data;

import java.util.Date;

@Data
public class DailySalesCount extends SalesCountAgg {
    Date date;

    public DailySalesCount(long count, Date date){
        super(count);
        this.date = date;
    }
}
