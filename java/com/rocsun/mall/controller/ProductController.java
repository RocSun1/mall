package com.rocsun.mall.controller;


import com.rocsun.mall.po.Nav;
import com.rocsun.mall.po.Product;
import com.rocsun.mall.service.NavService;
import com.rocsun.mall.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class ProductController {

    @Autowired
    private ProductService productService;

    @Autowired
    private NavService navService;

    @RequestMapping("/product/{pid}")
    public String product(Model model, @PathVariable Integer pid){
        System.out.println("pid = [" + pid + "]");
        Product product = productService.queryByPid(pid);
        List<Nav> navs = navService.getNav();
        model.addAttribute("product",product);
        model.addAttribute("nav",navs);
        return "product";
    }
}
