package br.ufu.facom.lsi.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.ufu.facom.lsi.dto.FilmeDTO;
import br.ufu.facom.lsi.exception.FilmeNotFoundException;
import br.ufu.facom.lsi.model.Filme;
import br.ufu.facom.lsi.repository.FilmeRepository;
import br.ufu.facom.lsi.service.FilmeService;

@Service
public class RepositoryFilmeService implements FilmeService {

	private static final Logger LOGGER = LoggerFactory
			.getLogger(RepositoryFilmeService.class);

	@Resource
	private FilmeRepository filmeRepository;

	@Transactional
	@Override
	public Filme create(FilmeDTO created) {
		LOGGER.debug("Creating a new movie with information: " + created);

		Filme filme = new Filme();
		filme.setTitulofilme(created.getTitulofilme());
		return filmeRepository.save(filme);

	}

	@Transactional(readOnly = true)
	@Override
	public List<Filme> findAll() {
		LOGGER.debug("Finding all movies");

		return filmeRepository.findAll();

	}

	@Transactional(readOnly = true)
	@Override
	public Filme findById(Long id) {
		LOGGER.debug("Finding movie by id: " + id);
		return filmeRepository.findOne(id);
		
	}

	@Override
	public Filme update(FilmeDTO updated) throws FilmeNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Transactional(readOnly = true)
	@Override
	public List<Filme> fetchMoviesToScore() {
		LOGGER.debug("Finding all movies to score");
		return filmeRepository.findByStatusfilme();
	}

}
