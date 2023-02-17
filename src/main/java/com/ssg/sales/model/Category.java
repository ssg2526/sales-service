package com.ssg.sales.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "category")
@Data
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "name")
    private String name;
    @Column(name = "inventory_id", nullable = false)
    private Integer inventoryId;
    @Column(name = "org_id", nullable = false)
    private Integer orgId;
    @Column(name = "branch_id", nullable = false)
    private Integer branchId;
}
