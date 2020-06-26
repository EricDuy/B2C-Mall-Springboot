package com.project.tmall.dao;

import com.project.tmall.pojo.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDAO extends JpaRepository<User,Integer>{
    User findByName(String name);

    //登录
    User getByNameAndPassword(String name, String password);

}
