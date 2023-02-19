//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.ssg.sales.model;

import lombok.EqualsAndHashCode;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "kot_item")
@EqualsAndHashCode
public class KotItem {

    private static final long serialVersionUID = 42L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "item_id")
    private Integer itemId;
    @Column(name = "rate")
    private Float rate;
    @Column(name = "uom")
    private String uom;
    @Column(name = "qty")
    private Float qty;
    @Column(name = "discount_percent")
    private Float discountPer;
    @Column(name = "selling_price")
    private Float sellingPrice;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "kot_id")
    private Kot kot;

    public KotItem() {
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getItemId() {
        return this.itemId;
    }

    public void setItemId(Integer itemId) {
        this.itemId = itemId;
    }

    public Float getRate() {
        return this.rate;
    }

    public void setRate(Float rate) {
        this.rate = rate;
    }

    public String getUom() {
        return this.uom;
    }

    public void setUom(String uom) {
        this.uom = uom;
    }

    public Float getQty() {
        return this.qty;
    }

    public void setQty(Float qty) {
        this.qty = qty;
    }

    public Float getDiscountPer() {
        return this.discountPer;
    }

    public void setDiscountPer(Float discountPer) {
        this.discountPer = discountPer;
    }

    public Float getSellingPrice() {
        return this.sellingPrice;
    }

    public void setSellingPrice(Float sellingPrice) {
        this.sellingPrice = sellingPrice;
    }

    public Long getKot() {
        return this.kot.getId();
    }

    public void setKot(Kot kot) {
        this.kot = kot;
    }

    public String toString() {
        return "KotItem{" +
                "id=" + this.id +
                ", itemId=" + this.itemId +
                ", rate=" + this.rate +
                ", uom='" + this.uom + "'" +
                ", qty=" + this.qty +
                ", discountPer=" + this.discountPer +
                ", sellingPrice=" + this.sellingPrice + "}";
    }
}
