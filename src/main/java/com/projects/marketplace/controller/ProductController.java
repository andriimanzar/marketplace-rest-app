package com.projects.marketplace.controller;

import com.projects.marketplace.entity.Product;
import com.projects.marketplace.entity.User;
import com.projects.marketplace.exception.EntityNotFoundException;
import com.projects.marketplace.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService){
        this.productService = productService;
    }

    @GetMapping
    public List<Product> getAllProducts(){
        return productService.getAllProducts();
    }

    @GetMapping("/{id}")
    public Product getProductById(@PathVariable Long id){
        Product product = productService.findProductById(id);
        if(product == null) throw new EntityNotFoundException("Cannot find product with id = " + id);
        return product;
    }

    @GetMapping("/{id}/users")
    public List<User> getAllUsersThatBoughtProduct(@PathVariable Long id){
        return productService.allUsersThatBoughtProduct(id);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public Product saveProduct(@RequestBody Product product){
        return productService.saveProduct(product);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteProduct(@PathVariable Long id){
        productService.deleteProduct(id);

    }

}
