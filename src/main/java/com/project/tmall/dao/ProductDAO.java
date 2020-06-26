package com.project.tmall.dao;

import com.project.tmall.pojo.Category;
import com.project.tmall.pojo.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductDAO extends JpaRepository<Product,Integer> {
    Page<Product> findByCategory(Category category, Pageable pageable);

    //通过一个分类查询所有分类的方法
    List<Product> findByCategoryOrderById(Category category);

    //根据名称进行模糊查询的方法
    List<Product> findByNameLike(String keyword, Pageable pageable);
}
