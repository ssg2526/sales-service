package com.ssg.sales.service;

import com.ssg.sales.model.Invoice;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Service
public interface InvoiceService {
    public Invoice addInvoice(Invoice order);
    public Invoice updateInvoice(Invoice order);
    public Invoice getInvoiceDetailsById(Integer orderId);
    public List<Invoice> getInvoicesByDates(LocalDate from, LocalDate to, int page, int size);
    public Invoice getInvoiceByInvoiceNo(String invoice);
}
