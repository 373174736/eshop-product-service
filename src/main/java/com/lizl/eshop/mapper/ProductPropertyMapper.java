package com.lizl.eshop.mapper;

import com.lizl.eshop.model.Brand;
import com.lizl.eshop.model.ProductProperty;
import org.apache.ibatis.annotations.*;

/**
 * Created by lizhaoliang on 18/2/14.
 */
@Mapper
public interface ProductPropertyMapper {

    @Insert("INSERT INTO product_property(name,value,product_id) VALUES(#{name},#{value},#{productId})")
    public void add(ProductProperty productProperty);
    @Update("UPDATE product_property SET name=#{name},value=#{value},product_id=#{productId} WHERE id=#{id}")
    public void update(ProductProperty productProperty);
    @Delete("DELETE FROM product_property WHERE id=#{id}")
    public void delete(Integer id);
    @Select("SELECT * FROM product_property WHERE id=#{id}")
    public ProductProperty findById(Integer id);
    @Select("SELECT * FROM product_property WHERE product_id=#{productId}")
    public ProductProperty findByProductId(Integer productId);
}
