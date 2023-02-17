package com.ssg.sales.model;

import lombok.EqualsAndHashCode;

import javax.persistence.*;

@Entity
@Table(name = "invoice_item")
@EqualsAndHashCode
public class InvoiceItem {
    private static final long serialVersionUID = 42L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "item_id")
    private Integer itemId;
    @Column(name = "rate")
    private Double rate;
    @Column(name = "uom")
    private String uom;
    @Column(name = "qty")
    private Double qty;
    @Column(name = "discount_percent")
    private Double discountPer;
    @Column(name = "selling_price")
    private Double sellingPrice;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "invoice_id")
    private Invoice invoice;

//    @Column(name = "tenant_id", nullable = false)
//    private Integer tenantId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getItemId() {
        return itemId;
    }

    public void setItemId(Integer itemId) {
        this.itemId = itemId;
    }

    public Double getRate() {
        return rate;
    }

    public void setBaseRate(Double baseRate) {
        this.rate = rate;
    }

    public String getUom() {
        return uom;
    }

    public void setUom(String uom) {
        this.uom = uom;
    }

    public Double getQty() {
        return qty;
    }

    public void setQty(Double qty) {
        this.qty = qty;
    }

    public Double getDiscountPer() {
        return discountPer;
    }

    public void setDiscountPer(Double discountPer) {
        this.discountPer = discountPer;
    }

    public Double getSellingPrice() {
        return sellingPrice;
    }

    public void setSellingPrice(Double sellingPrice) {
        this.sellingPrice = sellingPrice;
    }

    public Integer getInvoice() {
        return invoice.getId();
    }

    public void setInvoice(Invoice invoice) {
        this.invoice = invoice;
    }

//    public Integer getTenantId() {
//        return tenantId;
//    }
//
//    public void setTenantId(Integer tenantId) {
//        this.tenantId = tenantId;
//    }

    @Override
    public String toString() {
        return "OrderItem{" +
                "id=" + id +
                ", itemId=" + itemId +
                ", rate=" + rate +
                ", uom='" + uom + '\'' +
                ", qty=" + qty +
                ", discountPer=" + discountPer +
                ", sellingPrice=" + sellingPrice +
                '}';
    }
}
