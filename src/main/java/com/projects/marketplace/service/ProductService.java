package com.projects.marketplace.service;

import com.projects.marketplace.entity.Product;
import com.projects.marketplace.entity.User;

import java.util.List;

public interface ProductService {

    List<Product> getAllProducts();

    List<User> allUsersThatBoughtProduct(Long productId);

    Product saveProduct(Product product);

    void deleteProduct(Long productId);
}
