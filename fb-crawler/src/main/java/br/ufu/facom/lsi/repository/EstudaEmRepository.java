package br.ufu.facom.lsi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.ufu.facom.lsi.model.EstudaEm;

public interface EstudaEmRepository extends JpaRepository<EstudaEm, Integer> {

	public List<EstudaEm> findByidlocalestudoAndTokenusuario(String idlocalestudo, String tokenusuario);
}
