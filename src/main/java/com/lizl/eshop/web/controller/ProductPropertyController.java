package com.lizl.eshop.web.controller;

import com.lizl.eshop.model.ProductProperty;
import com.lizl.eshop.service.ProductPropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by lizhaoliang on 18/2/14.
 */
@RestController
@RequestMapping("/product-property")
public class ProductPropertyController {

    @Autowired
    ProductPropertyService productPropertyService;

    @RequestMapping("/add")
    @ResponseBody
    public String add(ProductProperty productProperty, String operationType){
        productPropertyService.add(productProperty, operationType);
        return "sucess";
    }

    @RequestMapping("/update")
    @ResponseBody
    public String update(ProductProperty productProperty, String operationType){
        productPropertyService.update(productProperty, operationType);
        return "sucess";
    }

    @RequestMapping("/delete")
    @ResponseBody
    public String delete(Integer id, String operationType){
        try {
            productPropertyService.delete(id, operationType);
            return "sucess";
        }catch (Exception e){
            e.printStackTrace();
            return "error";
        }
    }

    @RequestMapping("findById")
    @ResponseBody
    public ProductProperty findById(Integer id){
        try {
            return  productPropertyService.findById(id);
        }catch (Exception e){
            e.printStackTrace();
        }
        return new ProductProperty();
    }

    @RequestMapping("findByProductId")
    @ResponseBody
    public ProductProperty findByProductId(Integer productId){
        try {
            return  productPropertyService.findByProductId(productId);
        }catch (Exception e){
            e.printStackTrace();
        }
        return new ProductProperty();
    }
}
