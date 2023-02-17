package com.ssg.sales.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "latest_invoice")
@Data
public class LatestInvoice {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "org_id")
    private Integer orgId;
    @Column(name = "branch_id")
    private Integer branchId;
    @Column(name = "last_invoice_no")
    private String lastInvoice;
}
