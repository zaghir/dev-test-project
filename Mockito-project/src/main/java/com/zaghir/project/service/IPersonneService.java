package com.zaghir.project.service;

import java.util.List;
import com.zaghir.project.entities.Personne;

public interface IPersonneService {	
	public Personne getPersonne( Integer id);	
	public List<Personne> getAllPersonne();
	public Integer addPersonne(Personne personne);
	public Integer deletePersonne( Integer id);
	public Personne updatePersonne(Personne personne);
	public boolean login(String nom);
}
