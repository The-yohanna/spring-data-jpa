package com.johanna.springjpaecommerce.repository;

import com.johanna.springjpaecommerce.model.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.List;

@SpringBootTest
public class QueryMethodTest {

    @Autowired
    private ProductRepository productRepository;

    @Test
    void findByNameMethod() {

        Product product = productRepository.findByName("toolbar");

        System.out.println(product.getName());
        System.out.println(product.getDescription());
    }

    @Test
    void findByNameOrDescriptionMethod() {

        List<Product> products = productRepository
                .findByNameOrDescription("toolbar","Hammer for all wood works");

        products.forEach(product -> {
            System.out.println(product.getName());
        });
    }

    @Test
    void findDistinctByNameMethod() {

        Product product = productRepository.findDistinctByName("Plough");

        System.out.println(product.getName());
        System.out.println(product.getDescription());

    }

    @Test
    void findByPriceGreaterThanMethod() {

        List<Product> products = productRepository
                .findByPriceGreaterThan(new BigDecimal(1000));

        products.forEach(product -> {
            System.out.println(product.getName());
        });

    }

    @Test
    void findByPriceLessThanMethod() {

        List<Product> products = productRepository
                .findByPriceLessThan(new BigDecimal(1000));

        products.forEach(product -> {
            System.out.println(product.getName());
        });

    }

    @Test
    void findByNameContainingMethod() {

        List<Product> products = productRepository
                .findByNameContaining("Hammer");

        products.forEach(product -> {
            System.out.println(product.getName());
        });

    }

    @Test
    void findByPriceBetweenMethod() {

        List<Product> products = productRepository
                .findByPriceBetween(new BigDecimal(100), new BigDecimal(10000));

        products.forEach(product -> {
            System.out.println(product.getName());
        });

    }

    @Test
    void findByInMethod() {

        List<Product> products = productRepository
                .findByNameIn(List.of("Hammer", "toolbar"));

        products.forEach(product -> {
            System.out.println(product.getSku());
            System.out.println(product.getDescription());
        });

    }

    @Test
    void findFirst2ByOrderByNameAscMethod() {

        List<Product> products = productRepository
                .findFirst2ByOrderByNameAsc();

        products.forEach(product -> {
            System.out.println(product.getName());
            System.out.println(product.getDescription());
        });

    }

    @Test
    void findTop2ByOrderByPriceDescMethod() {

        List<Product> products = productRepository
                .findTop2ByOrderByPriceDesc();

        products.forEach(product -> {
            System.out.println(product.getName());
            System.out.println(product.getDescription());
        });

    }
}
