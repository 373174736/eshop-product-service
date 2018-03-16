package com.lizl.eshop.service;

import com.lizl.eshop.model.ProductProperty;

/**
 * Created by lizhaoliang on 18/2/14.
 */
public interface ProductPropertyService {

    public void add(ProductProperty productProperty, String operationType);

    public void update(ProductProperty productProperty, String operationType);

    public void delete(Integer id, String operationType);

    public ProductProperty findById(Integer id);

    public ProductProperty findByProductId(Integer productId);
}
