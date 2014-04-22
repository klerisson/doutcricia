package br.ufu.facom.lsi.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the programa_tv database table.
 * 
 */
@Entity
@Table(name="programa_tv")
@NamedQuery(name="ProgramaTv.findAll", query="SELECT p FROM ProgramaTv p")
public class ProgramaTv implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="idprograma_tv")
	private Integer idprogramaTv;

	@Column(name="titulo_programa_tv")
	private String tituloProgramaTv;

	public ProgramaTv() {
	}

	public Integer getIdprogramaTv() {
		return this.idprogramaTv;
	}

	public void setIdprogramaTv(Integer idprogramaTv) {
		this.idprogramaTv = idprogramaTv;
	}

	public String getTituloProgramaTv() {
		return this.tituloProgramaTv;
	}

	public void setTituloProgramaTv(String tituloProgramaTv) {
		this.tituloProgramaTv = tituloProgramaTv;
	}

}