package com.lizl.eshop.web.controller;

import com.lizl.eshop.model.ProductSpecification;
import com.lizl.eshop.service.ProductSpecificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by lizhaoliang on 18/2/14.
 */
@RestController
@RequestMapping("/product-specification")
public class ProductSpecificationController {

    @Autowired
    ProductSpecificationService productSpecificationService;

    @RequestMapping("/add")
    @ResponseBody
    public String add(ProductSpecification productSpecification, String operationType){
        productSpecificationService.add(productSpecification, operationType);
        return "sucess";
    }

    @RequestMapping("/update")
    @ResponseBody
    public String update(ProductSpecification productSpecification, String operationType){
        productSpecificationService.update(productSpecification, operationType);
        return "sucess";
    }

    @RequestMapping("/delete")
    @ResponseBody
    public String delete(Integer id,  String operationType){
        try {
            productSpecificationService.delete(id, operationType);
            return "sucess";
        }catch (Exception e){
            e.printStackTrace();
            return "error";
        }
    }

    @RequestMapping("findById")
    @ResponseBody
    public ProductSpecification findById(Integer id){
        try {
            return  productSpecificationService.findById(id);
        }catch (Exception e){
            e.printStackTrace();
        }
        return new ProductSpecification();
    }

    @RequestMapping("findByProductId")
    @ResponseBody
    public ProductSpecification findByProductId(Integer productId){
        try {
            return  productSpecificationService.findByProductId(productId);
        }catch (Exception e){
            e.printStackTrace();
        }
        return new ProductSpecification();
    }
}
