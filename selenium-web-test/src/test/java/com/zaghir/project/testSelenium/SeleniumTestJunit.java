package com.zaghir.project.testSelenium;

import java.io.File;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.internal.FindsByClassName;
import org.openqa.selenium.internal.FindsByCssSelector;
import org.openqa.selenium.internal.FindsById;
import org.openqa.selenium.internal.FindsByName;
import org.openqa.selenium.internal.FindsByXPath;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SeleniumTestJunit {
	

	WebDriver driver;

	@Test
	public void loginToWordpress(/* String username , String password */) throws InterruptedException {

		driver.findElement(By.id("user_login")).sendKeys("admin");
		driver.findElement(By.id("user_pass")).sendKeys("admin");
		driver.findElement(By.xpath(".//*[@id='wp-submit']")).click();

		Thread.sleep(2000);
		// driver.findElement(By.linkText("Catégories"));
		// //edit-tags.php?taxonomy=category
		WebElement element = driver.findElement(By.linkText("Catégories"));
		System.out.println(element.getTagName());
		WebElement elementCss = driver.findElement(By.className("welcome-icon welcome-view-site"));
		Thread.sleep(5000);

		// Assert.assertTrue(driver.getTitle().concat("Tableau de bord ‹
		// wordpressTest — WordPress") , "L'utilisateur n'est pas loggué -
		// Invalide Credentails");
		Assert.assertTrue(driver.getTitle().contains("Tableau de bord ‹ wordpressTest — WordPress"));
		System.out.println("Verification pour le title de la page  , utilisateur est bien loggué");

	}
	
	public void test2(){
		WebElement element = ((FindsById)driver).findElementById("button"); // element not found  throw a NoSuchElementException exception
		WebElement childElement = element.findElement(By.tagName("a"));
		
		List<WebElement> elements = ((FindsById)driver).findElementsById("verifybutton");  // element not found  list size = 0
		Assert.assertEquals(1, elements.size());
		
		
		WebElement elementByName = ((FindsByName)driver).findElementByName("selected(1234)");  // not found  throw a NotSuchElementFound exception
		
		// we can have multiple elements on the page that have the same name. This is also 	a symmetrical call to find multiple elements
		
		List<WebElement> elementsByName = (List<WebElement>) ((FindsByName)driver).findElementByName("selected(1234)");
	     Assert.assertEquals(1, elements.size());
	     
	     WebElement elementClassName = ((FindsByClassName)driver).findElementByClassName("storetext");
	     
	     List<WebElement> elementsClassName = ((FindsByClassName)driver) .findElementsByClassName("storetext");
	     Assert.assertEquals(1, elements.size());
	      
	     WebElement elementCssSelector = ((FindsByCssSelector)driver).findElementByCssSelector("storetext");
	     
	     WebElement elementXpath = ((FindsByXPath)driver).findElementByXPath("verifybutton"); // element not found  throw a NoSuchElementException exception
	     
	     driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	     driver.findElement(By.xpath("//div[@id='ajaxdiv']"));
	     
		WebElement elementWebDriverWait = (new WebDriverWait(driver, 10)).until(new ExpectedCondition<WebElement>() {
			public WebElement apply(WebDriver d) {
				return d.findElement(By.xpath("//div[@id='ajaxdiv']"));
			}
		});
		
		
		
	}
	
	public void testMultiBrowser(){
		
	}

	public Object[][] passData() {
		Object[][] data = new Object[3][2];
		data[0][0] = "admin";
		data[0][1] = "admin";
		data[1][0] = "admin1";
		data[1][1] = "admin1";
		data[1][0] = "admin2";
		data[1][1] = "admin2";
		return data;
	}
	
	

	@Before
	public void setUp() {
//		File fileDriver = new File("drivers/geckodriver.exe");
//		System.setProperty("webdriver.gecko.driver", fileDriver.getAbsolutePath());
//		System.out.println("Test Selenium " + fileDriver.getAbsolutePath());

		// startUpHomePage
		FirefoxProfile profile = new FirefoxProfile();
		profile.setPreference("browser.startup.homepage", "http://localhost/wordpressTest/wp-login.php");
		
//		Firebug
		File firebug = new File("firebug.xpi");
		profile.addExtension(firebug);
		profile.setPreference("extensions.firebug.currentVersion", 	"99.9");
		
		File fileDriver = new File("drivers/geckodriver.exe");
		FirefoxBinary binary = new FirefoxBinary(fileDriver);
		
		
		driver = new FirefoxDriver(binary,profile);

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		String baseUrl = "http://localhost/wordpressTest/wp-login.php";
		driver.get(baseUrl);
	}

	@After
	public void tearDown() {
		driver.quit();
	}


}
