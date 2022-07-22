package com.projects.marketplace.entity;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

@NoArgsConstructor
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
    @ManyToMany(mappedBy = "users")
    private Set<Product> products = new HashSet<>();

    public void addProduct(Product product){
        products.add(product);
        product.getUsers().add(this);
    }

    public void removeProduct(Product product){
        products.remove(product);
        product.getUsers().remove(this);
    }
}
