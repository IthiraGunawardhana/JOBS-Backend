package com.example.backendb.repository;

import com.example.backendb.entity.Product;
import com.example.backendb.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
    User findByUsername(String username);
//    User findByemail(String email);
}
