package com.ssg.sales.repository;

import com.ssg.sales.model.Settlement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SettlementRepository extends JpaRepository<Settlement, Integer> {

}
