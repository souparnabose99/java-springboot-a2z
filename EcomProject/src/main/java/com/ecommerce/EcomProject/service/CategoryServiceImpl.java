package com.ecommerce.EcomProject.service;

import com.ecommerce.EcomProject.model.Category;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService{

    private List<Category> categories = new ArrayList<>();

    @Override
    public List<Category> getAllCategories(){
        return categories;
    }

    @Override
    public void createCategory(Category category){
        categories.add(category);
    }

}
