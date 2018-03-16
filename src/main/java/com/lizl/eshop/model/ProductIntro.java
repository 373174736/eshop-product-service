package com.lizl.eshop.model;

/**
 * Created by lizhaoliang on 18/2/22.
 */
public class ProductIntro {

    private Integer id;
    private String content;
    private Integer productId;

    public  ProductIntro(){

    }

    public ProductIntro(Integer id, String content, Integer productId) {
        this.id = id;
        this.content = content;
        this.productId = productId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }
}
