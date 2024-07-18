package com.ecommerce.EcomProject.service;

import com.ecommerce.EcomProject.exceptions.ApiException;
import com.ecommerce.EcomProject.exceptions.ResourceNotFoundException;
import com.ecommerce.EcomProject.model.Category;
import com.ecommerce.EcomProject.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CategoryServiceImpl implements CategoryService{

    @Autowired
    private CategoryRepository categoryRepository;

    //private List<Category> categories = new ArrayList<>();

    private Long nextId = 1L;

    @Override
    public List<Category> getAllCategories(){
        //return categories;
        return categoryRepository.findAll();
    }

    @Override
    public void createCategory(Category category){
        Category savedCategory = categoryRepository.findByCategoryName(category.getCategoryName());
        if (savedCategory != null)
            throw new ApiException("Category with the name " + category.getCategoryName() + " already exists !!");
        category.setCategoryId(nextId++);
        //categories.add(category);
        categoryRepository.save(category);
    }

    @Override
    public String deleteCategory(Long categoryId) {
        Category category = categoryRepository.findById(categoryId).orElseThrow(() -> new ResourceNotFoundException("Category", "categoryId", categoryId));
        //Category category = categoryRepository.findById(categoryId).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Resource not found"));
        //List<Category> categories = categoryRepository.findAll();
        //Category category = categories.stream().
        //        filter(c -> c.getCategoryId().equals(categoryId)).findFirst().
        //        orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Resource not found"));

        //categories.remove(category);
        categoryRepository.delete(category);
        return "Category with categoryId: " + categoryId + " has been deleted !!";
    }

    @Override
    public Category updateCategory(Category category, Long categoryId) {
        //List<Category> categories = categoryRepository.findAll();
        //Optional<Category> savedCategoryOptional = categoryRepository.findById(categoryId);
        //Optional<Category> optionalCategory = categories.stream().
        //        filter(c -> c.getCategoryId().equals(categoryId)).findFirst();

        //if (optionalCategory.isPresent()){
        //    Category existingCategory = optionalCategory.get();
        //    existingCategory.setCategoryName(category.getCategoryName());
        //    return categoryRepository.save(existingCategory);
        // } else{
        //            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Category not found");
        //        }
        //Category savedCategory =  categoryRepository.findById(categoryId).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Resource not found"));
        Category savedCategory =  categoryRepository.findById(categoryId).orElseThrow(() -> new ResourceNotFoundException("Category", "categoryId", categoryId));
        category.setCategoryId(categoryId);
        savedCategory = categoryRepository.save(category);
        return savedCategory;

    }

}
