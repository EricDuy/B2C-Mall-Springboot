package com.project.tmall.service;

import com.project.tmall.dao.ReviewDAO;
import com.project.tmall.pojo.Product;
import com.project.tmall.pojo.Review;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewService {

    @Autowired ReviewDAO reviewDAO;
    @Autowired ProductService productService;

    public void add(Review review){
        reviewDAO.save(review);
    }

    public List<Review> list(Product product){
        List<Review> result = reviewDAO.findByProductOrderByIdDesc(product);
        return result;
    }

    public int getCount(Product product){
        return reviewDAO.countByProduct(product);
    }
}
