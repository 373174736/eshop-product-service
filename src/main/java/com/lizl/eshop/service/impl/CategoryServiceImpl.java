package com.lizl.eshop.service.impl;

import com.lizl.eshop.mapper.CategoryMapper;
import com.lizl.eshop.model.Category;
import com.lizl.eshop.product.rabbitmq.RabbitMqSender;
import com.lizl.eshop.product.rabbitmq.RabbitQueue;
import com.lizl.eshop.service.CategoryService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by lizhaoliang on 18/2/14.
 */
@Service
public class CategoryServiceImpl implements CategoryService{

    @Autowired
    CategoryMapper categoryMapper;
    @Autowired
    RabbitMqSender rabbitMqSender;

    @Override
    public void add(Category category, String operationType) {
        categoryMapper.add(category);

        String queue = null;

        if(StringUtils.isEmpty(operationType)){
            queue = RabbitQueue.DATA_CHANGE_QUEUE;
        }else if("refresh".equals(operationType)){
            queue = RabbitQueue.REFRESH_DATA_CHANGE_QUEUE;
        }else if("high".equals(operationType)){
            queue = RabbitQueue.HIGH_PRIORITY_DATA_CHANGE_QUEUE;
        }

        rabbitMqSender.send(queue, "{\"event_type\":\"add\",\"data_type\":\"category\",\"id\": \""+category.getId()+"\"}");
    }

    @Override
    public void update(Category category, String operationType) {
        categoryMapper.update(category);

        String queue = null;

        if(StringUtils.isEmpty(operationType)){
            queue = RabbitQueue.DATA_CHANGE_QUEUE;
        }else if("refresh".equals(operationType)){
            queue = RabbitQueue.REFRESH_DATA_CHANGE_QUEUE;
        }else if("high".equals(operationType)){
            queue = RabbitQueue.HIGH_PRIORITY_DATA_CHANGE_QUEUE;
        }
        rabbitMqSender.send(queue, "{\"event_type\":\"update\",\"data_type\":\"category\",\"id\": \""+category.getId()+"\"}");
    }

    @Override
    public void delete(Integer id, String operationType) {
        categoryMapper.delete(id);

        String queue = null;

        if(StringUtils.isEmpty(operationType)){
            queue = RabbitQueue.DATA_CHANGE_QUEUE;
        }else if("refresh".equals(operationType)){
            queue = RabbitQueue.REFRESH_DATA_CHANGE_QUEUE;
        }else if("high".equals(operationType)){
            queue = RabbitQueue.HIGH_PRIORITY_DATA_CHANGE_QUEUE;
        }
        rabbitMqSender.send(queue, "{\"event_type\":\"delete\",\"data_type\":\"category\",\"id\": \""+ id +"\"}");
    }

    @Override
    public Category findById(Integer id) {
        return categoryMapper.findById(id);
    }
}
