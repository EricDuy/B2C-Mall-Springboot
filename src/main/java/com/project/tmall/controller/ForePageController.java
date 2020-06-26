package com.project.tmall.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;


//专门做前端的页面跳转
@Controller
public class ForePageController {

    @GetMapping("/")
    public String index(){
        return "redirect:home";
    }

    @GetMapping("/home")
    public String home(){
        return "fore/home";
    }

    @GetMapping(value="/register")
    public String register(){
        return "fore/register";
    }
    @GetMapping(value="/alipay")
    public String alipay(){
        return "fore/alipay";
    }
    @GetMapping(value="/bought")
    public String bought(){
        return "fore/bought";
    }

    @GetMapping(value="/buy")
    public String buy(){
        return "fore/buy";
    }

    @GetMapping(value="/cart")
    public String cart(){
        return "fore/cart";
    }

    @GetMapping(value="/category")
    public String category(){
        return "fore/category";
    }

    @GetMapping(value="/confirmPay")
    public String confirmPay(){
        return "fore/confirmPay";
    }

    @GetMapping(value="/login")
    public String login(){
        return "fore/login";
    }

    @GetMapping(value="/orderConfirmed")
    public String orderConfirmed(){
        return "fore/orderConfirmed";
    }

    @GetMapping(value="/payed")
    public String payed(){
        return "fore/payed";
    }

    @GetMapping(value="/product")
    public String product(){
        return "fore/product";
    }

    @GetMapping(value="/registerSuccess")
    public String registerSuccess(){
        return "fore/registerSuccess";
    }

    @GetMapping(value="/review")
    public String review(){
        return "fore/review";
    }

    @GetMapping(value="/search")
    public String searchResult(){
        return "fore/search";
    }

    //退出,点击退出时调用logout方法，在session中去掉"user"，然后跳转到首页home.html
    @GetMapping("/forelogout")
    public String logout(HttpSession session) {
        session.removeAttribute("user");
        return "redirect:home";
    }

}
