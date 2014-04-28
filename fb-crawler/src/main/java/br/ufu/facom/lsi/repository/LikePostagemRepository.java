package br.ufu.facom.lsi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.ufu.facom.lsi.model.LikePostagem;

public interface LikePostagemRepository extends JpaRepository<LikePostagem, Integer> {
	
	public List<LikePostagem> findByIdpostAndIdusuariolike(String idpost, String idusuariolike);
	
}
