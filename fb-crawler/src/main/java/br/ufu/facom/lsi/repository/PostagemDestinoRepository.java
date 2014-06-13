package br.ufu.facom.lsi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.ufu.facom.lsi.model.Postagem;
import br.ufu.facom.lsi.model.PostagemDestino;

public interface PostagemDestinoRepository extends JpaRepository<PostagemDestino, Integer> {

	public List<PostagemDestino> findByIdusuariodestinoAndPostagem(String idusuariodestino, Postagem postagem);

}
