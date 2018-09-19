package com.rocsun.mall.service;

import com.rocsun.mall.po.CartDetail;
import com.rocsun.mall.po.ProductInCart;
import com.rocsun.mall.po.Address;

import java.util.List;

public interface CartService {
    List<ProductInCart> queryByMid(Integer mid);
    int add2Cart(Integer mid, Integer pid, Integer quantity);
    int delete(Integer mid, Integer pid);
    CartDetail queryTotal(Integer mid);
    int updateQuantity(Integer mid, Integer pid, Integer quantity);
    List<Address> queryAddressByMid(Integer mid);
}
