package Pack1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Logs {
	
WebDriver driver;
	
	@BeforeTest
	public void beforeLogin()
	{
		System.setProperty("webdriver.chrome.driver", "E:\\Test auto\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		Reporter.log("\nBrowser is opened now",true);
		driver.manage().window().maximize();
		Reporter.log("Browser window is maximized",true);
		driver.get("https://www.electronicscomp.com/");	
		Reporter.log("\nElectronics comp site is opened now",true);
	}
	
	@Test
	public void login1()
	{
		//code for login on electronicscomp.com
		 WebElement searchBar = driver.findElement(By.id("input-search")); 
			searchBar.sendKeys("Arduino NANO");
			
			Reporter.log("\nSearching for Arduino NANO",true);	
			
			WebElement searchButton = driver.findElement(By.xpath("//*[@id=\"search\"]/span/button/i"));
			searchButton.click();
								
			driver.findElement(By.partialLinkText("Arduino NANO V3.0 Development Board - Clone Compatible Model")).click();
	        
			Reporter.log("\nMigrating to product page",true);
			WebElement artcleTitle = driver.findElement(By.xpath("//*[@id=\"raa-div-prduct\"]/h1"));
			
			System.out.println(artcleTitle.getText());
			
			artcleTitle.getText().contains("Arduino NANO V3.0");
			
			WebElement addtocartslot = driver.findElement(By.id("button-cart"));
			boolean r1 = addtocartslot.isEnabled();
			Reporter.log("\nAdd to cart button is enabled",r1);	
			
			WebElement buynowslot = driver.findElement(By.id("button-buynow"));
			boolean r2 = buynowslot.isEnabled();
			Reporter.log("\nBuy now button is enabled",r2);	
	}

	
	@AfterTest
	public void afterLogin()
	{
		driver.close();
		Reporter.log("\nDriver is closed",true);	
	}

}


