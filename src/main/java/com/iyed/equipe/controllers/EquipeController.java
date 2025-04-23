package com.iyed.equipe.controllers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.iyed.equipe.entities.Equipe;
import com.iyed.equipe.service.EquipeService;

import jakarta.validation.Valid;

@Controller
public class EquipeController {
	@Autowired

	EquipeService equipeService;

	@RequestMapping("/ListeEquipes")
	public String listeEquipes(ModelMap modelMap,
			@RequestParam (name="page",defaultValue = "0") int page,
			@RequestParam (name="size", defaultValue = "4") int size) {
		Page<Equipe> eqs =equipeService.getAllEquipesParPage(page, size);
		modelMap.addAttribute("equipes", eqs);
		 modelMap.addAttribute("pages", new int[eqs.getTotalPages()]);
		modelMap.addAttribute("currentPage", page);

		return "listeEquipes";
	}

	@RequestMapping("/showCreate")
	public String showCreate(ModelMap modelMap) {
		modelMap.addAttribute("equipe", new Equipe());
		return "createEquipe";
	}

	@RequestMapping("/saveEquipe")
	public String saveEquipe(@Valid Equipe equipe,
			 BindingResult bindingResult)
	{
	if (bindingResult.hasErrors()) return "createEquipe";
	 equipeService.saveEquipe(equipe);
	return "createEquipe";
	}


	@RequestMapping("/supprimerEquipe")
	
	public String supprimerEquipe(@RequestParam("id") Long id, ModelMap modelMap,
			@RequestParam (name="page",defaultValue = "0") int page,
			@RequestParam (name="size", defaultValue = "4") int size)
 {
		
		equipeService.deleteEquipeById(id);
		Page<Equipe> eqs = equipeService.getAllEquipesParPage(page,
				size);
				modelMap.addAttribute("equipes", eqs);
				modelMap.addAttribute("pages", new int[eqs.getTotalPages()]);
				modelMap.addAttribute("currentPage", page);
				modelMap.addAttribute("size", size);

		return "listeEquipes";
	}

	
	@RequestMapping("/modifierEquipe")
	
	public String editerEquipe(@RequestParam("id") Long id, ModelMap modelMap) {
		Equipe e = equipeService.getEquipe(id);
		modelMap.addAttribute("Equipe", e);
		return "editerEquipe";
	}

	@RequestMapping("/updateEquipe")
	public String updateEquipe(@ModelAttribute("equipe") Equipe equipe, @RequestParam("date") String date,ModelMap modelMap) throws ParseException {
		// conversion de la date
		SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
		Date dateCreation = dateformat.parse(String.valueOf(date));
		equipe.setDateRealisation(dateCreation);

		equipeService.updateEquipe(equipe);
		List<Equipe> prods = equipeService.getAllEquipes();
		modelMap.addAttribute("equipes", prods);
		return "listeProduits";
	}

}
