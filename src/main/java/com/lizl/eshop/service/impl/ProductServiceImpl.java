package com.lizl.eshop.service.impl;

import com.lizl.eshop.mapper.ProductMapper;
import com.lizl.eshop.model.Product;
import com.lizl.eshop.product.rabbitmq.RabbitMqSender;
import com.lizl.eshop.product.rabbitmq.RabbitQueue;
import com.lizl.eshop.service.ProductService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by lizhaoliang on 18/2/14.
 */
@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductMapper productMapper;
    @Autowired
    RabbitMqSender rabbitMqSender;

    @Override
    public void add(Product product, String operationType) {
        productMapper.add(product);

        String queue = null;

        if(StringUtils.isEmpty(operationType)){
            queue = RabbitQueue.DATA_CHANGE_QUEUE;
        }else if("refresh".equals(operationType)){
            queue = RabbitQueue.REFRESH_DATA_CHANGE_QUEUE;
        }else if("high".equals(operationType)){
            queue = RabbitQueue.HIGH_PRIORITY_DATA_CHANGE_QUEUE;
        }
        rabbitMqSender.send(queue, "{\"event_type\":\"add\",\"data_type\":\"product\",\"id\": \""+product.getId()+"\"}");
    }

    @Override
    public void update(Product product, String operationType) {
        productMapper.update(product);

        String queue = null;

        if(StringUtils.isEmpty(operationType)){
            queue = RabbitQueue.DATA_CHANGE_QUEUE;
        }else if("refresh".equals(operationType)){
            queue = RabbitQueue.REFRESH_DATA_CHANGE_QUEUE;
        }else if("high".equals(operationType)){
            queue = RabbitQueue.HIGH_PRIORITY_DATA_CHANGE_QUEUE;
        }
        rabbitMqSender.send(queue, "{\"event_type\":\"update\",\"data_type\":\"product\",\"id\": \""+product.getId()+"\"}");
    }

    @Override
    public void delete(Integer id, String operationType) {
        productMapper.delete(id);

        String queue = null;

        if(StringUtils.isEmpty(operationType)){
            queue = RabbitQueue.DATA_CHANGE_QUEUE;
        }else if("refresh".equals(operationType)){
            queue = RabbitQueue.REFRESH_DATA_CHANGE_QUEUE;
        }else if("high".equals(operationType)){
            queue = RabbitQueue.HIGH_PRIORITY_DATA_CHANGE_QUEUE;
        }
        rabbitMqSender.send(queue, "{\"event_type\":\"delete\",\"data_type\":\"product\",\"id\": \""+ id +"\"}");
    }

    @Override
    public Product findById(Integer id) {
        return productMapper.findById(id);
    }
}
