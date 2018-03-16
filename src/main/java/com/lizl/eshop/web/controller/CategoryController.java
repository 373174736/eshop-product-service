package com.lizl.eshop.web.controller;

import com.lizl.eshop.model.Category;
import com.lizl.eshop.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by lizhaoliang on 18/2/14.
 */
@RestController
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    CategoryService categoryService;

    @RequestMapping("/add")
    @ResponseBody
    public String add(Category category, String operationType){
        categoryService.add(category, operationType);
        return "sucess";
    }

    @RequestMapping("/update")
    @ResponseBody
    public String update(Category category, String operationType){
        categoryService.update(category, operationType);
        return "sucess";
    }

    @RequestMapping("/delete")
    @ResponseBody
    public String delete(Integer id, String operationType){
        try {
            categoryService.delete(id, operationType);
            return "sucess";
        }catch (Exception e){
            e.printStackTrace();
            return "error";
        }
    }

    @RequestMapping("findById")
    @ResponseBody
    public Category findById(Integer id){
        try {
            return  categoryService.findById(id);
        }catch (Exception e){
            e.printStackTrace();
        }
        return new Category();
    }
}
