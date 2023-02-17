package com.ssg.sales.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "settlement_detail")
@Data
public class SettlementDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "payment_mode")
    private PaymentModeEnum paymentMode;
    @Column(name = "amount")
    private Double amount;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "settlement_id")
    private Settlement settlement;

    public Integer getSettlement(){
        return this.settlement.getId();
    }
}
