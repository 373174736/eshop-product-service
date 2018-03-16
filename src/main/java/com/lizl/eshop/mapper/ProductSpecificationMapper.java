package com.lizl.eshop.mapper;

import com.lizl.eshop.model.ProductSpecification;
import org.apache.ibatis.annotations.*;

/**
 * Created by lizhaoliang on 18/2/14.
 */
@Mapper
public interface ProductSpecificationMapper {

    @Insert("INSERT INTO product_specification(name,value,product_id) VALUES(#{name},#{value},#{productId})")
    public void add(ProductSpecification productSpecification);
    @Update("UPDATE product_specification SET name=#{name},value=#{value},product_id=#{productId} WHERE id=#{id}")
    public void update(ProductSpecification productSpecification);
    @Delete("DELETE FROM product_specification WHERE id=#{id}")
    public void delete(Integer id);
    @Select("SELECT * FROM product_specification WHERE id=#{id}")
    public ProductSpecification findById(Integer id);
    @Select("SELECT * FROM product_specification WHERE product_id=#{productId}")
    public ProductSpecification findByProductId(Integer productId);
}
