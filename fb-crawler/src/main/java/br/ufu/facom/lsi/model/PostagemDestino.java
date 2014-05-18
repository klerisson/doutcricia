package br.ufu.facom.lsi.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the postagem_destino database table.
 * 
 */
@Entity
@Table(name="postagem_destino")
@NamedQuery(name="PostagemDestino.findAll", query="SELECT p FROM PostagemDestino p")
public class PostagemDestino implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	private String idusuariodestino;

	//bi-directional many-to-one association to Postagem
	@ManyToOne
	@JoinColumn(name="idpostagem")
	private Postagem postagem;

	public PostagemDestino() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getIdusuariodestino() {
		return this.idusuariodestino;
	}

	public void setIdusuariodestino(String idusuariodestino) {
		this.idusuariodestino = idusuariodestino;
	}

	public Postagem getPostagem() {
		return this.postagem;
	}

	public void setPostagem(Postagem postagem) {
		this.postagem = postagem;
	}

}