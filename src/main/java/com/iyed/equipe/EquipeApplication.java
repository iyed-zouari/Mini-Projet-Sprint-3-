package com.iyed.equipe;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

import com.iyed.equipe.entities.Equipe;
import com.iyed.equipe.service.EquipeService;

@SpringBootApplication
public class EquipeApplication implements CommandLineRunner {
	@Autowired
	private RepositoryRestConfiguration repositoryRestConfiguration;
	

	public static void main(String[] args) {
		SpringApplication.run(EquipeApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		/*Date dateRealisation = new Date(); 
		Date dateSpecifique = new Date(124, 4, 15); 
		equipeService.saveEquipe(new Equipe("PSG",5000000.0,"Parc des Princes",   dateRealisation ));
		equipeService.saveEquipe(new Equipe("Liverpool", 4500000.0, "Anfield",new Date()));
		equipeService.saveEquipe(new Equipe("Bayern Munich", 4800000.0, "Allianz Arena", new Date()));*/
		repositoryRestConfiguration.exposeIdsFor(Equipe.class);
	}

}
