package com.iyed.equipe.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.modelmapper.spi.MatchingStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.iyed.equipe.dto.EquipeDTO;
import com.iyed.equipe.entities.Equipe;
import com.iyed.equipe.entities.League;
import com.iyed.equipe.repos.EquipeRepository;
import com.iyed.equipe.repos.LeagueRepositort;

@Service
public class EquipeServiceImpl implements EquipeService {
	@Autowired
	EquipeRepository equipeRepository;
	@Autowired
	LeagueRepositort leagueRepository;
	@Autowired
	ModelMapper modelMapper;
	@Override
	public EquipeDTO saveEquipe(EquipeDTO e) {
		// TODO Auto-generated method stub
		return convertEntityToDto(equipeRepository.save(convertEntityToDto(e)));
	}

	@Override
	public EquipeDTO updateEquipe(EquipeDTO e) {
		// TODO Auto-generated method stub
		return convertEntityToDto(equipeRepository.save(convertEntityToDto(e)));
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
	public EquipeDTO getEquipe(Long id) {
		return convertEntityToDto(equipeRepository.findById(id).get());
	}

	@Override
	public List<EquipeDTO> getAllEquipes() {
		// TODO Auto-generated method stub
		return equipeRepository.findAll().stream()
				.map(this::convertEntityToDto)
				.collect(Collectors.toList());

	}

	@Override
	public Page<Equipe> getAllEquipesParPage(int page, int size) {
		// TODO Auto-generated method stub
		return equipeRepository.findAll(PageRequest.of(page, size));
	}
	
	
	@Override
	public List<Equipe> findByNomEquipe(String nom) {
	return equipeRepository.findByNomEquipe(nom);
	}
	@Override
	public List<Equipe> findByNomEquipeContains(String nom) {
	return equipeRepository.findByNomEquipeContains(nom);
	}
	@Override
	public List<Equipe> findByNomPrix(String nom, Double prix) {
	return equipeRepository.findByNomPrix(nom, prix);
	}
	@Override
	public List<Equipe> findByLeague(League league) {
	return equipeRepository.findByLeague(league);
	}
	@Override
	public List<Equipe> findByLeagueIdLeg(Long id) {
	return equipeRepository.findByLeagueIdLeg(id);
	}
	@Override
	public List<Equipe> findByOrderByNomEquipeAsc() {
	return equipeRepository.findByOrderByNomEquipeAsc();
	}
	@Override
	public List<Equipe> trierEquipesNomsPrix() {
	return equipeRepository.trierEquipesNomsPrix();
	}

	@Override
	public List<League> getAllLeagues() {
		
		return leagueRepository.findAll();
	}

	@Override
	public EquipeDTO convertEntityToDto(Equipe equipe) {
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
		EquipeDTO equipeDTO = modelMapper.map(equipe, EquipeDTO.class);
		 return equipeDTO; 
		
		/*EquipeDTO equipeDTO = new EquipeDTO();
		equipeDTO.setIdEquipe(equipe.getIdEquipe());
		equipeDTO.setNomEquipe(equipe.getNomEquipe());
		equipeDTO.setNomTerrain(equipe.getNomTerrain());
		equipeDTO.setBudgetAnnuel(equipe.getBudgetAnnuel());
		equipeDTO.setDateRealisation(equipe.getDateRealisation());
		equipeDTO.setLeague(equipe.getLeague()); 
		 return equipeDTO; */
		 
		 /*return EquipeDTO.builder()
		.IdEquipe(produit.getIdEquipeuit())
		.nomEquiep(produit.getNomEquipe())
		.BudgetAnnuel(produit.getBudgetAnnuel())
		.dateRealisation(p.getDateRealisation())
		.league(produit.getLeague())
		.build();*/

	}

	@Override
	public Equipe convertEntityToDto(EquipeDTO equipeDTO) {
		Equipe equipe = new Equipe();
		equipe = modelMapper.map(equipeDTO, Equipe.class);
		return equipe;
		/*Equipe equipe = new Equipe();
		equipe.setIdEquipe(equipeDto.getIdEquipe());
		equipe.setNomEquipe(equipeDto.getNomEquipe());
		equipe.setNomTerrain(equipeDto.getNomTerrain());
		equipe.setBudgetAnnuel(equipeDto.getBudgetAnnuel());
		equipe.setDateRealisation(equipeDto.getDateRealisation());
		equipe.setLeague(equipeDto.getLeague()); 
		 return equipe; */
		
	}


	
	
	

}
