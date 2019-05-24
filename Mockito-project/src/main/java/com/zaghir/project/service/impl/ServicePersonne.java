package com.zaghir.project.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.zaghir.project.entities.Personne;
import com.zaghir.project.service.IPersonneService;

public class ServicePersonne implements IPersonneService{
	private List<Personne> list = new ArrayList<Personne>() ;

	public ServicePersonne() {
		list.add(new Personne(1 , "nom1","prenom1" ,"adesse1" ,"01-02-03-04-05","email1@gmail.com") );
		list.add(new Personne(2 , "nom2","prenom2" ,"adesse2" ,"01-02-03-04-05","email2@gmail.com") );
		list.add(new Personne(3 , "nom3","prenom3" ,"adesse3" ,"01-02-03-04-05","email3@gmail.com") );
	}
	
	public Personne getPersonne(Integer id) {
		return new Personne(1 , "nom1","prenom1" ,"adesse1" ,"01-02-03-04-05","email1@gmail.com");
	}

	public List<Personne> getAllPersonne() {
		return list;
	}

	public Integer addPersonne(Personne personne) {
		list.add(personne);
		return personne.getId();
	}

	public Integer deletePersonne(Integer id) {
		list.remove(id);
		return  id;
	}

	public Personne updatePersonne(Personne personne) {
		list.get(personne.getId()).setNom(personne.getNom());
		list.get(personne.getId()).setPrenom(personne.getPrenom());
		list.get(personne.getId()).setAdresse(personne.getAdresse());
		list.get(personne.getId()).setEmail(personne.getEmail());
		list.get(personne.getId()).setTelephone(personne.getTelephone());
		return personne;
	}

	public boolean login(String nom) {
		boolean test = false ;
		for(Personne p : list){
			if(p.getNom().equals(nom)){
				test = true ;
				break ;
			}
		}
		return test;
	}
	

}
