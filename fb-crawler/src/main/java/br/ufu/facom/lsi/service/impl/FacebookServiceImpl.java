package br.ufu.facom.lsi.service.impl;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormatter;
import org.joda.time.format.ISODateTimeFormat;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.social.facebook.api.EducationEntry;
import org.springframework.social.facebook.api.Facebook;
import org.springframework.social.facebook.api.FacebookProfile;
import org.springframework.social.facebook.api.PagedList;
import org.springframework.social.facebook.api.PagingParameters;
import org.springframework.social.facebook.api.Post;
import org.springframework.social.facebook.api.Reference;
import org.springframework.social.facebook.api.WorkEntry;
import org.springframework.social.facebook.api.impl.FacebookTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import br.ufu.facom.lsi.dto.jsongen.sharedposts.Datum;
import br.ufu.facom.lsi.dto.jsongen.sharedposts.SharedPosts;
import br.ufu.facom.lsi.dto.jsongen.videoratings.Movie;
import br.ufu.facom.lsi.dto.jsongen.videoratings.VideoRatings;
import br.ufu.facom.lsi.exception.UserException;
import br.ufu.facom.lsi.model.Amizade;
import br.ufu.facom.lsi.model.AvaliacaoFilme;
import br.ufu.facom.lsi.model.CompartilhaPostagem;
import br.ufu.facom.lsi.model.EstudaEm;
import br.ufu.facom.lsi.model.Filme;
import br.ufu.facom.lsi.model.LikePostagem;
import br.ufu.facom.lsi.model.Postagem;
import br.ufu.facom.lsi.model.TrabalhaEm;
import br.ufu.facom.lsi.model.Usuario;
import br.ufu.facom.lsi.repository.AmizadeRepository;
import br.ufu.facom.lsi.repository.AvaliacaoFilmeRepository;
import br.ufu.facom.lsi.repository.CompartilhaPostagemRepository;
import br.ufu.facom.lsi.repository.EstudaEmRepository;
import br.ufu.facom.lsi.repository.FilmeRepository;
import br.ufu.facom.lsi.repository.LikePostagemRepository;
import br.ufu.facom.lsi.repository.PostagemRepository;
import br.ufu.facom.lsi.repository.TrabalhaEmRepository;
import br.ufu.facom.lsi.repository.UsuarioRepository;
import br.ufu.facom.lsi.service.FacebookService;

@Service
public class FacebookServiceImpl implements FacebookService {

	private static final Logger logger = LoggerFactory
			.getLogger(FacebookServiceImpl.class);

	@Autowired
	private RestTemplate restTemplate;

	@Autowired
	private UsuarioRepository usuarioRepository;

	@Autowired
	private TrabalhaEmRepository trabalhaEmRepository;

	@Autowired
	private EstudaEmRepository estudaEmRepository;

	@Autowired
	private LikePostagemRepository likePostagemRepository;

	@Autowired
	private AmizadeRepository amizadeRepository;

	@Autowired
	private PostagemRepository postagemRepository;

	@Autowired
	private FilmeRepository filmeRepository;

	@Autowired
	private AvaliacaoFilmeRepository avaliacaoRepository;

	@Autowired
	private CompartilhaPostagemRepository compartilhaRepository;

	private void getFriendList(String accessToken) {

		Facebook facebook = new FacebookTemplate(accessToken);
		;
		try {

			List<FacebookProfile> friends = facebook.friendOperations()
					.getFriendProfiles();

			List<Amizade> amizades = new ArrayList<Amizade>();
			for (FacebookProfile profile : friends) {

				Amizade a = new Amizade();
				a.setIdusuario(facebook.userOperations().getUserProfile()
						.getId());
				a.setIdamigo(profile.getId());
				amizades.add(a);

				try {
					List<Amizade> lTemp = this.amizadeRepository
							.findByIdamigoAndIdusuario(a.getIdamigo(),
									a.getIdusuario());

					if (!lTemp.isEmpty()) {
						a.setId(lTemp.get(0).getId());
					}

				} catch (Exception e) {
					logger.warn(
							"Falha ao localizar amigos já cadastrados: idAmigo: "
									+ a.getIdamigo() + ", id "
									+ a.getIdusuario(), e);
				}

			}

			this.amizadeRepository.save(amizades);

		} catch (Exception e) {
			logger.warn("Falha ao extrair amizades do usuario id: "
					+ facebook.userOperations().getUserProfile().getId(), e);
		}

	}

	// private void postPhotoAndTaggAllFriends(String accessToken) {
	//
	// Facebook facebook = new FacebookTemplate(accessToken);
	// List<FacebookProfile> friends = facebook.friendOperations()
	// .getFriendProfiles();
	// try {
	//
	// Resource photo = new FileSystemResource(
	// "D:\\personl drive\\1003833_523350081065609_1979981052_n.jpg");
	// String photoId = facebook.mediaOperations().postPhoto(photo);
	//
	// for (FacebookProfile profile : friends) {
	//
	// restTemplate.postForLocation("https://graph.facebook.com/"
	// + photoId + "/tags?to=" + profile.getId()
	// + "&x=20&y=20" + "&access_token=" + accessToken, null);
	//
	// }
	//
	// } catch (Exception e) {
	// e.printStackTrace();
	// }
	//
	// }

	@Override
	@Async
	public void getFbProfile(Usuario u, String accessToken) {

		try {

			Facebook facebook = new FacebookTemplate(accessToken);
			FacebookProfile fp = facebook.userOperations().getUserProfile();

			try {
				List<TrabalhaEm> listTe = new ArrayList<TrabalhaEm>();
				for (WorkEntry we : fp.getWork()) {
					TrabalhaEm te = new TrabalhaEm();

					if (we.getEmployer() != null) {

						te.setIdlocaltrabalho(we.getEmployer().getId());
						te.setTokenusuario(u.getTokenusuario());
						te.setDatainicio(we.getStartDate());
						te.setDatatermino(we.getEndDate());
						te.setNomelocaltrabalho(we.getEmployer().getName());

						TrabalhaEm temp = this.trabalhaEmRepository
								.findTrabalhoByFbId(we.getEmployer().getId());

						if (temp != null) {
							te.setId(temp.getId());
						}

					} else {
						continue;
					}

					listTe.add(te);
				}

				this.trabalhaEmRepository.save(listTe);

			} catch (Exception e) {
				logger.warn(
						"Falha na extracao do local de trabalho para o usuario id: "
								+ u.getIdusuario(), e);
			}

			try {
				List<EstudaEm> listEe = new ArrayList<EstudaEm>();
				for (EducationEntry ede : fp.getEducation()) {

					EstudaEm ee = new EstudaEm();
					if (ede.getSchool() != null) {
						ee.setIdlocalestudo(ede.getSchool().getName());
						ee.setTokenusuario(u.getTokenusuario());
						if (ede.getYear() != null) {
							ee.setAnoturma(ede.getYear().getName());
						}

						EstudaEm temp = this.estudaEmRepository.findByFbId(ede
								.getSchool().getId());

						if (temp != null) {
							ee.setId(temp.getId());
						}

					} else {
						continue;
					}

					listEe.add(ee);
				}

				this.estudaEmRepository.save(listEe);

			} catch (Exception e) {
				logger.warn(
						"Falha na extracao do local de estudo para o usuario id: "
								+ u.getTokenusuario(), e);
			}

			// TODO: Photos

			try {
				List<Postagem> postagens = new ArrayList<Postagem>();
				for (Post p : facebook.feedOperations().getFeed()) {
					Postagem po = new Postagem();

					try {

						List<Postagem> poTemp = this.postagemRepository
								.findByIdAndConteudopostagem(
										u.getTokenusuario(), p.getMessage());
						if (!poTemp.isEmpty()) {
							po.setIdpostagem(poTemp.get(0).getIdpostagem());
						}

					} catch (Exception e) {
						logger.warn("Postagem nao recuperada.", e);
					}

					po.setId(p.getId());
					po.setConteudopostagem(p.getMessage());

					try {

						po.setDatapostagem(new SimpleDateFormat(
								"yyyy-MM-dd HH:mm:ss").format(p
								.getCreatedTime()));

					} catch (Exception e) {
						logger.warn(
								"Falha na conversao de data de criacao de postagem.",
								e);

						if (p.getCreatedTime() != null) {

							po.setDatapostagem(p.getCreatedTime().toString());
						} else {

							logger.warn("Data de criacao de postagem nula.");
						}
					}

					if (p.getFrom() != null) {
						po.setIdusuarioorigem(p.getFrom().getId());
					}

					// TODO: postagem vai para vários usuários
					// po.setIdusuariodestino(p.getTo);

					// Fetching posts likes
					List<LikePostagem> likeList = new ArrayList<LikePostagem>();
					PagedList<Reference> plr = facebook.likeOperations()
							.getLikes(p.getId());
					PagingParameters pparam = null;
					for (;;) {

						for (Reference r : plr) {
							LikePostagem lp = new LikePostagem();
							lp.setIdpost(po.getId());
							lp.setIdusuariolike(r.getId());

							try {

								List<LikePostagem> lpTemp = this.likePostagemRepository
										.findByIdpostAndIdusuariolike(
												po.getId(), r.getId());
								if (!lpTemp.isEmpty()) {
									lp.setId(lpTemp.get(0).getId());
								}

							} catch (Exception e) {
								logger.warn(
										"findByIdpostagemAndIdusuariolike fail: ",
										e);
							}
							likeList.add(lp);
						}

						pparam = plr.getNextPage();
						if (pparam == null) {
							break;
						}
						plr = facebook.likeOperations().getLikes(p.getId(),
								pparam);

					}

					this.likePostagemRepository.save(likeList);

					SharedPosts sharedPosts = null;
					try {
						// SharedPost retrieve
						sharedPosts = facebook.restOperations().getForObject(
								"https://graph.facebook.com/" + p.getId()
										+ "/sharedposts", SharedPosts.class);

						// Facebook concat user id with post id, really dont
						// know
						// why
						if (sharedPosts != null
								&& sharedPosts.getData().isEmpty()
								&& p.getId().contains("_")) {

							sharedPosts = facebook.restOperations()
									.getForObject(
											"https://graph.facebook.com/"
													+ p.getId().substring(
															p.getId().indexOf(
																	'_') + 1)
													+ "/sharedposts",
											SharedPosts.class);
						}
						// TODO paging... tem mais shared na req
						if (sharedPosts != null) {
							List<CompartilhaPostagem> listCp = new ArrayList<CompartilhaPostagem>();
							for (Datum d : sharedPosts.getData()) {

								try {

									CompartilhaPostagem cp = this.compartilhaRepository
											.findByIdpostagemAndIdusuario(
													d.getId(),
													u.getTokenusuario());

									if (cp == null) {
										cp = new CompartilhaPostagem();
									}
									cp.setIdpostagem(d.getId());

									if (d.getFrom() != null) {
										cp.setIdusuariocompartilha(d.getFrom()
												.getId());
									}

									listCp.add(cp);

								} catch (Exception e) {
									logger.warn("Compartilhamento error: ", e);
									continue;
								}
							}

							this.compartilhaRepository.save(listCp);

						}

					} catch (Exception e) {
						logger.error("Compartilhamento falha: ", e);
					}

					postagens.add(po);

				}

				this.postagemRepository.save(postagens);

			} catch (Exception e) {
				logger.warn(
						"Falha ao extrair postagens do usuario id: "
								+ u.getTokenusuario(), e);
			}

			try {

				VideoRatings vr = facebook.restOperations().getForObject(
						"https://graph.facebook.com/" + u.getTokenusuario()
								+ "/video.rates?access_token=" + accessToken,
						VideoRatings.class);

				if (vr != null && vr.getData() != null) {

					for (;;) {
						for (br.ufu.facom.lsi.dto.jsongen.videoratings.Datum d : vr
								.getData()) {

							try {

								Movie m = d.getData().getMovie();

								Filme f = this.filmeRepository
										.findByTitulofilme(m.getTitle());
								AvaliacaoFilme af = null;
								if (f == null) {
									f = new Filme();
									f.setTitulofilme(m.getTitle());
									af = new AvaliacaoFilme();
									af.setFilme(f);
									af.setUsuario(u);
									af.setNota(d.getData().getRating().getValue()
											.toString());

									DateTimeFormatter parser2 = ISODateTimeFormat.dateTimeNoMillis();
									DateTime dt = parser2.parseDateTime(d.getPublish_time());
									Timestamp timestamp = new java.sql.Timestamp(dt.getMillis());

									af.setDataavaliacao(timestamp);
								} else {
									af = this.avaliacaoRepository
											.findByfilmeAndUsuario(f, u);
								}

//								List<AvaliacaoFilme> listTemp = new ArrayList<AvaliacaoFilme>();
//								listTemp.add(af);
//								f.setAvaliacaoFilmes(listTemp);

								this.filmeRepository.save(f);
								this.avaliacaoRepository.save(af);
							} catch (Exception e) {
								logger.error("Falha avaliacao: ",e);
								continue;
							}
						}

						String next = vr.getPaging().getNext();
						if (next == null || next.isEmpty()) {
							break;
						} else {

							vr = facebook.restOperations().getForObject(
									next + "?access_token=" + accessToken,
									VideoRatings.class);
							
							if (vr == null)
								break;
						}
					}

				}
			} catch (Exception e) {
				logger.warn(
						"Falha ao gravar avaliacoes de video do usuario id: "
								+ u.getTokenusuario(), e);
			}

			this.getFriendList(accessToken);

		} catch (Exception e) {
			logger.error("Falha geral ao recuperar dados FB: ", e);
		}
	}

	@Override
	public Usuario saveUsuario(String accessToken) throws UserException {

		try {

			Facebook facebook = new FacebookTemplate(accessToken);
			FacebookProfile fp = facebook.userOperations().getUserProfile();

			Usuario u = new Usuario();
			u.setAccessToken(accessToken);
			u.setNomeusuario(fp.getName());
			u.setTokenusuario(fp.getId());
			u.setEmailusuario(fp.getEmail());
			u.setDtnascusuario(fp.getBirthday());

			if (fp.getHometown() != null) {
				u.setCidadenatalusuario(fp.getHometown().getName());
			}

			if (fp.getLocation() != null) {
				u.setCidadeusuario(fp.getLocation().getName());
			}

			u.setSexousuario(fp.getGender());
			u.setReligiaousuario(fp.getReligion());
			u.setStatusrelacionamento(fp.getRelationshipStatus());

			try {

				Usuario temp = this.usuarioRepository.findUsuarioByUserId(u
						.getTokenusuario());
				if (temp != null) {
					u.setIdusuario(temp.getIdusuario());
				}

			} catch (Exception e) {
				logger.warn(
						"Falha ao recuperar usuario já cadastrado: token - "
								+ u.getTokenusuario(), e);
			}

			return this.usuarioRepository.save(u);

		} catch (Exception e) {
			logger.error("Falha na extracao do usuario", e);
			throw new UserException();
		}
	}

}
