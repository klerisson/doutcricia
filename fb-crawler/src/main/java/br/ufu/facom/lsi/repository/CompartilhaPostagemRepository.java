package br.ufu.facom.lsi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.ufu.facom.lsi.model.CompartilhaPostagem;

public interface CompartilhaPostagemRepository extends JpaRepository<CompartilhaPostagem, Integer> {

	public CompartilhaPostagem findByIdpostagemAndIdusuario(String idpostagem, String idusuario);
}
