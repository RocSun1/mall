package com.rocsun.mall.dao;

import com.rocsun.mall.po.OrderItem;

import java.util.List;
import java.util.Map;

public interface OrderMapper {
    List<OrderItem> queryByMid(Integer mid);
    int doInsert(Map<String,Object> param);
    int doInsertDetail(List<Map<String,Object>> params);
}
