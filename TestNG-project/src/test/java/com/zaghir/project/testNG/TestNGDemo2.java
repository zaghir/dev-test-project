package com.zaghir.project.testNG;

import org.testng.annotations.AfterGroups;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestNGDemo2 {
	
	private int stockFruits = 100 ;
	private int stockLegumes = 200 ;
		
	@Test( dataProvider="listDriver" )
	public void testDriver(int index , String  driver){
		System.out.println( "index :-->"+index+" -- nomDriver:--> " +driver);
		
	}
	
	@DataProvider(name="listDriver")
	public Object[][] listDriver() {
		Object[][] data = new Object[2][2];
		data[0][0] = 0;
		data[0][1] = "chrome";
		data[1][0] = 1;
		data[1][1] = "fireFox";		
		return data;
	}
	
	@Test(groups={"fruits"})
	public void testBanane(){
		System.out.println(" test banane group fruits");
	}
	
	@Test(groups={"fruits"})
	public void testPomme(){
		System.out.println(" test pomme group fruits");
	}
	
	@Test(groups={"fruits"})
	public void testOrange(){
		System.out.println(" test orange group fruits");
	}
	
	@Test(groups={"legumes"})
	public void testCarotte(){
		System.out.println(" test carrote group légumes");
	}
	
	@Test(groups={"legumes"}  )
	public void testOignon(){
		System.out.println(" test oignon group légumes");
	}
	
	@Test(groups={"legumes"}  )
	public void testCourgette(){
		System.out.println(" test courgette group légumes");
	}
		
	@Test(groups={"cuisine"} ,dependsOnGroups={"legumes" ,"fruits"} , description="test cuisine depend de fruits et légumes" , testName="testCuisine")
	public void testCuisine(){
		System.out.println(" test cuisine group légumes , fruits ");
	}
	
	@BeforeGroups(groups={"cuisine"})
	public void testAlimenterStockFruits(){
		System.out.println(" ----Stock fruits = " +stockFruits);
		stockFruits += 50 ;
		System.out.println(" Alimenter Stock Fruits "+stockFruits);
	}
	@AfterGroups(groups={"cuisine"})
	public void testDebiterStockFruits(){
		System.out.println("----Stock fruits = " +stockFruits);
		stockFruits -= 100 ;
		System.out.println(" Alimenter Stock Fruits "+stockFruits);
	}
	
	@BeforeGroups(groups={"cuisine"})
	public void testAlimenterStockLegumes(){
		System.out.println(" ----Stock légumes = " +stockLegumes);
		stockLegumes += 50 ;
		System.out.println(" Alimenter Stock Légumes "+stockLegumes);
	}
	
	@AfterGroups(groups={"cuisine"})
	public void testDebiterStockLegumes(){
		System.out.println(" ----Stock légumes = " +stockLegumes);
		stockLegumes -= 100 ;
		System.out.println(" Alimenter Stock Légumes "+stockLegumes);
	}
	
	
	
}
