package com.lizl.eshop.mapper;

import com.lizl.eshop.model.Category;
import org.apache.ibatis.annotations.*;

/**
 * Created by lizhaoliang on 18/2/14.
 */
@Mapper
public interface CategoryMapper {

    @Insert("INSERT INTO category(name,description) VALUES(#{name},#{description})")
    public void add(Category category);
    @Update("UPDATE category SET name=#{name},description=#{description} WHERE id=#{id}")
    public void update(Category category);
    @Delete("DELETE FROM category WHERE id=#{id}")
    public void delete(Integer id);
    @Select("SELECT * FROM category WHERE id=#{id}")
    public Category findById(Integer id);
}
