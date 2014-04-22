package br.ufu.facom.lsi.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the amizade database table.
 * 
 */
@Entity
@NamedQuery(name="Amizade.findAll", query="SELECT a FROM Amizade a")
public class Amizade implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	private String idamigo;

	private String idusuario;

	public Amizade() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getIdamigo() {
		return this.idamigo;
	}

	public void setIdamigo(String idamigo) {
		this.idamigo = idamigo;
	}

	public String getIdusuario() {
		return this.idusuario;
	}

	public void setIdusuario(String idusuario) {
		this.idusuario = idusuario;
	}

}