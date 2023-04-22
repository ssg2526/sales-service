package com.ssg.sales.model;

import lombok.Builder;
import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "item")
@Data
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "item_code")
    private Integer itemCode;
    @Column(name = "name")
    private String name;
    @Column(name = "description")
    private String desc;
    @Column(name = "manufacturer")
    private String manufacturer;
    @Column(name = "category_id")
    private Integer categoryId;
    @Column(name="uom")
    private String uom;
    @Column(name = "rate")
    private Float rate;
    @Column(name = "online_rate")
    private Float onlineRate;
    @Column(name = "inventory_id", nullable = false)
    private Integer inventoryId;
    @Column(name = "org_id", nullable = false)
    private Integer orgId;
    @Column(name = "branch_id", nullable = false)
    private Integer branchId;
}
