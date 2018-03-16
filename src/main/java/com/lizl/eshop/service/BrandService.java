package com.lizl.eshop.service;

import com.lizl.eshop.model.Brand;

import java.util.List;

/**
 * Created by lizhaoliang on 18/2/14.
 */
public interface BrandService {

    public void add(Brand brand, String operationType);

    public void update(Brand brand, String operationType);

    public void delete(Integer id, String operationType);

    public Brand findById(Integer id);

    public List<Brand> findByIds(String ids);
}
