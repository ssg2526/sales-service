package com.ssg.sales.service;

import com.ssg.sales.model.InventoryItem;
import com.ssg.sales.model.Item;
import com.ssg.sales.repository.InventoryRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Slf4j
public class InventoryServiceImpl implements InventoryService {

    @Autowired
    InventoryRepository inventoryRepository;

    @Override
    @Transactional
    public void createInventoryItem(InventoryItem stockItem) {
        inventoryRepository.save(stockItem);
    }

    @Override
    public void updateInventoryItem(InventoryItem stockItem) {
        inventoryRepository.save(stockItem);
    }

    @Override
    public InventoryItem getInventoryItem(InventoryItem stockItem) {
        return inventoryRepository.findByItemIdAndInventoryId(stockItem.getId(), stockItem.getInventoryId());
    }
}
