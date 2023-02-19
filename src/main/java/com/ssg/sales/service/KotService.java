package com.ssg.sales.service;

import com.ssg.sales.model.Kot;

import java.util.List;

public interface KotService {
    public List<Kot> getKotListByOrder(long orderId);
    public Kot addKot(Kot kot);
    public Kot editKot(Kot kot);
}
