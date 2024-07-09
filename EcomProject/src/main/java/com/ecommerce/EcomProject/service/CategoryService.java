package com.ecommerce.EcomProject.service;

import com.ecommerce.EcomProject.model.Category;

import java.util.List;

public interface CategoryService {
    List<Category> getAllCategories();
    void createCategory(Category category);
    String deleteCategory(Long categoryId);
}
