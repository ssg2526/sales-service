package com.ssg.sales.model.analytics;

import com.ssg.sales.model.PaymentModeEnum;
import lombok.Data;

@Data
public class MonthlyPaymentMode extends PaymentAgg {

    String month;
    public MonthlyPaymentMode(Double amount, PaymentModeEnum mode, String month){
        super(amount, mode);
        this.month = month;
    }

}
