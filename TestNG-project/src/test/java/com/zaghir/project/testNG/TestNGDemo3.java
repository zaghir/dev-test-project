package com.zaghir.project.testNG;

import org.testng.annotations.Test;

public class TestNGDemo3 {
			
	@Test(groups={"legumes"}  )
	public void testOignon(){
		System.out.println(" ---> oignon group légumes");
	}
	
	@Test(groups={"legumes"}  )
	public void testChampignons(){
		System.out.println(" ---> Champignons group légumes");
	}
	
	@Test(groups={"fabrication"} ,priority = 0)
	public void testPreparer(){
		System.out.println("---> Preparer ");
	}
	
	@Test(groups={"fabrication"} ,priority = 1)
	public void testCuire(){
		System.out.println("---> Cuire ");
	}
	
	@Test(groups={"fabrication"} ,priority = 2)
	public void testEmballer(){
		System.out.println("---> Emballer ");
	}
	
	@Test(groups={"commanderPizzaFromage"})
	public void testCommanderPizzaFromage(){
		System.out.println("--->  Commander Pizza Fromage ");
	}
	
	@Test(groups={"commanderPizzaChampignons"})
	public void testCommanderPizzaChampignons(){
		System.out.println("--->  Commander Pizza Champignons ");
	}

}
