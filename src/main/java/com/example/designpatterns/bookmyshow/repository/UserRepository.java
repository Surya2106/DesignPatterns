package com.example.designpatterns.bookmyshow.repository;

import com.example.designpatterns.bookmyshow.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
