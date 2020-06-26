package com.project.tmall.dao;

import com.project.tmall.pojo.Product;
import com.project.tmall.pojo.Review;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReviewDAO extends JpaRepository<Review,Integer>{

    //返回某产品对应到评价集合
    List<Review> findByProductOrderByIdDesc(Product product);

    //返回某产品对应到评价数量
    int countByProduct(Product product);

}
