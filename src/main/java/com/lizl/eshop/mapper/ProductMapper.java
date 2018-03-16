package com.lizl.eshop.mapper;

import com.lizl.eshop.model.Product;
import org.apache.ibatis.annotations.*;

/**
 * Created by lizhaoliang on 18/2/14.
 */
@Mapper
public interface ProductMapper {

    @Insert("INSERT INTO product(name,category_id,brand_id) VALUES(#{name},#{categoryId},#{brandId})")
    public void add(Product product);
    @Update("UPDATE product SET name=#{name},category_id=#{categoryId},brand_id=#{brandId} WHERE id=#{id}")
    public void update(Product product);
    @Delete("DELETE FROM product WHERE id=#{id}")
    public void delete(Integer id);
    @Select("SELECT * FROM product WHERE id=#{id}")
    @Results({
            @Result(column = "category_id", property = "categoryId"),
            @Result(column = "brand_id", property = "brandId")
    })
    public Product findById(Integer id);
}
