package com.lizl.eshop.mapper;

import com.lizl.eshop.model.ProductIntro;
import org.apache.ibatis.annotations.*;

/**
 * Created by lizhaoliang on 18/2/14.
 */
@Mapper
public interface ProductIntroMapper {

    @Insert("INSERT INTO product_intro(content,product_id) VALUES(#{content},#{productId})")
    public void add(ProductIntro productIntro);
    @Update("UPDATE product_intro SET content=#{content},product_id=#{productId} WHERE id=#{id}")
    public void update(ProductIntro productIntro);
    @Delete("DELETE FROM product_intro WHERE id=#{id}")
    public void delete(Integer id);
    @Select("SELECT * FROM product_intro WHERE id=#{id}")
    public ProductIntro findById(Integer id);
}
