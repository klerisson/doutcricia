package br.ufu.facom.lsi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.ufu.facom.lsi.model.Filme;

public interface FilmeRepository extends JpaRepository<Filme, Long>{
 
	public List<Filme> findByStatusfilme();
}
