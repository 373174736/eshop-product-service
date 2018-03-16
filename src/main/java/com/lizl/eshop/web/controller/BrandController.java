package com.lizl.eshop.web.controller;

import com.lizl.eshop.model.Brand;
import com.lizl.eshop.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lizhaoliang on 18/2/14.
 */
@RestController
@RequestMapping("/brand")
public class BrandController {

    @Autowired
    BrandService brandService;

    @RequestMapping("/add")
    @ResponseBody
    public String add(Brand brand, String operationType){
        brandService.add(brand, operationType);
        return "sucess";
    }

    @RequestMapping("/update")
    @ResponseBody
    public String update(Brand brand, String operationType){
        brandService.update(brand, operationType);
        return "sucess";
    }

    @RequestMapping("/delete")
    @ResponseBody
    public String delete(Integer id, String operationType){
        try {
            brandService.delete(id, operationType);
            return "sucess";
        }catch (Exception e){
            e.printStackTrace();
            return "error";
        }
    }

    @RequestMapping("findById")
    @ResponseBody
    public Brand findById(Integer id){
        try {
            return  brandService.findById(id);
        }catch (Exception e){
            e.printStackTrace();
        }
        return new Brand();
    }

    @RequestMapping("findByIds")
    @ResponseBody
    public List<Brand> findByIds(String ids){
        try {
            return  brandService.findByIds(ids);
        }catch (Exception e){
            e.printStackTrace();
        }
        return new ArrayList<>();
    }
}
