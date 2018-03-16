package com.lizl.eshop.service;

import com.lizl.eshop.model.ProductSpecification;

/**
 * Created by lizhaoliang on 18/2/14.
 */
public interface ProductSpecificationService {

    public void add(ProductSpecification productSpecification, String operationType);

    public void update(ProductSpecification productSpecification, String operationType);

    public void delete(Integer id, String operationType);

    public ProductSpecification findById(Integer id);

    public ProductSpecification findByProductId(Integer ProductId);
}
