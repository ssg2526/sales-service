package com.ssg.sales.model.analytics;

import com.ssg.sales.model.PaymentModeEnum;
import lombok.Data;

import java.util.Date;

@Data
public class DailyPaymentMode extends PaymentAgg {
    Date date;

    public DailyPaymentMode(Double amount, PaymentModeEnum mode, Date date){
        super(amount, mode);
        this.date = date;
    }
}
