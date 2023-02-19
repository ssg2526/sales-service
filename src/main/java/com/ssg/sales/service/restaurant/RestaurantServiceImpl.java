package com.ssg.sales.service.restaurant;

import com.ssg.sales.model.*;
import com.ssg.sales.model.context.model.ContextProps;
import com.ssg.sales.model.context.model.DBContext;
import com.ssg.sales.repository.KotRepository;
import com.ssg.sales.repository.OrderRepository;
import com.ssg.sales.repository.SeatingRepository;
import com.ssg.sales.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class RestaurantServiceImpl implements RestaurantService{

    @Autowired
    KotService kotService;

    @Autowired
    SeatingService seatingService;

    @Autowired
    OrderService orderService;

    @Autowired
    InvoiceService invoiceService;

    @Autowired
    SettlementService settlementService;

    @Override
    @Transactional
    public Seating doKot(Kot kot, int tableId) {
        ContextProps cp = DBContext.getCurrentDBContext();
        kot.setOrgId(cp.getOrgId());
        kot.setBranchId(cp.getBranchId());
        Seating seating = seatingService.getTableById(tableId);
        if(seating.getOrderId() == null){
            Order order = new Order();
            order.setStatus(0);
            order.setOrgId(cp.getOrgId());
            order.setBranchId(cp.getBranchId());
            Order newOrder = orderService.generateOrder(order);
            seating.setOrderId(newOrder.getId());
        }
        kot.setOrderId(seating.getOrderId());
        Kot resultKot = kotService.addKot(kot);
        Double kotSum = 0.0;
        for(KotItem kotItem: resultKot.getKotItems()){
            kotSum += kotItem.getQty()*kotItem.getRate();
        }
        if(seating.getOrderValue() == null){
            seating.setOrderValue(kotSum);
        } else {
            seating.setOrderValue(seating.getOrderValue()+kotSum);
        }
        seating.setStatus(1);
        return seatingService.updateTable(seating);
    }

    @Override
    @Transactional
    public Seating doBill(Invoice invoice, int tableId) {
        ContextProps cp = DBContext.getCurrentDBContext();
        invoice.setOrgId(cp.getOrgId());
        invoice.setBranchId(cp.getBranchId());
        Seating seating = seatingService.getTableById(tableId);
        if(seating.getOrderId() == null){
            Order order = new Order();
            order.setStatus(0);
            order.setOrgId(cp.getOrgId());
            order.setBranchId(cp.getBranchId());
            Order newOrder = orderService.generateOrder(order);
            seating.setOrderId(newOrder.getId());
        }
        invoice.setOrderId(seating.getOrderId());
        Invoice newInvoice = invoiceService.addInvoice(invoice);
        seating.setOrderValue(newInvoice.getBillAmount());
        seating.setStatus(2);
        return seatingService.updateTable(seating);
    }

    @Override
    public Seating updateKot(Kot kot) {
        long orderId = kot.getOrderId();
        Kot editedKot = kotService.editKot(kot);

        return null;
    }

    @Override
    @Transactional
    public Seating settleBill(Settlement settlement, int tableId) {
        Seating seating = seatingService.getTableById(tableId);
        if(seating == null || seating.getStatus() != 2 || seating.getOrgId() == null){
            return null;
        }
        ContextProps cp = DBContext.getCurrentDBContext();
        settlement.setOrgId(cp.getOrgId());
        settlement.setBranchId(cp.getBranchId());
        settlement.setOrderId(seating.getOrderId());
        settlementService.addSettlement(settlement);
        seating.setStatus(0);
        seating.setOrderId(null);
        seating.setOrderValue(null);
        Seating seating1 = seatingService.updateTable(seating);
        return seating1;
    }


}
