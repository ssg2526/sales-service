package com.ssg.sales.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Table(name = "invoice")
@Data
public class Invoice {
    private static final long serialVersionUID = 42L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "invoice_no")
    private String invoiceNo;

    @Column(name = "order_id")
    private Long orderId;

    @Column(name = "discount_percent")
    private Double discountPer;

    @Column(name = "bill_amount")
    private Double billAmount;

    @Column(name = "customer_contact")
    private String customerContact;

    @OneToMany(mappedBy = "invoice", cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
    private List<InvoiceItem> invoiceItems;

    @Column(name = "org_id", nullable = false)
    private Integer orgId;

    @Column(name = "branch_id", nullable = false)
    private Integer branchId;

    @Column(name = "created_at")
    @CreationTimestamp
    private Timestamp createdAt;

    @Column(name = "updated_at")
    @UpdateTimestamp
    private Timestamp updatedAt;
}
