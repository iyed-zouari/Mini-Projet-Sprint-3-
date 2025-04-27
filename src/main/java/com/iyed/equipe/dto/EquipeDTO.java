package com.iyed.equipe.dto;
import com.iyed.equipe.entities.League;

import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;



@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EquipeDTO {
	private Long idEquipe;
	private String nomEquipe;
	private double budgetAnnuel ;
	private String nomTerrain;
    private Date dateRealisation;
    private League league;
    private String nomLeg;
    
}
