package com.lizl.eshop.web.controller;

import com.lizl.eshop.model.Product;
import com.lizl.eshop.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by lizhaoliang on 18/2/14.
 */
@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    ProductService productService;

    @RequestMapping("/add")
    @ResponseBody
    public String add(Product product, String operationType){
        productService.add(product, operationType);
        return "sucess";
    }

    @RequestMapping("/update")
    @ResponseBody
    public String update(Product product, String operationType){
        productService.update(product, operationType);
        return "sucess";
    }

    @RequestMapping("/delete")
    @ResponseBody
    public String delete(Integer id, String operationType){
        try {
            productService.delete(id, operationType);
            return "sucess";
        }catch (Exception e){
            e.printStackTrace();
            return "error";
        }
    }

    @RequestMapping("findById")
    @ResponseBody
    public Product findById(Integer id){
        try {
            return  productService.findById(id);
        }catch (Exception e){
            e.printStackTrace();
        }
        return new Product();
    }
}
