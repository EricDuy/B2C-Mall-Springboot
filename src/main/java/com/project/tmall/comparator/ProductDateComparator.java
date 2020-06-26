package com.project.tmall.comparator;

import com.project.tmall.pojo.Product;

import java.util.Comparator;


// ProductDateComparator 新品比较器
//把创建日期晚的放前面
public class ProductDateComparator implements Comparator<Product> {

    @Override
    public int compare(Product p1, Product p2) {
        return p1.getCreateDate().compareTo(p2.getCreateDate());
    }

}
