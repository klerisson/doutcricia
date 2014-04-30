package br.ufu.facom.lsi.service;

import java.util.List;

import br.ufu.facom.lsi.dto.FilmeDTO;
import br.ufu.facom.lsi.model.Filme;

public interface FilmeService {

	public Filme create(FilmeDTO created);

    public List<Filme> findAll();

    public Filme findById(Integer id);

    public List<Filme> fetchMoviesToScore();
	
}
