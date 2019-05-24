package com.zaghir.project.testSelenium;

import java.io.File;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterGroups;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.Test;

public class SeleniumTestChromeFirefoxDriver {

	private WebDriver driver;
	
	final static int sleep = 3000;
	
	@BeforeGroups(groups={"firefox"})
	public void setUpFireFox() {
		
		File filedriver = new File("drivers/geckodriver.exe");
		System.setProperty("webdriver.gecko.driver", filedriver.getAbsolutePath());

		driver = new FirefoxDriver();

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		String baseUrl = "http://localhost/wordpressTest/wp-login.php?";
		driver.get(baseUrl);
		
	}
	
	@BeforeGroups(groups={"chrome"}, enabled=false)
	public void setUpChrome() {

		File filedriver = new File("drivers/chromedriver.exe");
		System.setProperty("webdriver.chrome.driver", filedriver.getAbsolutePath());

		driver = new ChromeDriver();

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		String baseUrl = "http://localhost/wordpressTest/wp-login.php?";
		driver.get(baseUrl);
	}
		

	@AfterGroups(groups={"chrome","firefox"})
	public void tearDownC() {
		driver.quit();
	}
	
	
	@Test(groups={"firefox" ,"chrome"})
	public void testIdentification() throws InterruptedException{
		driver.findElement(By.id("user_login")).sendKeys("admin");
		driver.findElement(By.id("user_pass")).sendKeys("admin");
		WebElement elementButton = driver.findElement(By.xpath(".//*[@id='wp-submit']"));
		elementButton.click();
		Thread.sleep(sleep);
	}
	
	@Test(groups={"firefox" ,"chrome"} , dependsOnMethods="testIdentification")
	public void testMenu() throws InterruptedException{
		WebElement adminMenu = driver.findElement(By.id("adminmenu"));
		WebElement menuPosts = adminMenu.findElement(By.id("menu-posts"));
		menuPosts.click();
		Thread.sleep(sleep);		
	}
	
	@Test(groups={"firefox" ,"chrome"} , dependsOnMethods="testMenu")
	public void testMenuAjouterArticle1() throws InterruptedException{
		
		WebElement ajouterArticle = driver.findElement(By.linkText("Ajouter"));
		ajouterArticle.click();
		Thread.sleep(sleep);	
		driver.findElement(By.id("title")).sendKeys("Test Selenium1");
		Thread.sleep(sleep);
		driver.findElement(By.id("publish")).click();
		Thread.sleep(sleep);		

	}

	@Test(groups={"firefox" ,"chrome"} , dependsOnMethods="testMenuAjouterArticle1")
	public void testMenuAjouterArticle2() throws InterruptedException{
		// il faut faire attention au changement de dom de la page , car à chaque refresh le framwork génere
		// un nouveau dom avec des nouveaux Id pour le elements html
		driver.findElement(By.linkText("Ajouter")).click();
		Thread.sleep(sleep);
		driver.findElement(By.id("title")).sendKeys("Test Selenium2");
		Thread.sleep(sleep);
//		driver.findElement(By.id("mceu_33"))
//		.findElement(By.id("content_ifr"))
//			.sendKeys("test automatisé avec le framework selenium  2");
//		Thread.sleep(sleep);
		driver.findElement(By.id("major-publishing-actions")).findElement(By.id("publish")).click();
		Thread.sleep(sleep);

	}
	
	@Test(groups={"firefox" ,"chrome"} , dependsOnMethods="testMenuAjouterArticle2")
	public void testMenuAfficherLesArticles() throws InterruptedException{
		driver.findElement(By.linkText("Tous les articles")).click();
		Thread.sleep(sleep);
		
		// recuperer la table des articles
		WebElement elementTableArticle = driver.findElement(By.id("the-list"));
		List<WebElement> rowsTable = elementTableArticle.findElements(By.tagName("tr"));
		System.out.println("------------------------------------------- test get id"+rowsTable.size());
		for(WebElement row : rowsTable){
			List<WebElement> columnsRow = row.findElements(By.tagName("td"));
			System.out.println("------------------------------------------- test get td -->"+columnsRow.size());
			if(columnsRow.get(0).getText().equals("Test Selenium2") ){
				driver.findElement(By.linkText("Test Selenium1")).click();
				System.out.println("------------------------------------------- test get id");
				break;
			}
		}
		Thread.sleep(sleep);		

	}

	
	

}
