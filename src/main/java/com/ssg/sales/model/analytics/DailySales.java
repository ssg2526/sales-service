package com.ssg.sales.model.analytics;

import lombok.Data;
import java.util.Date;

@Data
public class DailySales extends SalesAgg {
    Date date;

    public DailySales(Double sales, Date date){
        super(sales);
        this.date = date;
    }
}
