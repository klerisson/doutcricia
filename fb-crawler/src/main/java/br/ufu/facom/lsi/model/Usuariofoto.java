package br.ufu.facom.lsi.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the usuariofoto database table.
 * 
 */
@Entity
@NamedQuery(name="Usuariofoto.findAll", query="SELECT u FROM Usuariofoto u")
public class Usuariofoto implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer idtagfoto;

	private String idfoto;

	private String idusuariofoto;

	public Usuariofoto() {
	}

	public Integer getIdtagfoto() {
		return this.idtagfoto;
	}

	public void setIdtagfoto(Integer idtagfoto) {
		this.idtagfoto = idtagfoto;
	}

	public String getIdfoto() {
		return this.idfoto;
	}

	public void setIdfoto(String idfoto) {
		this.idfoto = idfoto;
	}

	public String getIdusuariofoto() {
		return this.idusuariofoto;
	}

	public void setIdusuariofoto(String idusuariofoto) {
		this.idusuariofoto = idusuariofoto;
	}

}