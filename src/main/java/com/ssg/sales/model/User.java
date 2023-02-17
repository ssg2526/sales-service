package com.ssg.sales.model;

import javax.persistence.*;

@Entity
@Table(name = "user", schema = "public")
public class User {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "name")
    private String name;
    @Column(name = "address")
    private String address;
    @Column(name = "contact")
    private String contact;
    @Column(name = "org_id")
    private Integer orgId;
    @Column(name = "branch_id")
    private Integer branchId;
    @Column(name = "inventory_id")
    private Integer invId;
}
