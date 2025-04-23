package com.iyed.equipe.entities;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Size;


@Entity
public class Equipe {
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long idEquipe;
	@NotNull
	@Size (min = 4,max = 30)
	private String nomEquipe;
	 @Min(value= 1000)
	 @Max(value = 90000000)
	private double budgetAnnuel ;
	@NotNull
	@Size (min = 4,max = 30)
	private String nomTerrain;
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@PastOrPresent
    private Date dateRealisation;
    
    @ManyToOne 
    private League league;
    
    
    
    
	public Equipe(String nomEquipe, double budgetAnnuel, String nomTerrain, Date dateRealisation) {
		super();
		this.nomEquipe = nomEquipe;
		this.budgetAnnuel = budgetAnnuel;
		this.nomTerrain = nomTerrain;
		this.dateRealisation = dateRealisation;
	}
	public Equipe() {
		super();
	}
	public Long getIdEquipe() {
		return idEquipe;
	}
	public void setIdEquipe(Long idEquipe) {
		this.idEquipe = idEquipe;
	}
	public String getNomEquipe() {
		return nomEquipe;
	}
	public void setNomEquipe(String nomEquipe) {
		this.nomEquipe = nomEquipe;
	}
	public double getBudgetAnnuel() {
		return budgetAnnuel;
	}
	public void setBudgetAnnuel(double budgetAnnuel) {
		this.budgetAnnuel = budgetAnnuel;
	}
	public String getNomTerrain() {
		return nomTerrain;
	}
	public void setNomTerrain(String nomTerrain) {
		this.nomTerrain = nomTerrain;
	}
	public Date getDateRealisation() {
		return dateRealisation;
	}
	public void setDateRealisation(Date dateRealisation) {
		this.dateRealisation = dateRealisation;
	}
	@Override
	public String toString() {
		return "Equipe [idEquipe=" + idEquipe + ", nomEquipe=" + nomEquipe + ", budgetAnnuel=" + budgetAnnuel
				+ ", nomTerrain=" + nomTerrain + ", dateRealisation=" + dateRealisation + "]";
	}
	public League getLeague() {
		return league;
	}
	public void setLeague(League league) {
		this.league = league;
	}
    
    
	
}
