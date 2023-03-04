package com.ssg.sales.service;

import com.ssg.sales.model.Invoice;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Service
public interface InvoiceService {
    public Invoice addInvoice(Invoice order);
    public Invoice updateInvoice(Invoice order);
    public Invoice getInvoiceDetailsById(Long id);
    public Page<Invoice> getInvoicesByDates(LocalDate from, LocalDate to, int page, int size);
    public Invoice getInvoiceByInvoiceNo(String invoice);
    public Invoice getInvoiceByOrderId(Integer orderId);
}
