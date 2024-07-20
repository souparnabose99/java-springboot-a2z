package com.ecommerce.EcomProject.repository;

import com.ecommerce.EcomProject.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {

    Category findByCategoryName(String categoryName);
}
