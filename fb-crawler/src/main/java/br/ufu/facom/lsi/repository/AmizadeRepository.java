package br.ufu.facom.lsi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.ufu.facom.lsi.model.Amizade;

public interface AmizadeRepository extends JpaRepository<Amizade, Integer> {

	public List<Amizade> findByIdamigoAndIdusuario(String idamigo, String idusuario);
}
