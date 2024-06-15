package com.example.navigator.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.navigator.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {
}
