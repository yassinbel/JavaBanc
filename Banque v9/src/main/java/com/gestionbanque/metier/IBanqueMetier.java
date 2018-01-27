package com.gestionbanque.metier;

import org.springframework.data.domain.Page;

import com.gestionbanque.entities.Compte;
import com.gestionbanque.entities.Operation;

public interface IBanqueMetier {
	
	public Compte consulterCompte(String codeCompte); 
	public void verser(String codeCompte, double montant); 
	public void retirer(String codeCompte, double montant); 
	public void virement(String cs, String cd, double montant); 
	public Page<Operation> listOperation(String codeCompte, int page, int size); 

}
