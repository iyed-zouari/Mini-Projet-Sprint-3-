package com.iyed.equipe.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.iyed.equipe.entities.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {
		Role findByRole(String role);
}
