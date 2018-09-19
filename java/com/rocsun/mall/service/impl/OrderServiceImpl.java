package com.rocsun.mall.service.impl;

import com.rocsun.mall.dao.CartMapper;
import com.rocsun.mall.dao.OrderMapper;
import com.rocsun.mall.dao.ProductMapper;
import com.rocsun.mall.po.OrderItem;
import com.rocsun.mall.po.ProductInCart;
import com.rocsun.mall.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderMapper orderMapper;

    @Autowired
    private CartMapper cartMapper;

    @Autowired
    private ProductMapper productMapper;

    @Override
    public List<OrderItem> queryByMid(Integer mid) {
        return orderMapper.queryByMid(mid);
    }

    @Transactional
    @Override
    public int checkout(Integer mid, Integer aid) {
        int result = 0;
        //往订单主表插入数据
        Map<String,Object> param = new HashMap<>();
        param.put("mid",mid);
        param.put("aid",aid);
        result += orderMapper.doInsert(param);
        //往订单明细表插入数据
        List<ProductInCart> productInCarts = cartMapper.queryByMid(mid);//gaidong
        List<Map<String,Object>> params = new ArrayList<>();
        for (ProductInCart product : productInCarts) {
            Map<String,Object> map = new HashMap<>();
            map.put("orderId",param.get("orderId"));
            map.put("pid",product.getPid());
            map.put("quantity",product.getQuantity());
            map.put("price",product.getPrice());
            params.add(map);
            //修改商品的库存和销量
            result += productMapper.doUpdate(map);
        }
        result += orderMapper.doInsertDetail(params);
        //清空购物车
        result += cartMapper.remove(mid);
        return result;
    }
}
