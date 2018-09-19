package com.rocsun.mall.controller;


import com.alibaba.fastjson.JSON;
import com.rocsun.mall.po.Nav;
import com.rocsun.mall.po.Product;
import com.rocsun.mall.po.ProductPage;
import com.rocsun.mall.service.NavService;
import com.rocsun.mall.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class ListController {
    @Autowired
    private ProductService productService;

    @Autowired
    private NavService navService;

    @RequestMapping("/list")
    public String list(Model model,Integer cid,Integer bid,String keyWord,@RequestParam(required = false,defaultValue = "1") Integer page){
        System.out.println("cid = [" + cid + "], bid = [" + bid + "], keyWord = [" + keyWord + "], page = [" + page + "]");

        ProductPage productPage = productService.query(cid,bid,keyWord,page);
        List<Nav> navs = navService.getNav();
        model.addAttribute("productPage",productPage);
        model.addAttribute("nav",navs);
        System.out.println(JSON.toJSONString(productPage));
        return "list";
    }
}
