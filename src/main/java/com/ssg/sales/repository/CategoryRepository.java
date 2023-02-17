package com.ssg.sales.repository;

import com.ssg.sales.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> {
    public List<Category> findByOrgIdAndBranchId(int orgId, int branchId);
}
