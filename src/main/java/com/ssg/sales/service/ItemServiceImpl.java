package com.ssg.sales.service;

import com.ssg.sales.model.Item;
import com.ssg.sales.model.context.model.ContextProps;
import com.ssg.sales.model.context.model.DBContext;
import com.ssg.sales.repository.ItemRepository;
import com.ssg.sales.repository.LastInvoiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class ItemServiceImpl implements ItemService {
    @Autowired
    ItemRepository itemRepository;

    @Override
    public void createItem(Item item) {
        ContextProps cp = DBContext.getCurrentDBContext();
        Integer maxItemCode = itemRepository.findMaxItemCode(cp.getOrgId(), cp.getInvId());
        if(maxItemCode == null){
            maxItemCode = 0;
        }
        item.setItemCode(maxItemCode+1);
        itemRepository.save(item);
    }

    @Override
    @Transactional
    public void bulkCreateItem(List<Item> itemList) {
//        itemRepository.saveAll(itemList);
        itemList.forEach(item -> {
            createItem(item);
        });

    }

    @Override
    public Item fetchItemById(Integer itemId) {
        Item item = itemRepository.getById(itemId);
        return item;
    }

    @Override
    public List<Item> fetchItemByCode(Integer itemCode) {
        ContextProps cp = DBContext.getCurrentDBContext();
        List<Item> itemList = List.of(itemRepository.findByOrgIdAndInventoryIdAndItemCode(cp.getOrgId(), cp.getInvId(), itemCode));
        return itemList;
    }

    @Override
    public List<Item> fetchItemByCategory(Integer categoryId) {
        ContextProps cp = DBContext.getCurrentDBContext();
        List<Item> itemList = itemRepository.findByOrgIdAndInventoryIdAndCategoryId(cp.getOrgId(), cp.getInvId(), categoryId);
        return itemList;
    }

    @Override
    public Integer deleteItem(Integer itemId) {
        return null;
    }

    @Override
    public void updateItem(Item item) {
        itemRepository.save(item);
    }

    @Override
    public List<Item> searchItemsContaining(String searchText) {
        ContextProps contextProps = DBContext.getCurrentDBContext();
        List<Item> items = itemRepository.findByNameContainingAndOrgIdAndInventoryId(searchText, contextProps.getOrgId(), contextProps.getInvId());
        return items;
    }

    @Override
    public List<Item> getAllItems() {
        ContextProps contextProps = DBContext.getCurrentDBContext();
        List<Item> items = itemRepository.findByOrgIdAndInventoryIdOrderByName(contextProps.getOrgId(), contextProps.getInvId());
        return items;
    }
}
