package com.ecommerce.EcomProject.service;

import com.ecommerce.EcomProject.model.Category;
import com.ecommerce.EcomProject.payload.CategoryDTO;
import com.ecommerce.EcomProject.payload.CategoryResponse;

import java.util.List;

public interface CategoryService {
    //List<Category> getAllCategories();
    CategoryResponse getAllCategories();
    //void createCategory(Category category);
    CategoryDTO createCategory(CategoryDTO categoryDTO);
    String deleteCategory(Long categoryId);
    //Category updateCategory(Category category, Long categoryId);
    CategoryDTO updateCategory(CategoryDTO categoryDTO, Long categoryId);
}
