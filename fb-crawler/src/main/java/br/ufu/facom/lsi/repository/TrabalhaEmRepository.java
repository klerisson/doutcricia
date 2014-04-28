package br.ufu.facom.lsi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.ufu.facom.lsi.model.TrabalhaEm;

public interface TrabalhaEmRepository extends JpaRepository<TrabalhaEm, Integer> {

	@Query("SELECT t FROM TrabalhaEm t WHERE t.idlocaltrabalho = :idlocaltrabalho")
	public TrabalhaEm findTrabalhoByFbId(@Param("idlocaltrabalho") String idlocaltrabalho);
}
