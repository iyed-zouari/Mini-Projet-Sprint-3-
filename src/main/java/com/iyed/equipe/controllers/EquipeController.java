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
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.iyed.equipe.dto.EquipeDTO;
import com.iyed.equipe.entities.Equipe;
import com.iyed.equipe.entities.League;
import com.iyed.equipe.service.EquipeService;

import jakarta.validation.Valid;

@Controller
public class EquipeController {
	
	@Autowired
	EquipeService equipeService;

	@GetMapping("/accessDenied")
	public String error()
	{
	return "accessDenied";
	}
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
		List<League> legs=equipeService.getAllLeagues();
		modelMap.addAttribute("equipe", new Equipe());
		modelMap.addAttribute("mode", "new");
		modelMap.addAttribute("league",legs);

		return "formEquipe";
	}

	@RequestMapping("/saveEquipe")
	public String saveEquipe(@Valid EquipeDTO equipe,
			 BindingResult bindingResult,@RequestParam (name="page",defaultValue = "0") int page,
			 @RequestParam (name="size",defaultValue = "2") int size)
	{
		int currentPage;
		boolean isNew = false;
	if (bindingResult.hasErrors()) return "formEquipe";
	if (equipe.getIdEquipe()==null) //ajout
		isNew=true;
	 equipeService.saveEquipe(equipe);
	 if (isNew) //ajout
	 {
	 Page<Equipe> equipes = equipeService.getAllEquipesParPage(page, size);
	 currentPage = equipes.getTotalPages()-1;
	 }
	 else //modif
		 currentPage=page;
	//return "formEquipe";
	 return ("redirect:/ListeEquipes?page="+currentPage+"&size="+size);
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
	public String editerEquipe(@RequestParam("id") Long id, ModelMap modelMap,@RequestParam (name="page",defaultValue = "0") int page,
			@RequestParam (name="size", defaultValue = "4") int size) {
		EquipeDTO e = equipeService.getEquipe(id);
		List<League> legs=equipeService.getAllLeagues();
		modelMap.addAttribute("equipe", e);
		modelMap.addAttribute("mode", "edit");
		modelMap.addAttribute("league",legs);
		modelMap.addAttribute("page", page);
		modelMap.addAttribute("size", size);
		return "formEquipe";
	}

	@RequestMapping("/updateEquipe")
	public String updateEquipe(@ModelAttribute("equipe") EquipeDTO equipe, @RequestParam("date") String date,ModelMap modelMap) throws ParseException {
		// conversion de la date
		SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
		Date dateCreation = dateformat.parse(String.valueOf(date));
		equipe.setDateRealisation(dateCreation);

		equipeService.updateEquipe(equipe);
		List<EquipeDTO> prods = equipeService.getAllEquipes();
		modelMap.addAttribute("equipes", prods);
		return "listeProduits";
	}

}
