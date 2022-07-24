package com.projects.marketplace.service;

import com.projects.marketplace.entity.Product;
import com.projects.marketplace.entity.User;
import com.projects.marketplace.exception.EntityNotFoundException;
import com.projects.marketplace.exception.NotEnoughMoneyException;
import com.projects.marketplace.repository.ProductRepository;
import com.projects.marketplace.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final ProductRepository productRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, ProductRepository productRepository){
        this.userRepository = userRepository;
        this.productRepository = productRepository;
    }

    @Override
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User findUserById(Long id) {
        return userRepository.findById(id).orElseThrow(() ->
                new EntityNotFoundException("Cannot find user with id = " + id ));
    }

    @Override
    public void deleteUser(Long userId) {
        userRepository.deleteById(userId);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public void buyProduct(Long userId, Long productId) {
        User user = userRepository.findById(userId).orElseThrow(() ->
                new EntityNotFoundException("Cannot find user with id = " + userId ));
        Product product = productRepository.findById(productId).orElseThrow(() ->
                new EntityNotFoundException("Cannot find product with id = " + productId ));
        if (user.getMoneyAmount().compareTo(product.getPrice()) < 0)
           throw new NotEnoughMoneyException("Not enough money!");
        user.setMoneyAmount(user.getMoneyAmount().subtract(product.getPrice()));
        user.addProduct(product);
        userRepository.save(user);

    }

    @Override
    public List<Product> getAllUserProducts(Long userId) {
        User user = userRepository.findById(userId).orElseThrow(() ->
                new EntityNotFoundException("Cannot find user with id = " + userId ));
        return user.getProducts();
    }
}
