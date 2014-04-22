package br.ufu.facom.lsi.service.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
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

import br.ufu.facom.lsi.dto.jsongen.sharedposts.SharedPosts;
import br.ufu.facom.lsi.dto.jsongen.videoratings.VideoRatings;
import br.ufu.facom.lsi.exception.UserExecption;
import br.ufu.facom.lsi.model.Amizade;
import br.ufu.facom.lsi.model.EstudaEm;
import br.ufu.facom.lsi.model.LikePostagem;
import br.ufu.facom.lsi.model.Postagem;
import br.ufu.facom.lsi.model.TrabalhaEm;
import br.ufu.facom.lsi.model.Usuario;
import br.ufu.facom.lsi.service.FacebookService;
import br.ufu.facom.lsi.service.SocialContext;

@Service
public class FacebookServiceImpl implements FacebookService {

	private static final Logger logger = LoggerFactory
			.getLogger(FacebookServiceImpl.class);

	@Autowired
	private RestTemplate restTemplate;

	public void getFriendList(SocialContext sc) {

		Facebook facebook = sc.getFacebook();
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

			}
			// TODO: Gravar amizades em banco de dados

		} catch (Exception e) {
			logger.warn("Falha ao extrair amizades do usuario id: "
					+ facebook.userOperations().getUserProfile().getId(), e);
		}

	}

	public void postPhotoAndTaggAllFriends(String accessToken) {

		Facebook facebook = new FacebookTemplate(accessToken);
		List<FacebookProfile> friends = facebook.friendOperations()
				.getFriendProfiles();
		try {

			Resource photo = new FileSystemResource(
					"D:\\personl drive\\1003833_523350081065609_1979981052_n.jpg");
			String photoId = facebook.mediaOperations().postPhoto(photo);

			for (FacebookProfile profile : friends) {

				restTemplate.postForLocation("https://graph.facebook.com/"
						+ photoId + "/tags?to=" + profile.getId()
						+ "&x=20&y=20" + "&access_token=" + accessToken, null);

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public void getFbProfile(SocialContext socialContext) {

		Facebook facebook = socialContext.getFacebook();
		FacebookProfile fp = facebook.userOperations().getUserProfile();

		Usuario u = new Usuario();
		try {

			u = new Usuario();
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

			// TODO Gravar em banco o usuario

		} catch (Exception e) {
			logger.error("Falha na extracao do usuario", e);
			throw new UserExecption();
		}

		try {
			List<TrabalhaEm> listTe = new ArrayList<TrabalhaEm>();
			for (WorkEntry we : fp.getWork()) {
				TrabalhaEm te = new TrabalhaEm();

				if (we.getEmployer() != null) {
					te.setIdlocaltrabalho(we.getEmployer().getName());
				}
				te.setTokenusuario(u.getTokenusuario());
				te.setDatainicio(we.getStartDate());

				listTe.add(te);
				// TODO: gravar no banco??
			}
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
				}

				ee.setTokenusuario(u.getTokenusuario());

				if (ede.getYear() != null) {
					ee.setAnoturma(ede.getYear().getName());
				}

				listEe.add(ee);
				// TODO: Gravar no banco
			}
		} catch (Exception e) {
			logger.warn(
					"Falha na extracao do local de estudo para o usuario id: "
							+ u.getIdusuario(), e);
		}

		// TODO: Photos

		try {
			List<Postagem> postagens = new ArrayList<Postagem>();
			for (Post p : facebook.feedOperations().getFeed()) {
				Postagem po = new Postagem();
				po.setId(p.getId());
				po.setConteudopostagem(p.getMessage());

				try {

					po.setDatapostagem(new SimpleDateFormat(
							"yyyy-MM-dd HH:mm:ss").format(p.getCreatedTime()));

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
				PagedList<Reference> plr = facebook.likeOperations().getLikes(
						p.getId());
				PagingParameters pparam = null;
				for (;;) {

					for (Reference r : plr) {
						LikePostagem lp = new LikePostagem();
						lp.setIdpostagem(po.getId());
						lp.setIdusuariolike(r.getId());

						// TODO gravar no banco, ainda náo normalizado
					}

					pparam = plr.getNextPage();
					if (pparam == null) {
						break;
					}
					plr = facebook.likeOperations().getLikes(p.getId(), pparam);

				}

				SharedPosts sharedPosts = facebook.restOperations()
						.getForObject(
								"https://graph.facebook.com/" + p.getId()
										+ "/sharedposts", SharedPosts.class);
				
				//Facebook concat user id with post id, really dont know why
				if(sharedPosts.getData().isEmpty() && p.getId().contains("_")){
					
					sharedPosts = facebook.restOperations()
							.getForObject(
									"https://graph.facebook.com/" + p.getId().substring(p.getId().indexOf('_') + 1)
											+ "/sharedposts", SharedPosts.class);
				}
				
				
				System.out.println(sharedPosts);
//				for (Post postShared : sharedPosts.) {
//					CompartilhaPostagem cp = new CompartilhaPostagem();
//					cp.setIdpostagem(po.getId());
//
//					if (postShared.getFrom() != null) {
//						cp.setIdusuariocompartilha(postShared.getFrom().getId());
//					}
//
//					// TODO: Gravar no banco
//				}

				postagens.add(po);

			}
			// TODO: gravar no banco a postagem

		} catch (Exception e) {
			logger.warn(
					"Falha ao extrair postagens do usuario id: "
							+ u.getIdusuario(), e);

		}

		//TODO: uncomment
		//this.getFriendList(socialContext);

		try {
			// Video ratings
			VideoRatings resultado = facebook.restOperations().getForObject(
					"https://graph.facebook.com/video.rates", VideoRatings.class);
			
			System.out.println(resultado);
			// TODO gravar na base as avaliaçoes
		} catch (Exception e) {
			logger.warn("Falha ao gravar avaliacoes de video do usuario id: "
					+ u.getIdusuario(), e);
		}

	}

}
