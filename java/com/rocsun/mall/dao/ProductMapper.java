package com.rocsun.mall.dao;

import com.rocsun.mall.po.Product;

import java.util.List;
import java.util.Map;

public interface ProductMapper {

    /**
     * 查询商品
     * @return
     */
    List<Product> query(Map<String,Object> param);

    Product queryByPid(Integer pid);

    int doUpdate(Map<String,Object> param);
}
