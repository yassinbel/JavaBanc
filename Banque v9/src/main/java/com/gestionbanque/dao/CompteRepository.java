package com.gestionbanque.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gestionbanque.entities.Compte;

public interface CompteRepository extends JpaRepository<Compte, String>{

}
