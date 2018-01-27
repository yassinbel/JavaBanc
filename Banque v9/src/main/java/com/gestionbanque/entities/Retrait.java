package com.gestionbanque.entities;

import java.util.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
@Entity
@DiscriminatorValue("R")
public class Retrait extends Operation{
	
	private static final long serialVersionUID = 1L;
	
	// Constructor
	
	public Retrait() { }
	public Retrait(Date dateOperation, double montant, Compte compte) {
		super(dateOperation, montant, compte);
	}
	
	// ToString()
	
	@Override
	public String toString() {
		return "Retrait [getNumero()=" + getNumero() + ", getDateOperation()=" + getDateOperation() + ", getMontant()="
				+ getMontant() + ", getCompte()=" + getCompte() + ", toString()=" + super.toString() + ", getClass()="
				+ getClass() + ", hashCode()=" + hashCode() + "]";
	}
	
	/*@Override
	public String toString() {
		return super.toString();
	}*/
	
	
	
	

	
}
