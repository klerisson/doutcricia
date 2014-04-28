package br.ufu.facom.lsi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.ufu.facom.lsi.model.EstudaEm;

public interface EstudaEmRepository extends JpaRepository<EstudaEm, Integer> {

	@Query("SELECT e FROM EstudaEm e WHERE e.idlocalestudo = :idlocalestudo")
	public EstudaEm findByFbId(@Param("idlocalestudo") String idlocalestudo);
}
