package com.ssg.sales.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "settlement")
@Data
public class Settlement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "order_id")
    private Integer orderId;
    @Column(name = "total_amount")
    private Double totalAmount;
    @OneToMany(mappedBy = "settlement", cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
    private List<SettlementDetail> settlementDetails;
}
