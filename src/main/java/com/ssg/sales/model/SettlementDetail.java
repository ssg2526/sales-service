package com.ssg.sales.model;

import lombok.Data;

import javax.persistence.*;

@Table(name = "settlement_detail")
@Entity
public class SettlementDetail {

    private static final long serialVersionUID = 42L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "payment_mode")
    @Enumerated(EnumType.STRING)
    private PaymentModeEnum paymentMode;
    @Column(name = "amount")
    private Double amount;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "settlement_id")
    private Settlement settlement;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public PaymentModeEnum getPaymentMode() {
        return paymentMode;
    }

    public void setPaymentMode(PaymentModeEnum paymentMode) {
        this.paymentMode = paymentMode;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Long getSettlement() {
        return this.settlement.getId();
    }

    public void setSettlement(Settlement settlement) {
        this.settlement = settlement;
    }

    @Override
    public String toString() {
        return "SettlementDetail{" +
                "id=" + id +
                ", paymentMode=" + paymentMode +
                ", amount=" + amount +
                '}';
    }
}
