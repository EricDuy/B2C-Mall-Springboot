package com.project.tmall.dao;


import com.project.tmall.pojo.Category;
import com.project.tmall.pojo.Property;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface PropertyDAO extends JpaRepository<Property,Integer>{
    Page<Property> findByCategory(Category category, Pageable pageable);

    //增加通过分类获取所有属性集合的方法
    List<Property> findByCategory(Category category);

}