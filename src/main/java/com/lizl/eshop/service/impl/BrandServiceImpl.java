package com.lizl.eshop.service.impl;

import com.lizl.eshop.mapper.BrandMapper;
import com.lizl.eshop.model.Brand;
import com.lizl.eshop.product.rabbitmq.RabbitMqSender;
import com.lizl.eshop.product.rabbitmq.RabbitQueue;
import com.lizl.eshop.service.BrandService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by lizhaoliang on 18/2/14.
 */
@Service
public class BrandServiceImpl implements BrandService{

    @Autowired
    BrandMapper brandMapper;
    @Autowired
    RabbitMqSender rabbitMqSender;

    @Override
    public void add(Brand brand, String operationType) {
        brandMapper.add(brand);

        String queue = null;

        if(StringUtils.isEmpty(operationType)){
            queue = RabbitQueue.DATA_CHANGE_QUEUE;
        }else if("refresh".equals(operationType)){
            queue = RabbitQueue.REFRESH_DATA_CHANGE_QUEUE;
        }else if("high".equals(operationType)){
            queue = RabbitQueue.HIGH_PRIORITY_DATA_CHANGE_QUEUE;
        }

        rabbitMqSender.send(queue, "{\"event_type\":\"add\",\"data_type\":\"brand\",\"id\": \""+brand.getId()+"\"}");
    }

    @Override
    public void update(Brand brand, String operationType) {
        brandMapper.update(brand);

        String queue = null;

        if(StringUtils.isEmpty(operationType)){
            queue = RabbitQueue.DATA_CHANGE_QUEUE;
        }else if("refresh".equals(operationType)){
            queue = RabbitQueue.REFRESH_DATA_CHANGE_QUEUE;
        }else if("high".equals(operationType)){
            queue = RabbitQueue.HIGH_PRIORITY_DATA_CHANGE_QUEUE;
        }

        rabbitMqSender.send(queue, "{\"event_type\":\"update\",\"data_type\":\"brand\",\"id\": \""+brand.getId()+"\"}");
    }

    @Override
    public void delete(Integer id, String operationType) {
        brandMapper.delete(id);

        String queue = null;

        if(StringUtils.isEmpty(operationType)){
            queue = RabbitQueue.DATA_CHANGE_QUEUE;
        }else if("refresh".equals(operationType)){

        }else if("high".equals(operationType)){
            queue = RabbitQueue.HIGH_PRIORITY_DATA_CHANGE_QUEUE;
        }

        rabbitMqSender.send(queue, "{\"event_type\":\"delete\",\"data_type\":\"brand\",\"id\": \""+ id +"\"}");
    }

    @Override
    public Brand findById(Integer id) {
        return brandMapper.findById(id);
    }

    public List<Brand> findByIds(String ids){

        return brandMapper.findByIds(ids);
    }
}
