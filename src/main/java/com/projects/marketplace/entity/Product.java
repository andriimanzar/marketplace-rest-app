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
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "product_name")
    private String productName;

    @Column(name = "price")
    private BigDecimal price;

    @Setter(AccessLevel.PRIVATE)
    @JsonIgnore
    @ManyToMany(cascade = {CascadeType.PERSIST,CascadeType.REFRESH})
    @JoinTable(name = "users_products", joinColumns = @JoinColumn(name ="product_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id"))
    private List<User> users = new ArrayList<>();

}
