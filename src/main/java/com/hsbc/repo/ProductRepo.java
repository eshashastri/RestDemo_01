package com.hsbc.repo;

import com.hsbc.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepo extends JpaRepository<Product, Integer> {
    List<Product> findByName(String name);
    @Query(value = "SELECT prod FROM Product prod WHERE prod.name LIKE %:name%")
    List<Product> findByPartialName(String name);
}
