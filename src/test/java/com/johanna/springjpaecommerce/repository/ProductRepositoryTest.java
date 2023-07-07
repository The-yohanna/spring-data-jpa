package com.johanna.springjpaecommerce.repository;

import com.johanna.springjpaecommerce.model.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ProductRepositoryTest {

    @Autowired
    private ProductRepository productRepository;

    @Test
    void saveMethod() {

        Product product = new Product();
        product.setName("machete");
        product.setDescription("Tool for cutting");
        product.setSku("FT001");
        product.setPrice(new BigDecimal(1250));
        product.setImageUrl("machete.png");
        product.setActive(true);

        Product savedProduct = productRepository.save(product);

        System.out.println(savedProduct.getId());
        System.out.println(savedProduct.toString());

    }

    @Test
    void updateMethod() {

        Long id = 1L;
        Product product = productRepository.findById(id).get();

        product.setDescription("A set of tools for farm handiwork");

        productRepository.save(product);

    }

    @Test
    void saveAllMethod() {

        Product product = new Product();
        product.setName("spanner");
        product.setDescription("Tool for opening and tightening bolts and nuts");
        product.setSku("FT011");
        product.setPrice(new BigDecimal(150));
        product.setImageUrl("spanner.png");
        product.setActive(true);

        Product product2 = new Product();
        product2.setName("screw driver");
        product2.setDescription("Tool for opening and fixing screws");
        product2.setSku("FT012");
        product2.setPrice(new BigDecimal(450));
        product2.setImageUrl("shovel.png");
        product2.setActive(true);

        Product product3 = new Product();
        product3.setName("hammer");
        product3.setDescription("Tool for driving nails in and out");
        product3.setSku("FT013");
        product3.setPrice(new BigDecimal(850));
        product3.setImageUrl("hammer.png");
        product3.setActive(true);

        Product product4 = new Product();
        product4.setName("saw");
        product4.setDescription("Tool for sawing wood");
        product4.setSku("FT014");
        product4.setPrice(new BigDecimal(1050));
        product4.setImageUrl("saw.png");
        product4.setActive(true);

        Product product5 = new Product();
        product5.setName("sickle");
        product5.setDescription("Tool for trimming hedges");
        product5.setSku("FT015");
        product5.setPrice(new BigDecimal(950));
        product5.setImageUrl("sickle.png");
        product5.setActive(true);

        productRepository.saveAll(List.of(product,product2,product3,product4,product5));

    }

    @Test
    void findAllMethod() {

        List<Product> products = productRepository.findAll();

        products.forEach(product -> {
            System.out.println(product.getName());
        });

    }

    @Test
    void deleteByIdMethod() {

        Long id = 1L;
        productRepository.deleteById(id);

    }

    @Test
    void deleteAllMethod() {

        productRepository.deleteAll();

        /*Product product1 = productRepository.findById(3L).get();
        Product product2 = productRepository.findById(4L).get();
        productRepository.deleteAll(List.of(product1, product2));*/

    }

    @Test
    void countMethod() {

        Long count = productRepository.count();
        System.out.println(count);

    }

    @Test
    void existsIdByMethod() {

        Long id = 7L;
        boolean result = productRepository.existsById(id);
        System.out.println(result);

    }

}