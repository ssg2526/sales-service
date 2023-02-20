package com.ssg.sales.repository;

import com.ssg.sales.model.Kot;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface KotRepository extends JpaRepository<Kot, Long> {
    public List<Kot> findByOrgIdAndBranchIdAndOrderIdOrderByCreatedAtDesc(Integer orgId, Integer branchId, Long orderId);
}
