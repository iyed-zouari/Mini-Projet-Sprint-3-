package com.iyed.equipe;

import java.util.Date;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.iyed.equipe.entities.Equipe;
import com.iyed.equipe.entities.Role;
import com.iyed.equipe.entities.User;
import com.iyed.equipe.service.EquipeService;
import com.iyed.equipe.service.UserService;

import jakarta.annotation.PostConstruct;

@SpringBootApplication
public class EquipeApplication implements CommandLineRunner {
	@Autowired
	private RepositoryRestConfiguration repositoryRestConfiguration;
	@Autowired
	PasswordEncoder passwordEncoder;
	
	@Autowired
	UserService userService;
	public static void main(String[] args) {
		SpringApplication.run(EquipeApplication.class, args);
	}
	
	/*@PostConstruct
	void init_users() {
	//ajouter les rôles
	userService.addRole(new Role(null,"ADMIN"));
	userService.addRole(new Role(null,"AGENT"));
	userService.addRole(new Role(null,"USER"));
	//ajouter les users
	userService.saveUser(new User(null,"admin","123",true,null));
	userService.saveUser(new User(null,"iyed","123",true,null));
	userService.saveUser(new User(null,"user1","123",true,null));
	//ajouter les rôles aux users
	userService.addRoleToUser("admin", "ADMIN");
	userService.addRoleToUser("iyed", "USER");
	userService.addRoleToUser("iyed", "AGENT");
	userService.addRoleToUser("user1", "USER");
	}
*/
	@Override
	public void run(String... args) throws Exception {
		

		
		
		 System.out.println("Password Encoded BCRYPT :******************** ");
		 System.out.println(passwordEncoder.encode("123"));
		
		
		/*Date dateRealisation = new Date(); 
		Date dateSpecifique = new Date(124, 4, 15); 
		equipeService.saveEquipe(new Equipe("PSG",5000000.0,"Parc des Princes",   dateRealisation ));
		equipeService.saveEquipe(new Equipe("Liverpool", 4500000.0, "Anfield",new Date()));
		equipeService.saveEquipe(new Equipe("Bayern Munich", 4800000.0, "Allianz Arena", new Date()));*/
		//repositoryRestConfiguration.exposeIdsFor(Equipe.class);
	}
	@Bean
	public ModelMapper modelMapper()
	{
	return new ModelMapper();
	}

}
