package br.ufu.facom.lsi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.ufu.facom.lsi.exception.UserNotFoundException;
import br.ufu.facom.lsi.model.Userconnection;
import br.ufu.facom.lsi.model.UserconnectionPK;

public interface UserConnectionRepository extends JpaRepository<Userconnection, UserconnectionPK> {

	@Query("SELECT u.accesstoken FROM Userconnection u WHERE u.id.provideruserid = :userId")
	public String findAccessTokenByUserId(@Param("userId") String userId) throws UserNotFoundException;
	
}
