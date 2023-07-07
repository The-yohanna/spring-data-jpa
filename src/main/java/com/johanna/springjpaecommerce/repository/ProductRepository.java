package com.johanna.springjpaecommerce.repository;

import com.johanna.springjpaecommerce.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.math.BigDecimal;
import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {

    Product findByName(String name);

    List<Product> findByNameOrDescription(String name, String description);

    Product findDistinctByName(String name);

    List<Product> findByPriceGreaterThan(BigDecimal price);

    List<Product> findByPriceLessThan(BigDecimal price);

    //Could also use findBy...Like
    List<Product> findByNameContaining(String name);

    List<Product> findByPriceBetween(BigDecimal startPrice, BigDecimal endPrice);

    List<Product> findByNameIn(List<String> names);

    List<Product> findFirst2ByOrderByNameAsc();

    List<Product> findTop2ByOrderByPriceDesc();

    @Query("select p from Product p where p.name = ?1 or p.description = ?2")
    Product findByJPQLQueryIndex(String name, String description);

    @Query("select p from Product p where p.name = :name or p.description = :description")
    Product findByJPQLQueryNamed(@Param("name") String name,
                                 @Param("description") String description);

    @Query(
            value = "select * from products p where p.name = ?1 or p.description = ?2",
            nativeQuery = true
    )
    Product findBySQLQueryIndex(String name, String description);

    @Query(
            value = "select * from products p where p.name = :name or p.description = :description",
            nativeQuery = true
    )
    Product findBySQLQueryNamed(@Param("name") String name,
                                @Param("description") String description);

    // Named JPQL query
    Product findByPrice(@Param("price") BigDecimal price);

    List<Product> findAllOrderByNameDesc();

    // Named native SQL query
    @Query(nativeQuery = true)
    Product findByDescription(@Param("description") String description);

    List<Product> findAllOrderByNameASC();

}
