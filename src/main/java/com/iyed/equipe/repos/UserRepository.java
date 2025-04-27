package com.iyed.equipe.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.iyed.equipe.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {
User findByUsername (String username);
}

