package com.project.tmall.comparator;

import java.util.Comparator;

import com.project.tmall.pojo.Product;

//价格比较器
//把价格低的放在前面
public class ProductPriceComparator implements Comparator<Product> {

    @Override
    public int compare(Product p1, Product p2) {
        return (int) (p1.getPromotePrice()-p2.getPromotePrice());
    }

}