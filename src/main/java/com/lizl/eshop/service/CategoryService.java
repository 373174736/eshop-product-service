package com.lizl.eshop.service;

import com.lizl.eshop.model.Category;

/**
 * Created by lizhaoliang on 18/2/14.
 */
public interface CategoryService {

    public void add(Category category, String operationType);

    public void update(Category category, String operationType);

    public void delete(Integer id, String operationType);

    public Category findById(Integer id);
}
