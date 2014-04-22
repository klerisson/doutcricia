package br.ufu.facom.lsi.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;


/**
 * The persistent class for the trabalha_em database table.
 * 
 */
@Entity
@Table(name="trabalha_em")
@NamedQuery(name="TrabalhaEm.findAll", query="SELECT t FROM TrabalhaEm t")
public class TrabalhaEm implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	private String datainicio;

	private String datatermino;

	private String idlocaltrabalho;

	private String tokenusuario;

	public TrabalhaEm() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDatainicio() {
		return this.datainicio;
	}

	public void setDatainicio(String datainicio) {
		this.datainicio = datainicio;
	}

	public String getDatatermino() {
		return this.datatermino;
	}

	public void setDatatermino(String datatermino) {
		this.datatermino = datatermino;
	}

	public String getIdlocaltrabalho() {
		return this.idlocaltrabalho;
	}

	public void setIdlocaltrabalho(String idlocaltrabalho) {
		this.idlocaltrabalho = idlocaltrabalho;
	}

	public String getTokenusuario() {
		return this.tokenusuario;
	}

	public void setTokenusuario(String tokenusuario) {
		this.tokenusuario = tokenusuario;
	}

}