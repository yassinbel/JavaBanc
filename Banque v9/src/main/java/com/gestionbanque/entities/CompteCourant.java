package com.gestionbanque.entities;

import java.util.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
@Entity
@DiscriminatorValue("CC")
public class CompteCourant extends Compte{
	
	private static final long serialVersionUID = 1L;
	
	private double decouvert;
	
	// Getters/Setters
	
	public double getDecouvert() {
		return decouvert;
	}
	public void setDecouvert(double decouvert) {
		this.decouvert = decouvert;
	}
	
	// Constructor

	public CompteCourant() { }
	public CompteCourant(String codeCompte, Date dateCreation, 
                           double solde, Client client, double decouvert) {
		super(codeCompte, dateCreation, solde, client);
		this.decouvert = decouvert;
	}
	
	// ToString()
	
	@Override
	public String toString() {
		return "CompteCourant [decouvert=" + decouvert + "]";
	}
	
}
