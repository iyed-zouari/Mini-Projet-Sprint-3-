package com.iyed.equipe.entities;

import java.util.Date;



import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;


@Entity
public class Equipe {
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long idEquipe;
	private String nomEquipe;
	private double budgetAnnuel ;
	private String nomTerrain;
    private Date dateRealisation;
    
    
    
    
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
    
    
	
}
