package com.ssg.sales.repository;

import com.ssg.sales.model.Settlement;
import com.ssg.sales.model.analytics.*;
import org.apache.tomcat.jni.Local;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface SettlementRepository extends JpaRepository<Settlement, Long> {

    @Query("select new com.ssg.sales.model.analytics.DailySales(sum(s.totalAmount), cast(s.createdAt as date)) " +
            "from Settlement s where " +
            "cast(s.createdAt as date) >= cast(:startDate as date)  group by cast(s.createdAt as date) order by " +
            "cast(s.createdAt as date) ASC")
    List<SalesAgg> getDailySalesAgg(@Param("startDate") LocalDate startDate);

    @Query("select new com.ssg.sales.model.analytics.DailySales(sum(s.totalAmount), cast(s.createdAt as date)) " +
            "from Settlement s where " +
            "cast(s.createdAt as date) >= cast(:startDate as date)  group by cast(s.createdAt as date)")
    List<MonthlySales> getMonthlySalesAgg(@Param("startDate") LocalDate startDate);

    @Query("select new com.ssg.sales.model.analytics.DailySalesCount(count(s.id), cast(s.createdAt as date)) " +
            "from Settlement s where " +
            "cast(s.createdAt as date) >= cast(:startDate as date) group by cast(s.createdAt as date) order by " +
            "cast(s.createdAt as date) ASC")
    List<SalesCountAgg> getDailySalesCountAgg(@Param("startDate") LocalDate startDate);

    @Query("select new com.ssg.sales.model.analytics.DailyPaymentMode(sum(sd.amount), sd.paymentMode, cast(s.createdAt as date)) " +
            "from Settlement s inner join SettlementDetail sd on s.id=sd.settlement " +
            "group by sd.paymentMode, cast(s.createdAt as date) order by cast(s.createdAt as date)")
    List<PaymentAgg> getDailyPaymentModeAgg(@Param("startDate")LocalDate startDate);

}
