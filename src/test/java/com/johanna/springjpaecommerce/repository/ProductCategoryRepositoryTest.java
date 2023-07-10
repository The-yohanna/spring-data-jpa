package com.johanna.springjpaecommerce.repository;

import com.johanna.springjpaecommerce.model.Product;
import com.johanna.springjpaecommerce.model.ProductCategory;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ProductCategoryRepositoryTest {

    @Autowired
    private ProductCategoryRepository productCategoryRepository;

    @Test
    void saveMethod() {

        ProductCategory productCategory = new ProductCategory();
        productCategory.setCategoryName("farm tools");
        productCategory.setCategoryDescription("Contains a host of tools for farm work");

        Product product = new Product();
        product.setName("spanner");
        product.setDescription("Tool for opening and tightening bolts and nuts");
        product.setSku("FT001");
        product.setPrice(new BigDecimal(150));
        product.setImageUrl("spanner.png");
        product.setActive(true);
        product.setCategory(productCategory);
        productCategory.getProducts().add(product);

        Product product2 = new Product();
        product2.setName("screw driver");
        product2.setDescription("Tool for opening and fixing screws");
        product2.setSku("FT002");
        product2.setPrice(new BigDecimal(450));
        product2.setImageUrl("shovel.png");
        product2.setActive(true);
        product2.setCategory(productCategory);
        productCategory.getProducts().add(product2);

        productCategoryRepository.save(productCategory);

    }

    @Test
    @Transactional
    void fetchMethod() {

        ProductCategory category = productCategoryRepository.findById(1L).get();
        System.out.println(category.getProducts());

    }

}