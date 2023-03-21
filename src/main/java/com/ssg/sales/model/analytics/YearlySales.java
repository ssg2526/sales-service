package com.ssg.sales.model.analytics;

import lombok.Data;

@Data
public class YearlySales extends SalesAgg {

    int year;

    public YearlySales(Double sales, int year){
        super(sales);
        this.year = year;
    }
}
