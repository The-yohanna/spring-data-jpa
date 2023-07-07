package com.johanna.springjpaecommerce.repository;

import com.johanna.springjpaecommerce.model.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class QueryAnnotationTest {

    @Autowired
    private ProductRepository productRepository;

    @Test
    void findByJPQLQueryIndex() {

        Product product = productRepository
                .findByJPQLQueryIndex("toolbar",
                        "Tool bar for farm machinery maintenance");

        System.out.println(product.getName());

    }

    @Test
    void findByJPQLQueryNamed() {

        Product product = productRepository
                .findByJPQLQueryNamed("toolbar",
                        "Tool bar for farm machinery maintenance");

        System.out.println(product.getName());

    }

    @Test
    void findBySQLQueryIndex() {

        Product product = productRepository
                .findBySQLQueryIndex("toolbar",
                        "Tool bar for farm machinery maintenance");

        System.out.println(product.getName());

    }

    @Test
    void findBySQLQueryNamed() {

        Product product = productRepository
                .findBySQLQueryNamed("toolbar",
                        "Tool bar for farm machinery maintenance");

        System.out.println(product.getName());

    }
}
