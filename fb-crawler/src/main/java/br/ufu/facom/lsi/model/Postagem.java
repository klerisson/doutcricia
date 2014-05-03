package br.ufu.facom.lsi.model;

import java.io.Serializable;
import javax.persistence.*;


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

	private String idusuariodestino;

	private String idusuarioorigem;

	public Postagem() {
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

	public String getIdusuariodestino() {
		return this.idusuariodestino;
	}

	public void setIdusuariodestino(String idusuariodestino) {
		this.idusuariodestino = idusuariodestino;
	}

	public String getIdusuarioorigem() {
		return this.idusuarioorigem;
	}

	public void setIdusuarioorigem(String idusuarioorigem) {
		this.idusuarioorigem = idusuarioorigem;
	}

}