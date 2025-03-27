package com.iyed.equipe.entities;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class League {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idLeg;
	private String nomLeg;
	private String descriptionLeg;
	
	
	@OneToMany (mappedBy = "league")
	@JsonIgnore
	private List<Equipe> equipes;
	
	
	
	public League() {
		super();
	}
	public Long getIdLeg() {
		return idLeg;
	}
	public void setIdLeg(Long idLeg) {
		this.idLeg = idLeg;
	}
	public String getNomLeg() {
		return nomLeg;
	}
	public void setNomLeg(String nomLeg) {
		this.nomLeg = nomLeg;
	}
	public String getDescriptionLeg() {
		return descriptionLeg;
	}
	public void setDescriptionLeg(String descriptionLeg) {
		this.descriptionLeg = descriptionLeg;
	}
	public List<Equipe> getEquipes() {
		return equipes;
	}
	public void setEquipes(List<Equipe> equipes) {
		this.equipes = equipes;
	}

	
	
	
}
