package br.ufu.facom.lsi.service;

import br.ufu.facom.lsi.dto.AvaliacaoDTO;
import br.ufu.facom.lsi.exception.RatingException;

public interface MovieRatingService {
	
	public void rateMovie(AvaliacaoDTO avaliacao) throws RatingException;
	
}
