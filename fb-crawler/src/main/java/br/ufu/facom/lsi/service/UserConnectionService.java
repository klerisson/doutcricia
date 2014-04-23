package br.ufu.facom.lsi.service;

import br.ufu.facom.lsi.exception.UserNotFoundException;


public interface UserConnectionService {
	
	public String getAccessToken(String userId) throws UserNotFoundException;
	
}
