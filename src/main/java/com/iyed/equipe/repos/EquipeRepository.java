package com.iyed.equipe.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.iyed.equipe.entities.Equipe;
import com.iyed.equipe.entities.League;






@RepositoryRestResource(path = "rest")
public interface EquipeRepository extends JpaRepository<Equipe, Long> {
	
	List<Equipe> findByNomEquipe(String nom);
	List<Equipe> findByNomEquipeContains(String nom);
	
	List<Equipe> findByLeagueIdLeg(Long id);
	
	List<Equipe> findByOrderByNomEquipeAsc();

	/*@Query("select e from Equipe e where e.nomEquipe like %?1 and e.budgetAnnuel > ?2")
	List<Equipe> findByNomPrix (String nom, Double prix);*/
	
	@Query("select e from Equipe e where e.nomEquipe like %:nom and e.budgetAnnuel > :prix")
	List<Equipe> findByNomPrix (@Param("nom") String nom,@Param("prix") Double prix);

	@Query("select e from Equipe e where e.league = ?1")
	List<Equipe> findByLeague (League league);
	
	@Query("select e from Equipe e order by e.nomEquipe ASC, e.budgetAnnuel DESC")
	List<Equipe> trierEquipesNomsPrix ();       
	
}
