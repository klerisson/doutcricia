package br.ufu.facom.lsi.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.ufu.facom.lsi.exception.UserNotFoundException;
import br.ufu.facom.lsi.model.Usuario;
import br.ufu.facom.lsi.repository.UsuarioRepository;
import br.ufu.facom.lsi.service.UsuarioService;

@Service
public class UsuarioServiceImpl implements UsuarioService {

	private static final Logger logger = LoggerFactory
			.getLogger(UsuarioServiceImpl.class);

	@Autowired
	private UsuarioRepository usuarioRepository;

	@Override
	public Usuario findByUserId(String fbId) throws UserNotFoundException {

		try {

			return this.usuarioRepository.findUsuarioByUserId(fbId);

		} catch (Exception e) {
			logger.error("Falha ao recuperar usuario por accessToken.", e);
			throw new UserNotFoundException();
		}
	}

}
