package com.project.tmall.controller;

import com.project.tmall.pojo.User;
import com.project.tmall.service.UserService;
import com.project.tmall.util.Page4Navigator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired UserService userService;

    @GetMapping("/users")
    public Page4Navigator<User> list(@RequestParam(value = "start",defaultValue = "0") int start,
                                     @RequestParam(value = "size",defaultValue = "5") int size) throws Exception{
        start = start < 0 ? 0 :start;
        Page4Navigator<User> page = userService.list(start, size, 5);
        return page;

    }
}
