package com.ssg.sales.repository;

import com.ssg.sales.model.Invoice;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface InvoiceRepository extends JpaRepository<Invoice, Long> {
    @Query(value = "select po from Invoice po where cast(po.createdAt as date) >= cast(:from as date) " +
            "and cast(po.createdAt as date) <= cast(:to as date) order by po.createdAt",
            countQuery = "select count(po) from Invoice po where cast(po.createdAt as date) >= cast(:from as date) " +
                    "and cast(po.createdAt as date) <= cast(:to as date)")
    public List<Invoice> getInvoicesByDates(@Param("from") LocalDate from,
                                                @Param("to") LocalDate to,
                                                Pageable pageable);

    @Query("select po from Invoice po where po.invoiceNo = :invoice")
    public Invoice getInvoiceByInvoiceNo(@Param("invoice") String invoice);

    public Invoice getByOrderId(Integer orderId);
}
