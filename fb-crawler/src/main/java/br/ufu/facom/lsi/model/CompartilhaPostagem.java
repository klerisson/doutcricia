package br.ufu.facom.lsi.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the compartilha_postagem database table.
 * 
 */
@Entity
@Table(name="compartilha_postagem")
@NamedQuery(name="CompartilhaPostagem.findAll", query="SELECT c FROM CompartilhaPostagem c")
public class CompartilhaPostagem implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	private String idpostagem;

	private String idusuariocompartilha;

	private String idusuario;
	
	public CompartilhaPostagem() {
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

	public String getIdusuariocompartilha() {
		return this.idusuariocompartilha;
	}

	public void setIdusuariocompartilha(String idusuariocompartilha) {
		this.idusuariocompartilha = idusuariocompartilha;
	}

	public String getIdusuario() {
		return idusuario;
	}

	public void setIdusuario(String idusuario) {
		this.idusuario = idusuario;
	}

}