package com.gestionbanque.entities;

import java.util.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("CE")
public class CompteEpargne extends Compte {

	private static final long serialVersionUID = 1L;

	private double taux;

	// Getters/Setters

	public double getTaux() {
		return taux;
	}

	public void setTaux(double taux) {
		this.taux = taux;
	}

	// Constructor

	public CompteEpargne() {
	}

	public CompteEpargne(String codeCompte, Date dateCreation, double solde, Client client, double taux) {
		super(codeCompte, dateCreation, solde, client);
		this.taux = taux;
	}

	// ToString()

	@Override
	public String toString() {
		return "CompteEpargne [taux=" + taux + "]";
	}

}
