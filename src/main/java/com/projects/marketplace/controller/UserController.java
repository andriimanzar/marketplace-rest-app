package com.projects.marketplace.controller;

import com.projects.marketplace.entity.Product;
import com.projects.marketplace.entity.User;
import com.projects.marketplace.exception.EntityNotFoundException;
import com.projects.marketplace.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService){
        this.userService = userService;
    }

    @GetMapping
    public List<User> getAllUsers(){
        return userService.getAllUsers();
    }

    @GetMapping("/{id}")
    public User getUserById(@PathVariable Long id){
        User user = userService.findUserById(id);
        if(user == null) throw new EntityNotFoundException("Cannot find user with id = " + id);
        return user;
    }

    @GetMapping("/{id}/products")
    public List<Product> userProductsList(@PathVariable Long id){
        return userService.getAllUserProducts(id);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public User createUser(@RequestBody User user){
        return userService.saveUser(user);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteUser(@PathVariable Long id){
        userService.deleteUser(id);
    }

    @GetMapping("/{userId}/buy/{productId}")
    public String buyProduct(@PathVariable Long userId, @PathVariable Long productId){
         userService.buyProduct(userId,productId);
         return "Your purchase was successfully";
    }
}
