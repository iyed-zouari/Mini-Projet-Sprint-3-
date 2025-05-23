package com.iyed.equipe;

import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;

import com.iyed.equipe.entities.Equipe;
import com.iyed.equipe.entities.League;
import com.iyed.equipe.repos.EquipeRepository;
import com.iyed.equipe.service.EquipeService;

@SpringBootTest
class EquipeApplicationTests {

	@Autowired
	private EquipeRepository equipeRepository;
	@Autowired
	private EquipeService equipeService;

	@Test
	public void testCreateEquipe() {
		Equipe equipe = new Equipe("real madrid", 310000.900, "Santiago Bernabéu", new Date());
		equipeRepository.save(equipe);
	}

	@Test
	public void testFindEquipes() {
		Equipe p = equipeRepository.findById(1L).get();
		System.out.println(p);
	}

	@Test
	public void testUpdateEquipe() {
		Equipe e = equipeRepository.findById(1L).get();
		e.setBudgetAnnuel(1000.0);
		equipeRepository.save(e);
	}

	@Test
	public void testDeleteEquipe() {
		equipeRepository.deleteById(1L);
		;
	}

	@Test
	public void testListerTousEquipes() {
		List<Equipe> equipes = equipeRepository.findAll();
		for (Equipe e : equipes) {
			System.out.println(e);
		}

	}

	@Test
	public void testFindByNomEquipeContains() {
		Page<Equipe> equipe = equipeService.getAllEquipesParPage(0, 1);
		System.out.println(equipe.getSize());
		System.out.println(equipe.getTotalElements());
		System.out.println(equipe.getTotalPages());

		for (Equipe e : equipe.getContent()) {
			System.out.println(e);
		}
	}

	@Test
	public void testFindEquipeByNom() {
		List<Equipe> equipes = equipeRepository.findByNomEquipe("real madrid");
		for (Equipe e : equipes)
			System.out.println(e);
	}

	@Test
	public void testFindEquipeByNomContains() {
		List<Equipe> equipes = equipeRepository.findByNomEquipeContains("real");
		for (Equipe e : equipes)
			System.out.println(e);
	}

	@Test
	public void testfindByNomPrix() {
		List<Equipe> equipes = equipeRepository.findByNomPrix("real madrid", 345.0);
		for (Equipe e : equipes) {
			System.out.println(e);
		}
	}

	@Test
	public void testfindByLeague() {
		League leg = new League();
		leg.setIdLeg(1L);

		List<Equipe> equipes = equipeRepository.findByLeague(leg);
		for (Equipe e : equipes) {
			System.out.println(e);
		}
	}

	@Test
	public void findByCategorieIdCat() {
		List<Equipe> equipes = equipeRepository.findByLeagueIdLeg(1L);
		for (Equipe e : equipes) {
			System.out.println(e);
		}
	}

	@Test
	public void testfindByOrderByNomEquipeAsc() {
		List<Equipe> equipes = equipeRepository.findByOrderByNomEquipeAsc();
		for (Equipe e : equipes) {
			System.out.println(e);
		}
	}
	
	@Test
	public void testTrierEquipesNomsPrix()
	{
	List<Equipe> equipes = equipeRepository.trierEquipesNomsPrix();
	for (Equipe e : equipes)
	{
	System.out.println(e);
	}
	}
}
