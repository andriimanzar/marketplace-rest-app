package com.projects.marketplace.repository;

import com.projects.marketplace.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product,Long> {
}
