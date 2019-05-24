package com.zaghir.project;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.mockito.Mockito;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

import com.zaghir.project.entities.Personne;
import com.zaghir.project.service.IPersonneService;

public class MockitoDemo {
	
	@Test
	public void testMock1(){
		IPersonneService servicePersonne = Mockito.mock(IPersonneService.class);
		List<Personne> list = new ArrayList<Personne>();
		list.add(new Personne(1 , "nom1","prenom1" ,"adesse1" ,"01-02-03-04-05","email1@gmail.com") );
		
		Mockito.when(servicePersonne.getAllPersonne()).thenReturn(list);
		
		assertEquals(1 , servicePersonne.getAllPersonne().size());
	}
	
	@Test
	public void testMock2(){
		IPersonneService servicePersonne = Mockito.mock(IPersonneService.class);
		
		Mockito.when(servicePersonne.login("nom1")).thenAnswer(new Answer(){

			public Object answer(InvocationOnMock invocation) throws Throwable {
				return true;
			}			
		});		
		assertEquals(true , servicePersonne.login("nom1"));
	}
	
	@Test
	public void testMock3(){
		IPersonneService servicePersonne = Mockito.mock(IPersonneService.class);		
		Mockito.when(servicePersonne.updatePersonne(new Personne())).thenThrow(new NullPointerException());
		
		assertEquals(new Personne(1 , "nom1","prenom1" ,"adesse1" ,"01-02-03-04-05","email1@gmail.com") , servicePersonne.updatePersonne(new Personne(1 , "nom1","prenom1" ,"adesse1" ,"01-02-03-04-05","email1@gmail.com")));
		
	}

}
