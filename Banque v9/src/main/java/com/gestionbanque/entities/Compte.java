package com.gestionbanque.entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="TYPE_CPTE",
discriminatorType=DiscriminatorType.STRING, length=2)
public abstract class Compte implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	private String codeCompte;
	private Date dateCreation;
	private double solde;
	@ManyToOne
	@JoinColumn(name="CODE_CLI")
	private Client client;
	@OneToMany(mappedBy="compte")
	private Collection<Operation> operations;
	
	// Getters/Setters
	
	public String getCodeCompte() {
		return codeCompte;
	}
	public void setCodeCompte(String codeCompte) {
		this.codeCompte = codeCompte;
	}
	public Date getDateCreation() {
		return dateCreation;
	}
	public void setDateCreation(Date dateCreation) {
		this.dateCreation = dateCreation;
	}
	public double getSolde() {
		return solde;
	}
	public void setSolde(double solde) {
		this.solde = solde;
	}
	public Client getClient() {
		return client;
	}
	public void setClient(Client client) {
		this.client = client;
	}
	public Collection<Operation> getOperations() {
		return operations;
	}
	public void setOperations(Collection<Operation> operations) {
		this.operations = operations;
	}

	// Constructor
	
	public Compte() { }
	public Compte(String codeCompte, Date dateCreation, double solde, 
                                                           Client client) {
		super();
		this.codeCompte = codeCompte;
		this.dateCreation = dateCreation;
		this.solde = solde;
		this.client = client;
	}
	public Compte(double solde, Client client, Collection<Operation> operations) {
		super();
		this.solde = solde;
		this.client = client;
		this.operations = operations;
	}
	
	// ToString()
	
	@Override
	public String toString() {
		return "Compte [codeCompte=" + codeCompte + ", dateCreation=" + dateCreation + ", solde=" + solde + ", client="
				+ client + ", operations=" + operations + "]";
	}
	
	// Equals
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codeCompte == null) ? 0 : codeCompte.hashCode());
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
		Compte other = (Compte) obj;
		if (codeCompte == null) {
			if (other.codeCompte != null)
				return false;
		} else if (!codeCompte.equals(other.codeCompte))
			return false;
		return true;
	}
	
	

}
