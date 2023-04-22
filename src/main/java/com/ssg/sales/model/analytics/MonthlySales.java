package com.ssg.sales.model.analytics;

import lombok.Data;

@Data
public class MonthlySales extends SalesAgg{

    String month;

    public MonthlySales(Double sales, String month){
        super(sales);
        this.month = month;
    }
}
