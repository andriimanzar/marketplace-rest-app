package com.projects.marketplace.repository;

import com.projects.marketplace.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
}
