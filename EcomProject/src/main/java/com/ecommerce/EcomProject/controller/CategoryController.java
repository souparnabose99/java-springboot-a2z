package com.ecommerce.EcomProject.controller;

import com.ecommerce.EcomProject.model.Category;
import com.ecommerce.EcomProject.service.CategoryService;
import com.ecommerce.EcomProject.service.CategoryServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    /*
    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }
    */

    @GetMapping("/api/public/categories")
    public List<Category> getAllCategories(){
        return categoryService.getAllCategories();
    }

    @PostMapping("/api/admin/categories")
    public String createCategory(@RequestBody Category category){
        categoryService.createCategory(category);
        return "Category added successfully !!";
    }

    @DeleteMapping("/api/admin/categories/{categoryId}")
    public String deleteCategory(@PathVariable Long categoryId){
        String status = categoryService.deleteCategory(categoryId);
        return status;
    }

}
