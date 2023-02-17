package com.ssg.sales.service;

import com.ssg.sales.model.Item;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ItemService {
    public void createItem(Item item);
    public Item fetchItemById(Integer itemId);
    public List<Item> fetchItemByCode(Integer itemCode);
    public List<Item> fetchItemByCategory(Integer categoryId);
    public Integer deleteItem(Integer itemId);
    public void updateItem(Item item);
    public List<Item> searchItemsContaining(String searchText);
    public List<Item> getAllItems();
}
