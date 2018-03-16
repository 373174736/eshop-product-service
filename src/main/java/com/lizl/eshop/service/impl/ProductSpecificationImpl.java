package com.lizl.eshop.service.impl;

import com.lizl.eshop.mapper.ProductSpecificationMapper;
import com.lizl.eshop.model.ProductSpecification;
import com.lizl.eshop.product.rabbitmq.RabbitMqSender;
import com.lizl.eshop.product.rabbitmq.RabbitQueue;
import com.lizl.eshop.service.ProductSpecificationService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by lizhaoliang on 18/2/14.
 */
@Service
public class ProductSpecificationImpl implements ProductSpecificationService{

    @Autowired
    ProductSpecificationMapper productSpecificationMapper;
    @Autowired
    RabbitMqSender rabbitMqSender;

    @Override
    public void add(ProductSpecification productSpecification, String operationType) {
        productSpecificationMapper.add(productSpecification);

        String queue = null;

        if(StringUtils.isEmpty(operationType)){
            queue = RabbitQueue.DATA_CHANGE_QUEUE;
        }else if("refresh".equals(operationType)){
            queue = RabbitQueue.REFRESH_DATA_CHANGE_QUEUE;
        }else if("high".equals(operationType)){
            queue = RabbitQueue.HIGH_PRIORITY_DATA_CHANGE_QUEUE;
        }
        rabbitMqSender.send(queue, "{\"event_type\":\"add\",\"data_type\":\"product_specification\",\"id\": \""+productSpecification.getId()+"\",\"product_id\": "+ productSpecification.getProductId() +"}");
    }

    @Override
    public void update(ProductSpecification productSpecification, String operationType) {
        productSpecificationMapper.update(productSpecification);

        String queue = null;

        if(StringUtils.isEmpty(operationType)){
            queue = RabbitQueue.DATA_CHANGE_QUEUE;
        }else if("refresh".equals(operationType)){
            queue = RabbitQueue.REFRESH_DATA_CHANGE_QUEUE;
        }else if("high".equals(operationType)){
            queue = RabbitQueue.HIGH_PRIORITY_DATA_CHANGE_QUEUE;
        }
        rabbitMqSender.send(queue, "{\"event_type\":\"update\",\"data_type\":\"product_specification\",\"id\": \""+productSpecification.getId()+"\",\"product_id\":"+ productSpecification.getProductId() +"}");
    }

    @Override
    public void delete(Integer id, String operationType) {
        ProductSpecification productSpecification = findById(id);
        productSpecificationMapper.delete(id);

        String queue = null;

        if(StringUtils.isEmpty(operationType)){
            queue = RabbitQueue.DATA_CHANGE_QUEUE;
        }else if("refresh".equals(operationType)){
            queue = RabbitQueue.REFRESH_DATA_CHANGE_QUEUE;
        }else if("high".equals(operationType)){
            queue = RabbitQueue.HIGH_PRIORITY_DATA_CHANGE_QUEUE;
        }
        rabbitMqSender.send(queue, "{\"event_type\":\"delete\",\"data_type\":\"product_specification\",\"id\": \""+ id +"\",\"product_id\":" + productSpecification.getProductId() + "}");
    }

    @Override
    public ProductSpecification findById(Integer id) {
        return productSpecificationMapper.findById(id);
    }

    @Override
    public ProductSpecification findByProductId(Integer productId) {
        return productSpecificationMapper.findByProductId(productId);
    }
}
