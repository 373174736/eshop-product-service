package com.lizl.eshop.service;

import com.lizl.eshop.model.ProductIntro;

/**
 * Created by lizhaoliang on 18/2/14.
 */
public interface ProductIntroService {

    public void add(ProductIntro productIntro, String operationType);

    public void update(ProductIntro productIntro, String operationType);

    public void delete(Integer id, String operationType);

    public ProductIntro findById(Integer id);
}
