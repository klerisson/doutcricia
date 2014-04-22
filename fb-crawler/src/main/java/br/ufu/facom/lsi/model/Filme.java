package br.ufu.facom.lsi.model;

import java.io.Serializable;

import javax.persistence.*;

import java.math.BigDecimal;
import java.util.List;


/**
 * The persistent class for the filme database table.
 * 
 */
@Entity
@NamedQueries({
	@NamedQuery(name="Filme.findAll", query="SELECT f FROM Filme f"),
	@NamedQuery(name="Filme.findByStatusfilme", query="SELECT f FROM Filme f where f.statusfilme = 't'")
})
public class Filme implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer idfilme;

	private BigDecimal anolancamento;

	private String ator;

	private String diretor;

	private String genero;

	private String idioma;

	private byte[] imgfilme;

	private String statusfilme;

	private String titulofilme;

	//bi-directional many-to-one association to AvaliacaoFilme
	@OneToMany(mappedBy="filme")
	private List<AvaliacaoFilme> avaliacaoFilmes;
	
	@Transient
	private String imgfilmeString;

	public Filme() {
	}

	public Integer getIdfilme() {
		return this.idfilme;
	}

	public void setIdfilme(Integer idfilme) {
		this.idfilme = idfilme;
	}

	public BigDecimal getAnolancamento() {
		return this.anolancamento;
	}

	public void setAnolancamento(BigDecimal anolancamento) {
		this.anolancamento = anolancamento;
	}

	public String getAtor() {
		return this.ator;
	}

	public void setAtor(String ator) {
		this.ator = ator;
	}

	public String getDiretor() {
		return this.diretor;
	}

	public void setDiretor(String diretor) {
		this.diretor = diretor;
	}

	public String getGenero() {
		return this.genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public String getIdioma() {
		return this.idioma;
	}

	public void setIdioma(String idioma) {
		this.idioma = idioma;
	}

	public byte[] getImgfilme() {
		return this.imgfilme;
	}

	public void setImgfilme(byte[] imgfilme) {
		this.imgfilme = imgfilme;
	}

	public String getStatusfilme() {
		return this.statusfilme;
	}

	public void setStatusfilme(String statusfilme) {
		this.statusfilme = statusfilme;
	}

	public String getTitulofilme() {
		return this.titulofilme;
	}

	public void setTitulofilme(String titulofilme) {
		this.titulofilme = titulofilme;
	}

	public List<AvaliacaoFilme> getAvaliacaoFilmes() {
		return this.avaliacaoFilmes;
	}

	public void setAvaliacaoFilmes(List<AvaliacaoFilme> avaliacaoFilmes) {
		this.avaliacaoFilmes = avaliacaoFilmes;
	}

	public AvaliacaoFilme addAvaliacaoFilme(AvaliacaoFilme avaliacaoFilme) {
		getAvaliacaoFilmes().add(avaliacaoFilme);
		avaliacaoFilme.setFilme(this);

		return avaliacaoFilme;
	}

	public AvaliacaoFilme removeAvaliacaoFilme(AvaliacaoFilme avaliacaoFilme) {
		getAvaliacaoFilmes().remove(avaliacaoFilme);
		avaliacaoFilme.setFilme(null);

		return avaliacaoFilme;
	}
	
	public String getImgfilmeString() {
		return imgfilmeString;
	}

	public void setImgfilmeString(String imgfilmeString) {
		this.imgfilmeString = imgfilmeString;
	}

}