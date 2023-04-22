package com.ssg.sales.service.analytics;

import com.ssg.sales.enums.SalesAggType;
import com.ssg.sales.model.Settlement;
import com.ssg.sales.model.analytics.PaymentAgg;
import com.ssg.sales.model.analytics.SalesAgg;
import com.ssg.sales.model.analytics.SalesCountAgg;
import com.ssg.sales.repository.SettlementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import static java.time.temporal.TemporalAdjusters.firstDayOfYear;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class AnalyticsServiceImpl implements AnalyticsService{

    @Autowired
    SettlementRepository settlementRepository;

    @Override
    public List<SalesAgg> getDailySalesAggregation(SalesAggType salesAggType) {
        switch (salesAggType){
            case DAILY: {
                LocalDate startDate = LocalDate.now().minusDays(15);
                return settlementRepository.getDailySalesAgg(startDate);
            }
            case MONTHLY: {
                LocalDate startDate = LocalDate.now().with(firstDayOfYear());
                return settlementRepository.getMonthlySalesAgg(startDate);
            }
            case YEARLY: {
                break;
            }
            default: {

            }
        }
        LocalDate startDate = LocalDate.now().minusDays(15);
        return settlementRepository.getDailySalesAgg(startDate);
    }

    @Override
    public List<SalesCountAgg> getDailySalesCountAggregation(SalesAggType salesAggType) {
        switch (salesAggType){
            case DAILY: {
                LocalDate startDate = LocalDate.now().minusDays(15);
                return settlementRepository.getDailySalesCountAgg(startDate);
            }
            case MONTHLY: {
                LocalDate startDate = LocalDate.now().with(firstDayOfYear());
                return settlementRepository.getMonthlySalesCountAgg(startDate);
            }
            case YEARLY: {
                break;
            }
            default: {

            }
        }
        LocalDate startDate = LocalDate.now().minusDays(15);
        return settlementRepository.getDailySalesCountAgg(startDate);
    }

    @Override
    public List<PaymentAgg> getDailyPaymentAggregation(SalesAggType aggType) {
        switch (aggType){
            case DAILY: {
                LocalDate startDate = LocalDate.now().minusDays(15);
                return settlementRepository.getDailyPaymentModeAgg(startDate);
            }
            case MONTHLY: {
                LocalDate startDate = LocalDate.now().with(firstDayOfYear());
                return settlementRepository.getMonthlyPaymentModeAgg(startDate);
            }
            case YEARLY: {
                break;
            }
            default: {

            }
        }
        LocalDate startDate = LocalDate.now().minusDays(15);
        return settlementRepository.getDailyPaymentModeAgg(startDate);
    }
}
