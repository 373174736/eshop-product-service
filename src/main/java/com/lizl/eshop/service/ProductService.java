package com.lizl.eshop.service;

import com.lizl.eshop.model.Product;

/**
 * Created by lizhaoliang on 18/2/14.
 */
public interface ProductService {

    public void add(Product product, String operationType);

    public void update(Product product, String operationType);

    public void delete(Integer id, String operationType);

    public Product findById(Integer id);
}
