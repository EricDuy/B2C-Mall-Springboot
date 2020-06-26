package com.project.tmall.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

@Controller
public class HelloController {

//    @ResponseBody
    @RequestMapping("/index")
    public String hello(Map<String,Object> map){
        System.out.println("进来了");
//        return "hello.html";
        map.put("msg", "测试测试");
        return "form";
//        return "hello";
    }
}
