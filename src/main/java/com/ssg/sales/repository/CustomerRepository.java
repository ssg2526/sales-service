package com.ssg.sales.repository;

import com.ssg.sales.model.CustomerDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<CustomerDetails,Long> {
    public CustomerDetails getByOrgIdAndBranchIdAndContact(int orgId, int branchId, String contact);
}
