package com.ssg.sales.service;

import com.ssg.sales.model.Category;

import java.util.List;

public interface CategoryService {
    public List<Category> getCategories();
    public Category addCategory(Category category);
    public Category updateCategory(Category category);
}
