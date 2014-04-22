package br.ufu.facom.lsi.model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the foto database table.
 * 
 */
@Entity
@NamedQuery(name="Foto.findAll", query="SELECT f FROM Foto f")
public class Foto implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	private Timestamp datafoto;

	private String idfoto;

	private String idusuarioorigem;

	public Foto() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Timestamp getDatafoto() {
		return this.datafoto;
	}

	public void setDatafoto(Timestamp datafoto) {
		this.datafoto = datafoto;
	}

	public String getIdfoto() {
		return this.idfoto;
	}

	public void setIdfoto(String idfoto) {
		this.idfoto = idfoto;
	}

	public String getIdusuarioorigem() {
		return this.idusuarioorigem;
	}

	public void setIdusuarioorigem(String idusuarioorigem) {
		this.idusuarioorigem = idusuarioorigem;
	}

}