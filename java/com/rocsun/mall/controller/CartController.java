package com.rocsun.mall.controller;

import com.alibaba.fastjson.JSON;
import com.rocsun.mall.po.*;
import com.rocsun.mall.service.CartService;
import com.rocsun.mall.service.NavService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class CartController {

    @Autowired
    private CartService cartService;

    @Autowired
    private NavService navService;

    @RequestMapping("/cart")
    public String cart(HttpSession session, Model model){
        Member member = (Member) session.getAttribute("member");
        Integer mid = member.getMid();
        List<ProductInCart> productInCarts = cartService.queryByMid(mid); //改动过
        List<Nav> nav = navService.getNav();
        CartDetail cartDetail = cartService.queryTotal(mid);
        List<Address> addresses = cartService.queryAddressByMid(mid);
        model.addAttribute("addresses",addresses);
        model.addAttribute("productInCarts",productInCarts);
        model.addAttribute("nav",nav);
        model.addAttribute("cartDetail",cartDetail);
        return "cart";
    }

    @RequestMapping("/add2Cart")
    public String add2Cart(HttpSession session,Integer pid,Integer quantity){
        System.out.println("pid = [" + pid + "], quantity = [" + quantity + "]");
        Member member = (Member) session.getAttribute("member");
        Integer mid = member.getMid();
        cartService.add2Cart(mid,pid,quantity);
        return "redirect:/cart";
    }

    @RequestMapping("/delete")
    public String delete(HttpSession session,Integer pid){
        Member member = (Member) session.getAttribute("member");
        Integer mid = member.getMid();
        cartService.delete(mid,pid);
        return "redirect:/cart";
    }

    @RequestMapping("/updateQuantity")
    public String updateQuantity(HttpSession session,Integer pid,Integer quantity){
        Member member = (Member) session.getAttribute("member");
        Integer mid = member.getMid();
        if (quantity > 0){
            cartService.updateQuantity(mid,pid,quantity);
        }
        return "redirect:/cart";
    }
}
