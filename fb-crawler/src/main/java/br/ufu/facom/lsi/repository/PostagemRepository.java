package br.ufu.facom.lsi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.ufu.facom.lsi.model.Postagem;

public interface PostagemRepository extends JpaRepository<Postagem, Integer> {

	public List<Postagem> findByIdpostagem(String idpostagem);

}
