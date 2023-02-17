package com.ssg.sales.service;

import com.ssg.sales.model.Category;
import com.ssg.sales.model.context.model.ContextProps;
import com.ssg.sales.model.context.model.DBContext;
import com.ssg.sales.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    CategoryRepository categoryRepository;

    @Override
    public List<Category> getCategories() {
        ContextProps cp = DBContext.getCurrentDBContext();
        return categoryRepository.findByOrgIdAndBranchId(cp.getOrgId(), cp.getBranchId());
    }

    @Override
    public Category addCategory(Category category) {
        return categoryRepository.save(category);
    }

    @Override
    public Category updateCategory(Category category) {
        return categoryRepository.save(category);
    }
}
