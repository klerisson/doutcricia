package br.ufu.facom.lsi.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the livro database table.
 * 
 */
@Entity
@NamedQuery(name="Livro.findAll", query="SELECT l FROM Livro l")
public class Livro implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer idlivro;

	private String titulolivro;

	public Livro() {
	}

	public Integer getIdlivro() {
		return this.idlivro;
	}

	public void setIdlivro(Integer idlivro) {
		this.idlivro = idlivro;
	}

	public String getTitulolivro() {
		return this.titulolivro;
	}

	public void setTitulolivro(String titulolivro) {
		this.titulolivro = titulolivro;
	}

}