package com.iyed.equipe.entities;

import org.springframework.data.rest.core.config.Projection;

@Projection(name = "nomProd",types= {Equipe.class})
public interface EquipeProjection {
	public String getNomEquipe();
}
