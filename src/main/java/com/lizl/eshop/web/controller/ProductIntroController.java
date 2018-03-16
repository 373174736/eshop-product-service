package com.lizl.eshop.web.controller;

import com.lizl.eshop.model.ProductIntro;
import com.lizl.eshop.service.ProductIntroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by lizhaoliang on 18/2/14.
 */
@RestController
@RequestMapping("/product-intro")
public class ProductIntroController {

    @Autowired
    ProductIntroService productIntroService;

    @RequestMapping("/add")
    @ResponseBody
    public String add(ProductIntro productIntro, String operationType){
        productIntroService.add(productIntro, operationType);
        return "sucess";
    }

    @RequestMapping("/update")
    @ResponseBody
    public String update(ProductIntro productIntro, String operationType){
        productIntroService.update(productIntro, operationType);
        return "sucess";
    }

    @RequestMapping("/delete")
    @ResponseBody
    public String delete(Integer id, String operationType){
        try {
            productIntroService.delete(id, operationType);
            return "sucess";
        }catch (Exception e){
            e.printStackTrace();
            return "error";
        }
    }

    @RequestMapping("findById")
    @ResponseBody
    public ProductIntro findById(Integer id){
        try {
            return  productIntroService.findById(id);
        }catch (Exception e){
            e.printStackTrace();
        }
        return new ProductIntro();
    }
}
