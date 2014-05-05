package br.ufu.facom.lsi.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.codec.binary.Base64;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import br.ufu.facom.lsi.dto.AvaliacaoDTO;
import br.ufu.facom.lsi.dto.JsonResponse;
import br.ufu.facom.lsi.exception.UserNotFoundException;
import br.ufu.facom.lsi.model.AvaliacaoFilme;
import br.ufu.facom.lsi.model.Filme;
import br.ufu.facom.lsi.model.Usuario;
import br.ufu.facom.lsi.repository.UserConnectionRepository;
import br.ufu.facom.lsi.service.FacebookService;
import br.ufu.facom.lsi.service.FilmeService;
import br.ufu.facom.lsi.service.MovieRatingService;
import br.ufu.facom.lsi.service.SocialContext;
import br.ufu.facom.lsi.service.UsuarioService;

@Controller
public class FacebookController {

	private static final Logger logger = LoggerFactory
			.getLogger(FacebookController.class);

	@Autowired
	private SocialContext socialContext;

	@Autowired
	private FacebookService fbService;

	@Autowired
	private FilmeService filmeService;

	@Autowired
	private UsuarioService usuarioService;

	@Autowired
	private MovieRatingService movieService;

	@Autowired
	private UserConnectionRepository userConnectionRepository;

	private List<Filme> filmesParaAvaliar;

	@RequestMapping("*")
	public String home(HttpServletRequest request) {

		return "home";
	}

	@RequestMapping(value = "filmes", method = RequestMethod.POST)
	public String showMoviesList(HttpServletRequest request,
			HttpServletResponse response, Model model) throws Exception {

		String nextView;

		if (socialContext.isSignedIn(request, response)) {

			try {

				String accessToken = this.fetchAccessToken();

				Usuario u = this.fbService.saveUsuario(accessToken);
				this.fbService.getFbProfile(u, accessToken);

				List<Filme> filmes = retrieveMoviesToScore();
				model.addAttribute("filmes", filmes);

				List<AvaliacaoFilme> ratings = retrieveRatings(u, filmes);
				model.addAttribute("ratings", ratings);

				nextView = "show-movies";

			} catch (Exception e) {
				logger.error("Fail to fetch FB informations", e);
				// TODO error page do not show movies.
				nextView = "show-movies";
			}

		} else {
			nextView = "signin";
		}

		return nextView;

	}

	private List<AvaliacaoFilme> retrieveRatings(Usuario u, List<Filme> filmes) {

		List<AvaliacaoFilme> ratings = new ArrayList<AvaliacaoFilme>(this.filmesParaAvaliar.size());
		try {
			
			ratings = movieService.fetchDefaultRatings(u, filmes);

		} catch (Exception e) {
			logger.warn("Could not retrieve default ratings!", e);
		}
		return ratings;
	}

	private String fetchAccessToken() throws UserNotFoundException {

		String accessToken = this.userConnectionRepository
				.findAccessTokenByUserId(this.socialContext.getFacebook()
						.userOperations().getUserProfile().getId());
		return accessToken;

	}

	private List<Filme> retrieveMoviesToScore() {

		if (this.filmesParaAvaliar != null && this.filmesParaAvaliar.size() > 0) {
			return this.filmesParaAvaliar;
		} else {

			List<Filme> filmes = filmeService.fetchMoviesToScore();
			logger.info("Retrieved " + filmes.size() + " movies");

			this.filmesParaAvaliar = new ArrayList<Filme>();
			for (Filme f : filmes) {

				if (f.getTitulofilme().length() > 15) {
					f.setTitulofilme(f.getTitulofilme().substring(0, 13)
							.concat("..."));
				}

				f.setImgfilmeString(new String(Base64.encodeBase64(f
						.getImgfilme())));

				this.filmesParaAvaliar.add(f);
			}

			return filmes;
		}
	}

	@RequestMapping(headers = { "Accept=application/json" }, value = "rate", method = RequestMethod.POST)
	@ResponseBody
	public JsonResponse rate(@RequestBody AvaliacaoDTO avaliacao,
			HttpServletRequest request, HttpServletResponse response) {

		try {

			if (socialContext.isSignedIn(request, response)) {

				Usuario u = this.usuarioService.findByUserId(socialContext
						.getFacebook().userOperations().getUserProfile()
						.getId());

				avaliacao.setIdusuario(u.getIdusuario());

				this.movieService.rateMovie(avaliacao);

				return new JsonResponse("OK", "");

			} else {
				throw new RuntimeException();
			}

		} catch (Exception e) {
			logger.error("Falha ao avaliar filme.", e);
			return new JsonResponse("Fail",
					"Desculpe, mas ocorreu uma falha ao avaliar filme. Por favor tente mais tarde.");
		}

	}
}
