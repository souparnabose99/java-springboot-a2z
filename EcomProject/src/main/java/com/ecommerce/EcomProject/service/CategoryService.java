package com.ecommerce.EcomProject.service;

import com.ecommerce.EcomProject.model.Category;
import com.ecommerce.EcomProject.payload.CategoryDTO;
import com.ecommerce.EcomProject.payload.CategoryResponse;

import java.util.List;

public interface CategoryService {
    //List<Category> getAllCategories();
    //CategoryResponse getAllCategories();
    CategoryResponse getAllCategories(Integer pageNumber, Integer pageSize);
    //void createCategory(Category category);
    CategoryDTO createCategory(CategoryDTO categoryDTO);
    //String deleteCategory(Long categoryId);
    CategoryDTO deleteCategory(Long categoryId);
    //Category updateCategory(Category category, Long categoryId);
    CategoryDTO updateCategory(CategoryDTO categoryDTO, Long categoryId);
}
