package com.ssg.sales.repository;

import com.ssg.sales.model.Seating;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SeatingRepository extends JpaRepository<Seating, Integer> {
    public List<Seating> findByOrgIdAndBranchIdOrderByTableNo(Integer orgId, Integer branchId);
}
