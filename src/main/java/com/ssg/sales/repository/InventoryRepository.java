package com.ssg.sales.repository;

import com.ssg.sales.model.InventoryItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InventoryRepository extends JpaRepository<InventoryItem, Integer> {
    public InventoryItem findByItemIdAndInventoryId(Integer itemId, Integer inventoryId);
}
