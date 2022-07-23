package com.projects.marketplace.service;

import com.projects.marketplace.entity.Product;
import com.projects.marketplace.entity.User;
import com.projects.marketplace.exception.EntityNotFoundException;
import com.projects.marketplace.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class ProductServiceImpl implements ProductService{

    private final ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository){
        this.productRepository = productRepository;
    }

    @Override
    public Product saveProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    public void deleteProduct(Long productId) {
        productRepository.deleteById(productId);
    }

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public Product findProductById(Long id) {
        return productRepository.findById(id).orElseThrow(() ->
                new EntityNotFoundException("Cannot find product with id = " + id ));
    }

    @Override
    public List<User> allUsersThatBoughtProduct(Long productId) {
        Product product = productRepository.findById(productId).orElseThrow(() ->
                new EntityNotFoundException("Cannot find product with id = " + productId));;
        return product.getUsers();
    }
}
