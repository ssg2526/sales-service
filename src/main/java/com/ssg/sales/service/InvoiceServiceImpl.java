package com.ssg.sales.service;

import com.ssg.sales.model.LatestInvoice;
import com.ssg.sales.model.Invoice;
import com.ssg.sales.model.context.model.ContextProps;
import com.ssg.sales.model.context.model.DBContext;
import com.ssg.sales.repository.LastInvoiceRepository;
import com.ssg.sales.repository.InvoiceRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
@Slf4j
public class InvoiceServiceImpl implements InvoiceService {
    @Autowired
    InvoiceRepository invoiceRepository;

    @Autowired
    InventoryService inventoryService;

    @Autowired
    LastInvoiceRepository lastInvoiceRepository;

    @Override
    public Invoice addInvoice(Invoice invoice) {
        log.info(invoice.toString());
        invoice.getInvoiceItems().forEach(invoiceItem -> {
            log.info(invoiceItem.toString());
            invoiceItem.setInvoice(invoice);
        });
        ContextProps cp = DBContext.getCurrentDBContext();
        log.info("context: "+cp.getOrgId()+" "+cp.getBranchId());
        LatestInvoice lastInvoiceObj = lastInvoiceRepository.findByOrgIdAndBranchId(cp.getOrgId(), cp.getBranchId());
        Integer currentInvoice = null;
        LocalDate date = LocalDate.now();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM");
        String formattedDate = date.format(dtf);
        StringBuilder sb = new StringBuilder(formattedDate);
        if(lastInvoiceObj == null){
            currentInvoice = 1;
        } else {
            String lastInv = lastInvoiceObj.getLastInvoice();
            Integer prevMonth = Integer.parseInt(lastInv.substring(5,7));
            Integer invoiceNo = Integer.parseInt(lastInv.substring(8));

            int currMonth = date.getMonth().getValue();

            if(currMonth > prevMonth){
                currentInvoice = 1;
            } else{
                currentInvoice = invoiceNo+1;
            }
        }
        String invoiceNo = sb.append("-").append(currentInvoice).toString();
        invoice.setInvoiceNo(invoiceNo);
        Invoice o = invoiceRepository.save(invoice);
        if(lastInvoiceObj == null){
            lastInvoiceObj = new LatestInvoice();
            lastInvoiceObj.setBranchId(cp.getBranchId());
            lastInvoiceObj.setOrgId(cp.getOrgId());
            lastInvoiceObj.setLastInvoice(invoiceNo);
        } else{
            lastInvoiceObj.setLastInvoice(invoiceNo);
        }
        lastInvoiceRepository.save(lastInvoiceObj);
        return o;
    }

    @Override
    public Invoice updateInvoice(Invoice invoice) {
        Invoice oldOrderDetail = getInvoiceDetailsById(invoice.getId());
        invoice.setCreatedAt(oldOrderDetail.getCreatedAt());
        if(invoice.getInvoiceItems().size() == 0){
            return null;
        }
        invoice.getInvoiceItems().forEach(invoiceItem -> {
            invoiceItem.setInvoice(invoice);
        });
        return invoiceRepository.save(invoice);
    }

    @Override
    public Invoice getInvoiceDetailsById(Long id) {
        Invoice po = null;
        try{
            log.info("reached service layer");
            po = invoiceRepository.getById(id);
            log.info("closing service layer");
        } catch (Exception e){
            log.error(e.getMessage());

        }
        log.info(po.toString());
        return po;
    }

    @Override
    public Page<Invoice> getInvoicesByDates(LocalDate from, LocalDate to, int page, int pageSize) {
        Pageable paging = PageRequest.of(page, pageSize);
        return invoiceRepository.getInvoicesByDates(from, to, paging);
    }

    @Override
    public Invoice getInvoiceByInvoiceNo(String invoice) {
        return invoiceRepository.getInvoiceByInvoiceNo(invoice);
    }

    @Override
    public Invoice getInvoiceByOrderId(Integer orderId) {
        return invoiceRepository.getByOrderId(orderId);
    }
}
