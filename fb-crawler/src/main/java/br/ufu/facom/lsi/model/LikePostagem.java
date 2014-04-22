package br.ufu.facom.lsi.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the like_postagem database table.
 * 
 */
@Entity
@Table(name="like_postagem")
@NamedQuery(name="LikePostagem.findAll", query="SELECT l FROM LikePostagem l")
public class LikePostagem implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	private String idpostagem;

	private String idusuariolike;

	public LikePostagem() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getIdpostagem() {
		return this.idpostagem;
	}

	public void setIdpostagem(String idpostagem) {
		this.idpostagem = idpostagem;
	}

	public String getIdusuariolike() {
		return this.idusuariolike;
	}

	public void setIdusuariolike(String idusuariolike) {
		this.idusuariolike = idusuariolike;
	}

}