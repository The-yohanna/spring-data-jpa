package com.johanna.springjpaecommerce.repository;

import com.johanna.springjpaecommerce.model.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductCategoryRepository extends JpaRepository<ProductCategory, Long> {

}
