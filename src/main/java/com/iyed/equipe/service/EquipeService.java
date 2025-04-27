package com.iyed.equipe.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.iyed.equipe.dto.EquipeDTO;
import com.iyed.equipe.entities.Equipe;
import com.iyed.equipe.entities.League;

public interface EquipeService {
	EquipeDTO saveEquipe(EquipeDTO e);
	EquipeDTO updateEquipe(EquipeDTO e);
	void deleteEquipe(Equipe e);
	 void deleteEquipeById(Long id);
	 EquipeDTO getEquipe(Long id);
	List<EquipeDTO> getAllEquipes();
	Page<Equipe> getAllEquipesParPage(int page, int size);
	
	List<Equipe> findByNomEquipe(String nom);
	List<Equipe> findByNomEquipeContains(String nom);
	List<Equipe> findByNomPrix (String nom, Double prix);
	List<Equipe> findByLeague (League league);
	List<Equipe> findByLeagueIdLeg(Long id);
	List<Equipe> findByOrderByNomEquipeAsc();
	List<Equipe> trierEquipesNomsPrix();
	List<League> getAllLeagues();
	EquipeDTO convertEntityToDto (Equipe equipe);
	Equipe convertEntityToDto (EquipeDTO equipeDto);
	

}
