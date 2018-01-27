package com.gestionbanque.entities;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
@Entity
public class Client implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id @GeneratedValue
	private Long code;
	private String nom;
	private String email;
	@OneToMany(mappedBy="client", fetch=FetchType.LAZY)
	private Collection<Compte> comptes;
	
	// Getters/Setters
	
	public Long getCode() {
		return code;
	}
	public void setCode(Long code) {
		this.code = code;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Collection<Compte> getComptes() {
		return comptes;
	}
	public void setComptes(Collection<Compte> comptes) {
		this.comptes = comptes;
	}
	
	// Constructor
	
	public Client() {	}
	public Client(String nom, String email) {
		this.nom = nom; this.email = email;
	}
	public Client(Long code, String nom, String email) {
		super();
		this.code = code;
		this.nom = nom;
		this.email = email;
	}
	public Client(Long code, String nom, String email, Collection<Compte> comptes) {
		super();
		this.code = code;
		this.nom = nom;
		this.email = email;
		this.comptes = comptes;
	}
	
	// ToString()
	@Override
	public String toString() {
		return "Client [code=" + code + ", nom=" + nom + ", email=" + email + ", comptes=" + comptes + "]";
	}
	
	// Equals
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((code == null) ? 0 : code.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Client other = (Client) obj;
		if (code == null) {
			if (other.code != null)
				return false;
		} else if (!code.equals(other.code))
			return false;
		return true;
	}


	
}
