package br.ufu.facom.lsi.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;


/**
 * The persistent class for the estuda_em database table.
 * 
 */
@Entity
@Table(name="estuda_em")
@NamedQuery(name="EstudaEm.findAll", query="SELECT e FROM EstudaEm e")
public class EstudaEm implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	private String anoturma;

	private String idlocalestudo;
	
	private String nomelocalestudo;

	private String tokenusuario;

	public EstudaEm() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getAnoturma() {
		return this.anoturma;
	}

	public void setAnoturma(String anoturma) {
		this.anoturma = anoturma;
	}

	public String getIdlocalestudo() {
		return this.idlocalestudo;
	}

	public void setIdlocalestudo(String idlocalestudo) {
		this.idlocalestudo = idlocalestudo;
	}

	public String getNomelocalestudo() {
		return this.nomelocalestudo;
	}

	public void setNomelocalestudo(String nomelocalestudo) {
		this.nomelocalestudo = nomelocalestudo;
	}
	
	public String getTokenusuario() {
		return this.tokenusuario;
	}

	public void setTokenusuario(String tokenusuario) {
		this.tokenusuario = tokenusuario;
	}

}