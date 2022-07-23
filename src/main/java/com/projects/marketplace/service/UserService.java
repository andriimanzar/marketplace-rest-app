package com.projects.marketplace.service;

import com.projects.marketplace.entity.Product;
import com.projects.marketplace.entity.User;

import java.util.List;

public interface UserService {

    List<User> getAllUsers();

    void buyProduct(Long userId, Long productId);

    List<Product> getAllUserProducts(Long userId);

    User saveUser(User user);

    void deleteUser(Long userId);

}
