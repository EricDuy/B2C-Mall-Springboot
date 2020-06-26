package com.project.tmall.service;

import com.project.tmall.dao.UserDAO;
import com.project.tmall.pojo.User;
import com.project.tmall.util.Page4Navigator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired UserDAO userDAO;

    public boolean isExist(String name) {
        User user = getByName(name);
        return null!=user;
    }

    public User getByName(String name) {
        return userDAO.findByName(name);
    }

    public void add(User user) {
        userDAO.save(user);
    }

    //用户登录
    public User get(String name,String password){
        return userDAO.getByNameAndPassword(name, password);
    }


    public Page4Navigator<User> list(int start,int size,int navigatePages){
        Sort sort = new Sort(Sort.Direction.DESC, "id");
        Pageable pageable = new PageRequest(start, size, sort);
        Page pageFormJPA = userDAO.findAll(pageable);
        return new Page4Navigator<>(pageFormJPA, navigatePages);
    }
}
