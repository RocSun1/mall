package com.rocsun.mall.service;

import com.rocsun.mall.po.Product;
import com.rocsun.mall.po.ProductPage;

import java.util.List;

public interface ProductService {
    ProductPage query(Integer cid, Integer bid, String keyWord, Integer page);
    Product queryByPid(Integer pid);
}
