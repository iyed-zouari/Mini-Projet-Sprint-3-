package com.iyed.equipe.restcontrollers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.iyed.equipe.dto.EquipeDTO;
import com.iyed.equipe.entities.Equipe;
import com.iyed.equipe.service.EquipeService;

@RestController
@RequestMapping("custom-api")
@CrossOrigin
public class EquipeRESTController {
	@Autowired
	EquipeService equipeService;

	@RequestMapping(method = RequestMethod.GET)
	public List<EquipeDTO> getAllEquipes() {
		return equipeService.getAllEquipes();
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public EquipeDTO getEquipeById(@PathVariable("id") Long id) {
		return equipeService.getEquipe(id);
	}

	@RequestMapping(method = RequestMethod.POST)
	public EquipeDTO createEquipe(@RequestBody EquipeDTO equipeDTO) {
		return equipeService.saveEquipe(equipeDTO);
	}
	
	@RequestMapping(method = RequestMethod.PUT)
	public EquipeDTO updateEquipe(@RequestBody EquipeDTO equipeDTO) {
		return equipeService.updateEquipe(equipeDTO);
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
