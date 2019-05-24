package com.zaghir.project.testNG;

import org.testng.annotations.Test;

public class TestNGDemo1 {
	
	
	@Test(timeOut=2000 , priority =0)
	public void test1(){		
		try {
			Thread.sleep(1000);
			System.out.println("test1");
		} catch (InterruptedException e) {			
			e.printStackTrace();
		}
		
	}
	
	@Test(enabled= false , priority=1)
	public void test2(){
		System.out.println("test2");
	}
	
	@Test(priority=4)
	public void test3(){
		System.out.println("test3");
	}
	
	@Test(priority=3)
	public void test4(){
		System.out.println("test4");
	}
	
	@Test(invocationCount=5)
	public void test5(){
		System.out.println("test5  repeter ");
	}
	
	@Test(invocationCount=2 , invocationTimeOut = 3000)
	public void test6() throws InterruptedException{
		Thread.sleep(1000);
		System.out.println("test6  repeter ");
	}
	
	@Test(dependsOnMethods={"test8"})
	public void test7(){
		System.out.println("test7 ---> depend vers ---> test8 ");
	}
	
	@Test()
	public void test8(){
		System.out.println("test8 ");
	}
	
	
}
