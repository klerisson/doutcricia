package br.ufu.facom.lsi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.ufu.facom.lsi.model.LikePostagem;

public interface LikePostagemRepository extends JpaRepository<LikePostagem, Integer> {
	
	//public List<LikePostagem> findByIdpostagemAndIdusuariolike(String idpostagem, String idusuariolike);
	
}
