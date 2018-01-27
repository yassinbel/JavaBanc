package com.gestionbanque.metier;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gestionbanque.dao.CompteRepository;
import com.gestionbanque.dao.OperationRepository;
import com.gestionbanque.entities.Compte;
import com.gestionbanque.entities.CompteCourant;
import com.gestionbanque.entities.Operation;
import com.gestionbanque.entities.Retrait;
import com.gestionbanque.entities.Versement;

@Service
@Transactional
public class BanqueMetier implements IBanqueMetier{

	@Autowired 
	private CompteRepository compteRepository; 
	@Autowired 
	private OperationRepository operationRepository; 
	 
	 
	@Override
	public Compte consulterCompte(String codeCompte) {
		Compte c = compteRepository.findOne(codeCompte); 
		if (c == null) 
		throw new RuntimeException("Compte inexistant !!!"); 
		return c; 
	}

	@Override
	public void verser(String codeCompte, double montant) {
		Compte c = consulterCompte(codeCompte); 
		Versement v = new Versement(new Date(), montant, c); 
		operationRepository.save(v); 
		c.setSolde(c.getSolde() + montant); 
		compteRepository.save(c); 
		
	}

	@Override
	public void retirer(String codeCompte, double montant) {
		Compte c = consulterCompte(codeCompte); 
		double faciliteCaisse = 0.0; 
		 if (c instanceof CompteCourant) { 
		 faciliteCaisse = ((CompteCourant) c).getDecouvert(); 
		 } 
		 if (c.getSolde() + faciliteCaisse < montant) { 
		 throw new RuntimeException("Solde insuffisant"); 
		 } 
		 Retrait r = new Retrait(new Date(), montant, c); 
		 operationRepository.save(r); 
		 c.setSolde(c.getSolde() - montant); 
		 compteRepository.save(c); 
		
	}

	@Override
	public void virement(String cs, String cd, double montant) {
		retirer(cs, montant); 
		verser(cd, montant); 
		
	}

	@Override
	public Page<Operation> listOperation(String codeCompte, int page, int size) {
		
			 return operationRepository.listOperation(codeCompte, new PageRequest(page, size));
	}

}
