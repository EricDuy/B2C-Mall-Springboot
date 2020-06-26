package com.project.tmall.dao;

import com.project.tmall.pojo.Product;
import com.project.tmall.pojo.ProductImage;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductImageDAO extends JpaRepository<ProductImage,Integer> {
    List<ProductImage> findByProductAndTypeOrderByIdDesc(Product product, String type);

}