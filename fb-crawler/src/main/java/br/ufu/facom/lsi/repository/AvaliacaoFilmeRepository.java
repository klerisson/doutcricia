package br.ufu.facom.lsi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.ufu.facom.lsi.model.AvaliacaoFilme;
import br.ufu.facom.lsi.model.Filme;
import br.ufu.facom.lsi.model.Usuario;

public interface AvaliacaoFilmeRepository extends JpaRepository<AvaliacaoFilme, Integer>{

	public AvaliacaoFilme findByfilmeAndUsuario(Filme filme, Usuario usuario);
	
}
