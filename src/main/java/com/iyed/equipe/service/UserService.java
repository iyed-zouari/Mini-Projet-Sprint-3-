package com.iyed.equipe.service;

import com.iyed.equipe.entities.Role;
import com.iyed.equipe.entities.User;

public interface UserService {
	
	
	
	void deleteAllusers();
	void deleteAllRoles();
	User saveUser(User user);
	User findUserByUsername(String username);
	Role addRole(Role role);
	User addRoleToUser(String username, String rolename);
}
