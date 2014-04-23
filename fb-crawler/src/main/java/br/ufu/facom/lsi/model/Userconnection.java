package br.ufu.facom.lsi.model;

import java.io.Serializable;

import javax.persistence.*;

/**
 * The persistent class for the userconnection database table.
 * 
 */

@Entity
@NamedQuery(name = "Userconnection.findAll", query = "SELECT u FROM Userconnection u")
public class Userconnection implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private UserconnectionPK id;

	private String accesstoken;

	private String displayname;

	private Long expiretime;

	private String imageurl;

	private String profileurl;

	private Integer rank;

	private String refreshtoken;

	private String secret;

	public Userconnection() {
	}

	public UserconnectionPK getId() {
		return this.id;
	}

	public void setId(UserconnectionPK id) {
		this.id = id;
	}

	public String getAccesstoken() {
		return this.accesstoken;
	}

	public void setAccesstoken(String accesstoken) {
		this.accesstoken = accesstoken;
	}

	public String getDisplayname() {
		return this.displayname;
	}

	public void setDisplayname(String displayname) {
		this.displayname = displayname;
	}

	public Long getExpiretime() {
		return this.expiretime;
	}

	public void setExpiretime(Long expiretime) {
		this.expiretime = expiretime;
	}

	public String getImageurl() {
		return this.imageurl;
	}

	public void setImageurl(String imageurl) {
		this.imageurl = imageurl;
	}

	public String getProfileurl() {
		return this.profileurl;
	}

	public void setProfileurl(String profileurl) {
		this.profileurl = profileurl;
	}

	public Integer getRank() {
		return this.rank;
	}

	public void setRank(Integer rank) {
		this.rank = rank;
	}

	public String getRefreshtoken() {
		return this.refreshtoken;
	}

	public void setRefreshtoken(String refreshtoken) {
		this.refreshtoken = refreshtoken;
	}

	public String getSecret() {
		return this.secret;
	}

	public void setSecret(String secret) {
		this.secret = secret;
	}

}