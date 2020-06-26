package com.project.tmall.comparator;

import com.project.tmall.pojo.Product;

import java.util.Comparator;


//综合比较器，将销量*评价高的放在前面
public class ProductAllComparator implements Comparator<Product>{

    @Override
    public int compare(Product p1, Product p2) {
        return p2.getReviewCount()*p2.getSaleCount()-p1.getReviewCount()*p1.getSaleCount();
    }
}
