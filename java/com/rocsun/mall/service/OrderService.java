package com.rocsun.mall.service;

import com.rocsun.mall.po.OrderItem;

import java.util.List;

public interface OrderService {
    List<OrderItem> queryByMid(Integer mid);

    int checkout(Integer mid,Integer aid);
}
