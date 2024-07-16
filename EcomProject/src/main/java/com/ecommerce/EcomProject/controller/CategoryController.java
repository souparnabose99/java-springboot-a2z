package com.ecommerce.EcomProject.controller;

import com.ecommerce.EcomProject.model.Category;
import com.ecommerce.EcomProject.payload.CategoryDTO;
import com.ecommerce.EcomProject.payload.CategoryResponse;
import com.ecommerce.EcomProject.service.CategoryService;
import com.ecommerce.EcomProject.service.CategoryServiceImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    /*
    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }
    */

    @GetMapping("/public/categories")
    //public ResponseEntity<List<Category>> getAllCategories(){
    public ResponseEntity<CategoryResponse> getAllCategories(){
        CategoryResponse categoryResponse = categoryService.getAllCategories();
        //return new ResponseEntity<>(categories, HttpStatus.OK);
        return new ResponseEntity<>(categoryResponse, HttpStatus.OK);
    }

    @PostMapping("/admin/categories")
    //public ResponseEntity<String> createCategory(@Valid @RequestBody Category category){
    public ResponseEntity<CategoryDTO> createCategory(@Valid @RequestBody CategoryDTO categoryDTO){
        // categoryService.createCategory(category);
        CategoryDTO savedCategoryDTO = categoryService.createCategory(categoryDTO);
        //return new ResponseEntity<>("Category added successfully !!", HttpStatus.CREATED);
        return new ResponseEntity<>(savedCategoryDTO, HttpStatus.CREATED);
    }

    @DeleteMapping("/admin/categories/{categoryId}")
    public ResponseEntity<String> deleteCategory(@PathVariable Long categoryId){
        //try {
        String status = categoryService.deleteCategory(categoryId);
        return new ResponseEntity<>(status, HttpStatus.OK);
        //} catch (ResponseStatusException e){
        //    return new ResponseEntity<>(e.getReason(), e.getStatusCode());
        //}
    }

    @PutMapping("/admin/categories/{categoryId}")
    //public ResponseEntity<String> updateCategory(@Valid @RequestBody Category category, @PathVariable Long categoryId){
    public ResponseEntity<CategoryDTO> updateCategory(@Valid @RequestBody CategoryDTO categoryDTO, @PathVariable Long categoryId){
        CategoryDTO savedCategoryDTO = categoryService.updateCategory(categoryDTO, categoryId);
        return new ResponseEntity<>(savedCategoryDTO, HttpStatus.OK);
        //try{
        //Category savedCategory = categoryService.updateCategory(category, categoryId);
        //return new ResponseEntity<>("Category with categoryId: " + categoryId + " updated !!", HttpStatus.OK);
        //} catch(ResponseStatusException e){
        //    return new ResponseEntity<>(e.getReason(), e.getStatusCode());
        //}
    }

}
