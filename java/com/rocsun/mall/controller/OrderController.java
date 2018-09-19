package com.rocsun.mall.controller;


import com.alibaba.fastjson.JSON;
import com.rocsun.mall.po.Member;
import com.rocsun.mall.po.Nav;
import com.rocsun.mall.po.OrderItem;
import com.rocsun.mall.service.NavService;
import com.rocsun.mall.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class OrderController {

    @Autowired
    private OrderService orderService;

    @Autowired
    private NavService navService;

    @RequestMapping("/order")
    public String order(Model model, HttpSession session){
        Member member = (Member) session.getAttribute("member");
        Integer mid = member.getMid();
        List<Nav> nav = navService.getNav();
        List<OrderItem> orderItems = orderService.queryByMid(mid); //gaidong
        System.out.println(JSON.toJSONString(orderItems));
        model.addAttribute("nav",nav);
        model.addAttribute("orderItems",orderItems);
        return "order";
    }

    @RequestMapping("/checkout")
    public String checkout(HttpSession session, Integer aid){
        Member member = (Member) session.getAttribute("member");
        Integer mid = member.getMid();
        int checkout = orderService.checkout(mid, aid);
        System.out.println(checkout);
        return "redirect:/order";
    }
}
