package com.lizl.eshop.service.impl;

import com.lizl.eshop.mapper.ProductIntroMapper;
import com.lizl.eshop.model.ProductIntro;
import com.lizl.eshop.product.rabbitmq.RabbitMqSender;
import com.lizl.eshop.product.rabbitmq.RabbitQueue;
import com.lizl.eshop.service.ProductIntroService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by lizhaoliang on 18/2/14.
 */
@Service
public class ProductIntroImpl implements ProductIntroService{

    @Autowired
    ProductIntroMapper productIntroMapper;
    @Autowired
    RabbitMqSender rabbitMqSender;

    @Override
    public void add(ProductIntro productIntro, String operationType) {
        productIntroMapper.add(productIntro);

        String queue = null;

        if(StringUtils.isEmpty(operationType)){
            queue = RabbitQueue.DATA_CHANGE_QUEUE;
        }else if("refresh".equals(operationType)){
            queue = RabbitQueue.REFRESH_DATA_CHANGE_QUEUE;
        }else if("high".equals(operationType)){
            queue = RabbitQueue.HIGH_PRIORITY_DATA_CHANGE_QUEUE;
        }
        rabbitMqSender.send(queue, "{\"event_type\":\"add\",\"data_type\":\"product_intro\",\"id\": \""+productIntro.getId()+ "\",\"product_id\":" + productIntro.getProductId() + "}");
    }

    @Override
    public void update(ProductIntro productIntro, String operationType) {
        productIntroMapper.update(productIntro);

        String queue = null;

        if(StringUtils.isEmpty(operationType)){
            queue = RabbitQueue.DATA_CHANGE_QUEUE;
        }else if("refresh".equals(operationType)){
            queue = RabbitQueue.REFRESH_DATA_CHANGE_QUEUE;
        }else if("high".equals(operationType)){
            queue = RabbitQueue.HIGH_PRIORITY_DATA_CHANGE_QUEUE;
        }
        rabbitMqSender.send(queue, "{\"event_type\":\"update\",\"data_type\":\"product_intro\",\"id\": \"" +productIntro.getId()+ "\",\"product_id\":" + productIntro.getProductId() + "}");
    }

    @Override
    public void delete(Integer id, String operationType) {
        ProductIntro productIntro = findById(id);
        productIntroMapper.delete(id);

        String queue = null;

        if(StringUtils.isEmpty(operationType)){
            queue = RabbitQueue.DATA_CHANGE_QUEUE;
        }else if("refresh".equals(operationType)){
            queue = RabbitQueue.REFRESH_DATA_CHANGE_QUEUE;
        }else if("high".equals(operationType)){
            queue = RabbitQueue.HIGH_PRIORITY_DATA_CHANGE_QUEUE;
        }
        rabbitMqSender.send(queue, "{\"event_type\":\"delete\",\"data_type\":\"product_intro\",\"id\": \""+id+"\",\"product_id\":" + productIntro.getProductId() + "}");
    }

    @Override
    public ProductIntro findById(Integer id) {
        return productIntroMapper.findById(id);
    }
}
