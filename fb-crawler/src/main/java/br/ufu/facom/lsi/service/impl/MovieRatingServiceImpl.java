package br.ufu.facom.lsi.service.impl;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.ufu.facom.lsi.dto.AvaliacaoDTO;
import br.ufu.facom.lsi.exception.FilmeNotFoundException;
import br.ufu.facom.lsi.exception.RatingException;
import br.ufu.facom.lsi.exception.RatingNotFoundException;
import br.ufu.facom.lsi.exception.UserException;
import br.ufu.facom.lsi.model.AvaliacaoFilme;
import br.ufu.facom.lsi.model.Filme;
import br.ufu.facom.lsi.model.Usuario;
import br.ufu.facom.lsi.repository.AvaliacaoFilmeRepository;
import br.ufu.facom.lsi.repository.FilmeRepository;
import br.ufu.facom.lsi.repository.UsuarioRepository;
import br.ufu.facom.lsi.service.MovieRatingService;

@Service
public class MovieRatingServiceImpl implements MovieRatingService {

	private static final Logger logger = LoggerFactory
			.getLogger(MovieRatingServiceImpl.class);

	@Autowired
	private UsuarioRepository usuarioRepository;

	@Autowired
	private FilmeRepository FilmeRepository;

	@Autowired
	private AvaliacaoFilmeRepository avaliacaoRepository;

	@Override
	public void rateMovie(AvaliacaoDTO avaliacao) throws RatingException {

		try {

			if ((avaliacao.getNota() > 0) && (avaliacao.getNota() <= 5)) {

				Usuario u = this.usuarioRepository.findOne(avaliacao
						.getIdusuario());
				if (u == null)
					throw new UserException();

				Filme f = this.FilmeRepository.findOne(avaliacao.getIdfilme());
				if (f == null)
					throw new FilmeNotFoundException();

				AvaliacaoFilme af = this.avaliacaoRepository
						.findByfilmeAndUsuario(f, u);
				if (af == null) {
					af = new AvaliacaoFilme();
					af.setFilme(f);
					af.setUsuario(u);
				}

				af.setNota(avaliacao.getNota().toString());
				af.setDataavaliacao(new Timestamp(System.currentTimeMillis()));

				this.avaliacaoRepository.save(af);

			} else {
				throw new RatingException();
			}

		} catch (Exception e) {
			logger.error("Falha ao avaliar filme.", e);
			throw new RatingException();
		}

	}

	@Override
	public List<AvaliacaoFilme> fetchDefaultRatings(Usuario u,
			List<Filme> filmes) throws RatingNotFoundException {

		try {

			List<AvaliacaoFilme> ratings = new ArrayList<AvaliacaoFilme>(
					filmes.size());
			
			for (int i = 0; i < filmes.size(); i++) {
				
				AvaliacaoFilme af = this.avaliacaoRepository.findByfilmeAndUsuario(filmes.get(i), u);
				if(af == null){
					af = new AvaliacaoFilme();
					af.setNota("0");
				}
				ratings.add(af);
			}
			
			return ratings;

		} catch (Exception e) {
			logger.error("Falha ao recuperar avaliações.", e);
			throw new RatingNotFoundException();
		}

	}
}
