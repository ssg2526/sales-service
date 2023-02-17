package com.ssg.sales.model;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "seating")
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class Seating {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "table_no")
    private Integer tableNo;
    @Column(name = "type")
    private String type;
    @Column(name = "status")
    private Integer status;
    @Column(name = "order_id")
    private Integer orderId;
    @Column(name = "order_value")
    private Double orderValue;
    @Column(name = "org_id")
    private Integer orgId;
    @Column(name = "branch_id")
    private Integer branchId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Seating seating = (Seating) o;
        return id != null && Objects.equals(id, seating.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
