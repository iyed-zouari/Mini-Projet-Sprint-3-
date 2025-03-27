package com.iyed.equipe.restcontrollers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.iyed.equipe.entities.Equipe;
import com.iyed.equipe.service.EquipeService;

@RestController
@RequestMapping("/custom-api")
@CrossOrigin
public class EquipeRESTController {
	@Autowired
	EquipeService equipeService;

	@RequestMapping(method = RequestMethod.GET)
	public List<Equipe> getAllEquipes() {
		return equipeService.getAllEquipes();
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public Equipe getEquipeById(@PathVariable("id") Long id) {
		return equipeService.getEquipe(id);
	}

	@RequestMapping(method = RequestMethod.POST)
	public Equipe createProduit(@RequestBody Equipe equipe) {
		return equipeService.saveEquipe(equipe);
	}
	
	@RequestMapping(method = RequestMethod.PUT)
	public Equipe updateEquipe(@RequestBody Equipe equipe) {
		return equipeService.updateEquipe(equipe);
	}
	
	@RequestMapping(value="/{id}",method = RequestMethod.DELETE)
	public void deleteEquipe(@PathVariable("id") Long id)
	{
	equipeService.deleteEquipeById(id);
	}
	
	@RequestMapping(value="/equipesLeg/{idLeg}",method = RequestMethod.GET)
	public List<Equipe> getEquipesByCatId(@PathVariable("idLeg") Long idLeg) {
		return equipeService.findByLeagueIdLeg(idLeg);
	}
	

}
