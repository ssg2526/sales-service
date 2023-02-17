package com.ssg.sales.repository;

import com.ssg.sales.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ItemRepository extends JpaRepository<Item, Integer> {
//    @Query("select i from item i where i.name like %:text% i.org_id=:orgId and inventory_id=:invId")
    public List<Item> findByNameContainingAndOrgIdAndInventoryId(String text, Integer orgId, Integer invId);
    public List<Item> findByOrgIdAndInventoryId(Integer orgId, Integer invId);
    public List<Item> findByOrgIdAndInventoryIdAndCategoryId(Integer orgId, Integer invId, Integer categoryId);
    public Item findByOrgIdAndInventoryIdAndItemCode(Integer orgId, Integer invId, Integer itemCode);
    @Query("select max(itemCode) from Item where orgId=:orgId and inventoryId=:invId ")
    public Integer findMaxItemCode(@Param("orgId") Integer orgId, @Param("invId") Integer invId);
}
