package com.iyed.equipe.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.iyed.equipe.entities.Equipe;

public interface EquipeService {
	Equipe saveEquipe(Equipe e);
	Equipe updateEquipe(Equipe e);
	void deleteEquipe(Equipe e);
	 void deleteEquipeById(Long id);
	 Equipe getEquipe(Long id);
	List<Equipe> getAllEquipes();
	Page<Equipe> getAllEquipesParPage(int page, int size);

}
