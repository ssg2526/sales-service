package com.ssg.sales.model;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;
import java.time.LocalDateTime;

@Table(name = "inventory_log")
@Entity
@Data
public class InventoryLog {

    private static final long serialVersionUID = 42L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "tenant_id")
    private Integer tenantId;

    @Column(name = "branch_id")
    private Integer branchId;

    @Column(name = "item_id")
    private Integer itemId;

    @Column(name = "qty")
    private Integer qty;

    @Column(name = "created_at")
    @CreationTimestamp
    private Timestamp createdAt;

    @Column(name = "updated_at")
    @UpdateTimestamp
    private Timestamp updatedOn;
}
