package com.ssg.sales.model;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;

@Table(name = "inventory_item")
@Entity
@Data
public class InventoryItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "item_id")
    private Integer itemId;

    @Column(name="rate")
    private Float rate;

    @Column(name = "qty")
    private Float qty;

    @Column(name = "inventory_id")
    private Integer inventoryId;

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
