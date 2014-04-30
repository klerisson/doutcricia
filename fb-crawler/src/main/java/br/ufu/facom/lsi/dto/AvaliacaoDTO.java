package br.ufu.facom.lsi.dto;

import java.io.Serializable;

public class AvaliacaoDTO implements Serializable{

	private static final long serialVersionUID = -8561384656146059547L;
	
	private Integer idfilme;
	
	private Integer nota;

	private Integer idusuario;

	public Integer getIdfilme() {
		return idfilme;
	}

	public void setIdfilme(Integer idfilme) {
		this.idfilme = idfilme;
	}

	public Integer getNota() {
		return nota;
	}

	public void setNota(Integer nota) {
		this.nota = nota;
	}

	public Integer getIdusuario() {
		return idusuario;
	}

	public void setIdusuario(Integer idusuario) {
		this.idusuario = idusuario;
	}

}
