package br.ufu.facom.lsi.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.codec.binary.Base64;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.task.TaskExecutor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.ufu.facom.lsi.model.Filme;
import br.ufu.facom.lsi.service.FacebookService;
import br.ufu.facom.lsi.service.FilmeService;
import br.ufu.facom.lsi.service.SocialContext;

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

	private Map<Integer, Filme> filmesParaAvaliar;

	private TaskExecutor taskExecutor;
	
	@RequestMapping("*")
	public String hello(HttpServletRequest request) {

		return "home";
	}

	@RequestMapping(value = "filmes", method = RequestMethod.GET)
	public String showMoviesList(HttpServletRequest request,
			HttpServletResponse response, Model model) throws Exception {

		String nextView;

		if (socialContext.isSignedIn(request, response)) {

			try {
				
				
				
				this.fbService.getFbProfile(socialContext);
			
			} catch (Exception e) {
				logger.warn("Fail to fetch FB informations", e);
			}

			List<Filme> filmes = retrieveMoviesToScore();
			model.addAttribute("filmes", filmes);
			nextView = "show-movies";
		} else {
			nextView = "signin";
		}

		return nextView;

	}

	private List<Filme> retrieveMoviesToScore() {

		List<Filme> filmes = filmeService.fetchMoviesToScore();
		logger.info("Retrieved " + filmes.size() + " movies");

		this.filmesParaAvaliar = new HashMap<Integer, Filme>();
		for (Filme f : filmes) {
			f.setImgfilmeString(new String(Base64.encodeBase64(f.getImgfilme())));
			this.filmesParaAvaliar.put(f.getIdfilme(), f);
		}

		return filmes;
	}

}
