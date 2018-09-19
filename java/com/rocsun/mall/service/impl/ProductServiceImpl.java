package com.rocsun.mall.service.impl;

import com.github.pagehelper.ISelect;
import com.github.pagehelper.PageHelper;
import com.rocsun.mall.dao.ProductMapper;
import com.rocsun.mall.po.Product;
import com.rocsun.mall.po.ProductPage;
import com.rocsun.mall.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductMapper productMapper;

    @Override
    public ProductPage query(Integer cid, Integer bid, String keyWord, Integer page) {
        Map<String,Object> param = new HashMap<>();
        ProductPage productPage = new ProductPage();
        if(cid != null){
            param.put("cid",cid);
            productPage.setCid(cid);
        }
        if(bid != null){
            param.put("bid",bid);
            productPage.setBid(bid);
        }
        if (keyWord != null){
            param.put("keyWord",keyWord);
            productPage.setKeyWord(keyWord);
        }
        //开始分页查询
        PageHelper.startPage(page,3);
        List<Product> products = productMapper.query(param);
        productPage.setProducts(products);
        //获取查询结果总条数
        long count = PageHelper.count(new ISelect() {
            @Override
            public void doSelect() {
                productMapper.query(param);
            }
        });
        productPage.setTotalCount(count);
        //System.out.println("count = " + count);
        double pageCount = Math.ceil((double) count/3);
        //System.out.println("pageCount = " + pageCount);
        productPage.setPageCount((int)pageCount);
        productPage.setCurrentPage(page);
        return productPage;

    }

    @Override
    public Product queryByPid(Integer pid) {
        return productMapper.queryByPid(pid);
    }
}
