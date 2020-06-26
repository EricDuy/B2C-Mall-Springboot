package com.project.tmall.comparator;

import java.util.Comparator;

import com.project.tmall.pojo.Product;

//销量比较器、
//把销量高的放前面
public class ProductSaleCountComparator implements Comparator<Product> {

    @Override
    public int compare(Product p1, Product p2) {
        return p2.getSaleCount()-p1.getSaleCount();
    }

}