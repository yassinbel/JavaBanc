package com.gestionbanque;



import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.gestionbanque.dao.ClientRepository;
import com.gestionbanque.dao.CompteRepository;
import com.gestionbanque.dao.OperationRepository;
import com.gestionbanque.entities.Client;
import com.gestionbanque.entities.Compte;
import com.gestionbanque.entities.CompteCourant;
import com.gestionbanque.entities.CompteEpargne;
import com.gestionbanque.entities.Retrait;
import com.gestionbanque.entities.Versement;
import com.gestionbanque.metier.IBanqueMetier;



@SpringBootApplication
public class BanqueApplication implements CommandLineRunner{

	@Autowired 
	 private ClientRepository clientRepository; 
	 @Autowired 
	 private CompteRepository compteRepository; 
	 @Autowired 
	 private OperationRepository operationRepository; 
	 @Autowired 
	 private IBanqueMetier banqueMetier; 
	 
	public static void main(String[] args) {
		SpringApplication.run(BanqueApplication.class, args);
	}

	@Override
	public void run(String... arg0) throws Exception {
		// TODO Auto-generated method stub
		
		Client p1 = clientRepository.save( 
				 new Client("Ahmed", "ahmed@mail.com")); 
				 Client p2 = clientRepository.save( 
				 new Client("Aicha", "aicha@mail.com")); 
				 Client p3 = clientRepository.save( 
				 new Client("Merieme", "merieme@mail.com")); 
				 
				 Compte c1 = compteRepository.save( 
				 new CompteCourant("cp 1111", new Date(), 50000, p1, 1000)); 
				 Compte c2 = compteRepository.save( 
				 new CompteEpargne("cp 2222", new Date(), 30000, p1, 5.5)); 
				 Compte c3 = compteRepository.save( 
				 new CompteCourant("cp 3333", new Date(), 80000, p2, 1000)); 
				 Compte c4 = compteRepository.save( 
				 new CompteCourant("cp 4444", new Date(), 50000, p3, 1000)); 
				 operationRepository.save(new Versement(new Date(), 200, c1)); 
				 operationRepository.save(new Retrait(new Date(), 4000, c2)); 
				 operationRepository.save(new Versement(new Date(), 100, c3)); 
				 operationRepository.save(new Retrait(new Date(), 3000, c4)); 
				 
				 banqueMetier.virement("cp 1111", "cp 3333", 5000);
		
	}
	
}
