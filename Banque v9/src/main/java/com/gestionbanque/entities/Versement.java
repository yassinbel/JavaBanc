package com.gestionbanque.entities;

import java.util.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
@Entity
@DiscriminatorValue("V")
public class Versement extends Operation{
	
	private static final long serialVersionUID = 1L;
	
	// Constructor
	
	public Versement() { }
	public Versement(Date dateOperation, double montant, Compte compte) {
		super(dateOperation, montant, compte);
	}
	
	// ToString()
	
	@Override
	public String toString() {
		return "Versement [getNumero()=" + getNumero() + ", getDateOperation()=" + getDateOperation()
				+ ", getMontant()=" + getMontant() + ", getCompte()=" + getCompte() + ", toString()=" + super.toString()
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + "]";
	}

	

}
