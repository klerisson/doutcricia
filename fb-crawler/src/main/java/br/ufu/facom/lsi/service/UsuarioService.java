package br.ufu.facom.lsi.service;

import br.ufu.facom.lsi.exception.UserNotFoundException;
import br.ufu.facom.lsi.model.Usuario;

public interface UsuarioService {

	public Usuario findByUserId(String fbId) throws UserNotFoundException;
	
}
