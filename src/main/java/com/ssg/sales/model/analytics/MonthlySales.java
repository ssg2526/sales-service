package com.ssg.sales.model.analytics;

import lombok.Data;

@Data
public class MonthlySales extends SalesAgg{

    int month;

    public MonthlySales(Double sales, int month){
        super(sales);
        this.month = month;
    }
}
