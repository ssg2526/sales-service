package com.ssg.sales.repository;

import com.ssg.sales.model.LatestInvoice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LastInvoiceRepository extends JpaRepository<LatestInvoice, Integer> {
    public LatestInvoice findByOrgIdAndBranchId(Integer orgId, Integer branchId);
}
