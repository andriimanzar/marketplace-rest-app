package com.projects.marketplace.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;


@Data
@EqualsAndHashCode(of = "id")
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "money_amount")
    private BigDecimal moneyAmount;

    @Setter(AccessLevel.PRIVATE)
    @JsonIgnore
    @ManyToMany(mappedBy = "users")
    private List<Product> products = new ArrayList<>();

    public void addProduct(Product product){
        products.add(product);
        product.getUsers().add(this);
    }

    public void removeProduct(Product product){
        products.remove(product);
        product.getUsers().remove(this);
    }
}
