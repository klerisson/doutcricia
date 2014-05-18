package br.ufu.facom.lsi.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the postagem database table.
 * 
 */
@Entity
@NamedQuery(name="Postagem.findAll", query="SELECT p FROM Postagem p")
public class Postagem implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	private String conteudopostagem;

	private String datapostagem;

	private String idpostagem;

	private String idusuarioorigem;

	private String idusuariocorrente;
	
	//bi-directional many-to-one association to PostagemDestino
	@OneToMany(mappedBy="postagem", fetch=FetchType.EAGER)
	private List<PostagemDestino> postagemDestinos;

	public Postagem() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getConteudopostagem() {
		return this.conteudopostagem;
	}

	public void setConteudopostagem(String conteudopostagem) {
		this.conteudopostagem = conteudopostagem;
	}

	public String getDatapostagem() {
		return this.datapostagem;
	}

	public void setDatapostagem(String datapostagem) {
		this.datapostagem = datapostagem;
	}

	public String getIdpostagem() {
		return this.idpostagem;
	}

	public void setIdpostagem(String idpostagem) {
		this.idpostagem = idpostagem;
	}

	public String getIdusuariocorrente() {
		return this.idusuariocorrente;
	}

	public void setIdusuariocorrente(String idusuariocorrente) {
		this.idusuariocorrente = idusuariocorrente;
	}

	public String getIdusuarioorigem() {
		return this.idusuarioorigem;
	}

	public void setIdusuarioorigem(String idusuarioorigem) {
		this.idusuarioorigem = idusuarioorigem;
	}

	public List<PostagemDestino> getPostagemDestinos() {
		return this.postagemDestinos;
	}

	public void setPostagemDestinos(List<PostagemDestino> postagemDestinos) {
		this.postagemDestinos = postagemDestinos;
	}

	public PostagemDestino addPostagemDestino(PostagemDestino postagemDestino) {
		getPostagemDestinos().add(postagemDestino);
		postagemDestino.setPostagem(this);

		return postagemDestino;
	}

	public PostagemDestino removePostagemDestino(PostagemDestino postagemDestino) {
		getPostagemDestinos().remove(postagemDestino);
		postagemDestino.setPostagem(null);

		return postagemDestino;
	}

}