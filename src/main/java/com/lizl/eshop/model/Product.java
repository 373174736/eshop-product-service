package com.lizl.eshop.model;

/**
 * Created by lizhaoliang on 18/2/14.
 */
public class Product {

    private Integer id;
    private String name;
    private Integer categoryId;
    private Integer brandId;

    public Product(){

    }

    public Product(Integer id, String name, Integer categoryId, Integer brandId) {
        this.id = id;
        this.name = name;
        this.categoryId = categoryId;
        this.brandId = brandId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public Integer getBrandId() {
        return brandId;
    }

    public void setBrandId(Integer brandId) {
        this.brandId = brandId;
    }
}
