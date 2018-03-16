package com.lizl.eshop.model;

/**
 * Created by lizhaoliang on 18/2/22.
 */
public class ProductSpecification {

    private Integer id;
    private String name;
    private String value;
    private Integer productId;

    public ProductSpecification(){

    }

    public ProductSpecification(Integer id, String name, String value, Integer productId) {
        this.id = id;
        this.name = name;
        this.value = value;
        this.productId = productId;
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

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }
}
