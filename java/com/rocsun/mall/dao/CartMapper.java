package com.rocsun.mall.dao;

import com.rocsun.mall.po.CartDetail;
import com.rocsun.mall.po.ProductInCart;
import com.rocsun.mall.po.Cart;

import java.util.List;
import java.util.Map;

public interface CartMapper {
    List<ProductInCart> queryByMid(Integer mid);
    int doInsert(Map<String,Object> param);
    Cart queryByMidAndPid(Map<String,Object> param);
    int doUpdate(Map<String,Object> param);
    int doDelete(Map<String,Object> param);
    CartDetail queryTotal(Integer mid);
    int remove(Integer mid);
}
