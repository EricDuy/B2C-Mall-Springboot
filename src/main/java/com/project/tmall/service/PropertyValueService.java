package com.project.tmall.service;

import com.project.tmall.dao.PropertyValueDAO;
import com.project.tmall.pojo.Product;
import com.project.tmall.pojo.Property;
import com.project.tmall.pojo.PropertyValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PropertyValueService {

    @Autowired PropertyValueDAO propertyValueDAO;
    @Autowired PropertyService propertyService;

    //修改属性值
    public void update(PropertyValue bean){
        propertyValueDAO.save(bean);
    }

    //初始化的目的：因为对于PropertyValue的管理，没有增加，只有修改。
    //            所以需要通过初始化来进行自动地增加，以便于后面的修改
    public void init(Product product){
        List<Property> properties = propertyService.listByCategory(product.getCategory());
        for(Property property:properties){
            PropertyValue propertyValue = getByPropertyAndProduct(product, property);
            if(propertyValue == null){
                propertyValue = new PropertyValue();
                propertyValue.setProduct(product);
                propertyValue.setProperty(property);
                propertyValueDAO.save(propertyValue);
            }
        }
    }

    private PropertyValue getByPropertyAndProduct(Product product, Property property) {
        return propertyValueDAO.getByPropertyAndProduct(property, product);
    }

    public List<PropertyValue> list(Product product){
        return propertyValueDAO.findByProductOrderByIdDesc(product);
    }
}
