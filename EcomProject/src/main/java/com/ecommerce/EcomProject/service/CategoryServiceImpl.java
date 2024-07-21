package com.ecommerce.EcomProject.service;

import com.ecommerce.EcomProject.exceptions.ApiException;
import com.ecommerce.EcomProject.exceptions.ResourceNotFoundException;
import com.ecommerce.EcomProject.model.Category;
import com.ecommerce.EcomProject.payload.CategoryDTO;
import com.ecommerce.EcomProject.payload.CategoryResponse;
import com.ecommerce.EcomProject.repository.CategoryRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoryServiceImpl implements CategoryService{

    @Autowired
    private CategoryRepository categoryRepository;

    //private List<Category> categories = new ArrayList<>();
    //private Long nextId = 1L;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public CategoryResponse getAllCategories(){
        //return categories;
        List<Category> savedCategories = categoryRepository.findAll();
        if (savedCategories.isEmpty())
            throw new ApiException("No categories created till now !!");
        //return categoryRepository.findAll();

        List<CategoryDTO> categoryDTOS = savedCategories.stream()
                .map(category -> modelMapper.map(category, CategoryDTO.class)).toList();
        //return savedCategories;
        CategoryResponse categoryResponse = new CategoryResponse();
        categoryResponse.setContent(categoryDTOS);
        return categoryResponse;
    }

    @Override
    //public void createCategory(Category category){
    public CategoryDTO createCategory(CategoryDTO categoryDTO){
        Category category = modelMapper.map(categoryDTO, Category.class);
        Category categoryFromDb = categoryRepository.findByCategoryName(category.getCategoryName());
        if (categoryFromDb != null)
            throw new ApiException("Category with the name " + category.getCategoryName() + " already exists !!");
        //category.setCategoryId(nextId++);
        //categories.add(category);
        //categoryRepository.save(category);
        Category savedCategories = categoryRepository.save(category);
        CategoryDTO savedCategoryDTO = modelMapper.map(category, CategoryDTO.class);
        return savedCategoryDTO;
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
