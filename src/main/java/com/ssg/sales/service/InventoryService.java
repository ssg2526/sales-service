package com.ssg.sales.service;

import com.ssg.sales.model.InventoryItem;
import com.ssg.sales.model.Item;

public interface InventoryService {
    public void createInventoryItem(InventoryItem sockItem);
    public void updateInventoryItem(InventoryItem stockItem);
    public InventoryItem getInventoryItem(InventoryItem stockItem);
}
