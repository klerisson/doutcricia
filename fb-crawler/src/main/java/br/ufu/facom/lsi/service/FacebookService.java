package br.ufu.facom.lsi.service;

import br.ufu.facom.lsi.exception.UserException;
import br.ufu.facom.lsi.model.Usuario;

public interface FacebookService {

	public Usuario saveUsuario(String accessToken) throws UserException;

	public void getFbProfile(Usuario u, String accessToken);

}
