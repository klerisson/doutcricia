package br.ufu.facom.lsi.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the usuario database table.
 * 
 */
@Entity
@NamedQuery(name="Usuario.findAll", query="SELECT u FROM Usuario u")
public class Usuario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer idusuario;

	private String cidadenatalusuario;

	private String cidadeusuario;

	private String dtnascusuario;

	private String emailusuario;

	private String nomeusuario;

	private String religiaousuario;

	private String sexousuario;

	private String statusrelacionamento;

	private String tokenusuario;

	public Usuario() {
	}

	public Integer getIdusuario() {
		return this.idusuario;
	}

	public void setIdusuario(Integer idusuario) {
		this.idusuario = idusuario;
	}

	public String getCidadenatalusuario() {
		return this.cidadenatalusuario;
	}

	public void setCidadenatalusuario(String cidadenatalusuario) {
		this.cidadenatalusuario = cidadenatalusuario;
	}

	public String getCidadeusuario() {
		return this.cidadeusuario;
	}

	public void setCidadeusuario(String cidadeusuario) {
		this.cidadeusuario = cidadeusuario;
	}

	public String getDtnascusuario() {
		return this.dtnascusuario;
	}

	public void setDtnascusuario(String dtnascusuario) {
		this.dtnascusuario = dtnascusuario;
	}

	public String getEmailusuario() {
		return this.emailusuario;
	}

	public void setEmailusuario(String emailusuario) {
		this.emailusuario = emailusuario;
	}

	public String getNomeusuario() {
		return this.nomeusuario;
	}

	public void setNomeusuario(String nomeusuario) {
		this.nomeusuario = nomeusuario;
	}

	public String getReligiaousuario() {
		return this.religiaousuario;
	}

	public void setReligiaousuario(String religiaousuario) {
		this.religiaousuario = religiaousuario;
	}

	public String getSexousuario() {
		return this.sexousuario;
	}

	public void setSexousuario(String sexousuario) {
		this.sexousuario = sexousuario;
	}

	public String getStatusrelacionamento() {
		return this.statusrelacionamento;
	}

	public void setStatusrelacionamento(String statusrelacionamento) {
		this.statusrelacionamento = statusrelacionamento;
	}

	public String getTokenusuario() {
		return this.tokenusuario;
	}

	public void setTokenusuario(String tokenusuario) {
		this.tokenusuario = tokenusuario;
	}

}