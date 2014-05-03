package br.ufu.facom.lsi.service;

import java.util.List;

import br.ufu.facom.lsi.dto.AvaliacaoDTO;
import br.ufu.facom.lsi.exception.RatingException;
import br.ufu.facom.lsi.exception.RatingNotFoundException;
import br.ufu.facom.lsi.model.AvaliacaoFilme;
import br.ufu.facom.lsi.model.Filme;
import br.ufu.facom.lsi.model.Usuario;

public interface MovieRatingService {

	public void rateMovie(AvaliacaoDTO avaliacao) throws RatingException;

	public List<AvaliacaoFilme> fetchDefaultRatings(Usuario u,
			List<Filme> filmes) throws RatingNotFoundException;

}
