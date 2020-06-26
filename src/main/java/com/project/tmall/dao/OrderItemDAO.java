package com.project.tmall.dao;

import com.project.tmall.pojo.Order;
import com.project.tmall.pojo.OrderItem;
import com.project.tmall.pojo.Product;
import com.project.tmall.pojo.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderItemDAO extends JpaRepository<OrderItem,Integer>{
    List<OrderItem> findByOrderOrderByIdDesc(Order order);

    //根据产品获取OrderItem
    List<OrderItem> findByProduct(Product product);

    //根据用户获取其订单信息
    List<OrderItem> findByUserAndOrderIsNull(User user);
}
