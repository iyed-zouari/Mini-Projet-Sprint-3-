package com.iyed.equipe.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.iyed.equipe.entities.Equipe;
import com.iyed.equipe.repos.EquipeRepository;


@Service
public class EquipeServiceImpl implements EquipeService  {
	@Autowired
	EquipeRepository equipeRepository;

	@Override
	public Equipe saveEquipe(Equipe e) {
		// TODO Auto-generated method stub
		return equipeRepository.save(e);
	}

	@Override
	public Equipe updateEquipe(Equipe e) {
		// TODO Auto-generated method stub
		return equipeRepository.save(e);
	}

	@Override
	public void deleteEquipe(Equipe e) {
		equipeRepository.delete(e);
		
	}

	@Override
	public void deleteEquipeById(Long id) {
		equipeRepository.deleteById(id);		
	}

	@Override
	public Equipe getEquipe(Long id) {
		return equipeRepository.findById(id).get();
	}

	@Override
	public List<Equipe> getAllEquipes() {
		// TODO Auto-generated method stub
		return equipeRepository.findAll();
	}

	@Override
	public Page<Equipe> getAllEquipesParPage(int page, int size) {
		// TODO Auto-generated method stub
		return equipeRepository.findAll(PageRequest.of(page, size));	}

}
