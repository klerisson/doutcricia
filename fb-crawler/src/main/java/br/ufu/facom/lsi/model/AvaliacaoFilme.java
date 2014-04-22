package br.ufu.facom.lsi.model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the avaliacao_filme database table.
 * 
 */
@Entity
@Table(name="avaliacao_filme")
@NamedQuery(name="AvaliacaoFilme.findAll", query="SELECT a FROM AvaliacaoFilme a")
public class AvaliacaoFilme implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer idavaliacao;

	private Timestamp dataavaliacao;

	private String nota;

	//bi-directional many-to-one association to Filme
	@ManyToOne
	@JoinColumn(name="idfilme")
	private Filme filme;

	//bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="idusuario")
	private Usuario usuario;

	public AvaliacaoFilme() {
	}

	public Integer getIdavaliacao() {
		return this.idavaliacao;
	}

	public void setIdavaliacao(Integer idavaliacao) {
		this.idavaliacao = idavaliacao;
	}

	public Timestamp getDataavaliacao() {
		return this.dataavaliacao;
	}

	public void setDataavaliacao(Timestamp dataavaliacao) {
		this.dataavaliacao = dataavaliacao;
	}

	public String getNota() {
		return this.nota;
	}

	public void setNota(String nota) {
		this.nota = nota;
	}

	public Filme getFilme() {
		return this.filme;
	}

	public void setFilme(Filme filme) {
		this.filme = filme;
	}

	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}