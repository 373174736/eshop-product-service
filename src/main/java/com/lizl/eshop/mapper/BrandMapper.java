package com.lizl.eshop.mapper;

import com.lizl.eshop.model.Brand;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * Created by lizhaoliang on 18/2/14.
 */
@Mapper
public interface BrandMapper {

    @Insert("INSERT INTO brand(name,description) VALUES(#{name},#{description})")
    public void add(Brand brand);
    @Update("UPDATE brand SET name=#{name},description=#{description} WHERE id=#{id}")
    public void update(Brand brand);
    @Delete("DELETE FROM brand WHERE id=#{id}")
    public void delete(Integer id);
    @Select("SELECT * FROM brand WHERE id=#{id}")
    public Brand findById(Integer id);
    @Select("SELECT * FROM brand WHERE id in(#{ids})")
    public List<Brand> findByIds(String ids);
}
