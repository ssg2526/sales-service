//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.ssg.sales.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(
        name = "order_gen"
)
@Data
public class Order {
    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    @Column(
            name = "id"
    )
    private Integer id;
    @Column(
            name = "status"
    )
    private Integer status;
    @Column(
            name = "org_id"
    )
    private Integer orgId;
    @Column(
            name = "branch_id"
    )
    private Integer branchId;
}
