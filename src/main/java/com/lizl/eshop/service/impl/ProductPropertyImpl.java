package com.lizl.eshop.service.impl;

import com.lizl.eshop.mapper.ProductPropertyMapper;
import com.lizl.eshop.model.ProductProperty;
import com.lizl.eshop.product.rabbitmq.RabbitMqSender;
import com.lizl.eshop.product.rabbitmq.RabbitQueue;
import com.lizl.eshop.service.ProductPropertyService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by lizhaoliang on 18/2/14.
 */
@Service
public class ProductPropertyImpl implements ProductPropertyService{

    @Autowired
    ProductPropertyMapper productPropertyMapper;
    @Autowired
    RabbitMqSender rabbitMqSender;

    @Override
    public void add(ProductProperty productProperty, String operationType) {
        productPropertyMapper.add(productProperty);

        String queue = null;

        if(StringUtils.isEmpty(operationType)){
            queue = RabbitQueue.DATA_CHANGE_QUEUE;
        }else if("refresh".equals(operationType)){
            queue = RabbitQueue.REFRESH_DATA_CHANGE_QUEUE;
        }else if("high".equals(operationType)){
            queue = RabbitQueue.HIGH_PRIORITY_DATA_CHANGE_QUEUE;
        }
        rabbitMqSender.send(queue, "{\"event_type\":\"add\",\"data_type\":\"product_property\",\"id\": \""+productProperty.getId()+"\",\"product_id\""+ productProperty.getProductId() +"}");

    }

    @Override
    public void update(ProductProperty productProperty, String operationType) {
        productPropertyMapper.update(productProperty);

        String queue = null;

        if(StringUtils.isEmpty(operationType)){
            queue = RabbitQueue.DATA_CHANGE_QUEUE;
        }else if("refresh".equals(operationType)){
            queue = RabbitQueue.REFRESH_DATA_CHANGE_QUEUE;
        }else if("high".equals(operationType)){
            queue = RabbitQueue.HIGH_PRIORITY_DATA_CHANGE_QUEUE;
        }
        rabbitMqSender.send(queue, "{\"event_type\":\"update\",\"data_type\":\"product_property\",\"id\": \""+productProperty.getId()+"\",\"product_id\":"+ productProperty.getProductId() +"}");
    }

    @Override
    public void delete(Integer id, String operationType) {
        ProductProperty productProperty = findById(id);
        productPropertyMapper.delete(id);

        String queue = null;

        if(StringUtils.isEmpty(operationType)){
            queue = RabbitQueue.DATA_CHANGE_QUEUE;
        }else if("refresh".equals(operationType)){
            queue = RabbitQueue.REFRESH_DATA_CHANGE_QUEUE;
        }else if("high".equals(operationType)){
            queue = RabbitQueue.HIGH_PRIORITY_DATA_CHANGE_QUEUE;
        }
        rabbitMqSender.send(queue, "{\"event_type\":\"delete\",\"data_type\":\"product_property\",\"id\": \""+ id +"\",\"product_id\":"+ productProperty.getProductId() +"}");
    }

    @Override
    public ProductProperty findById(Integer id) {
        return productPropertyMapper.findById(id);
    }

    @Override
    public ProductProperty findByProductId(Integer productId){
        return productPropertyMapper.findByProductId(productId);
    }
}
