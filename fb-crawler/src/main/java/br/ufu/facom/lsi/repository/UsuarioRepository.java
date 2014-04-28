package br.ufu.facom.lsi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.ufu.facom.lsi.exception.UserNotFoundException;
import br.ufu.facom.lsi.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
	
	@Query("SELECT u FROM Usuario u WHERE u.tokenusuario = :tokenusuario")
	public Usuario findUsuarioByUserId(@Param("tokenusuario") String tokenusuario) throws UserNotFoundException;
	
}
