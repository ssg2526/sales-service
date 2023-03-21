package com.ssg.sales.model.analytics;

import com.ssg.sales.model.PaymentModeEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PaymentAgg {
    Double amount;
    PaymentModeEnum modeOfPay;
}
