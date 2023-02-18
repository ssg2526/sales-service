package com.ssg.sales.service.restaurant;

import com.ssg.sales.model.Invoice;
import com.ssg.sales.model.Kot;
import com.ssg.sales.model.Seating;
import com.ssg.sales.model.Settlement;

public interface RestaurantService {
    public Seating doKot(Kot kot, int tableId);
    public Seating doBill(Invoice invoice, int tableId);
    public Seating updateKot(Kot kot);
    public Seating settleBill(Settlement settlement, int tableId);
}
