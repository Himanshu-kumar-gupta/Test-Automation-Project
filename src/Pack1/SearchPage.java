package Pack1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SearchPage {
	
	public static void main(String[] args)
	{
		BaseTest.setUpBrowser();
		
		WebDriver driver = BaseTest.generateTest();
		
		WebElement searchBar = driver.findElement(By.id("input-search"));
		searchBar.sendKeys("Arduino NANO");
		BaseTest.captureScreenshort(driver);
		
		driver.findElement(By.xpath("/html/body/header/div/div/div[2]/div/span/button/i")).click();
		
		boolean productName = driver.findElement(By.partialLinkText("Arduino NANO V3.0 Development Board")).isEnabled();
		BaseTest.captureScreenshort(driver);
		
		boolean productImage = driver.findElement(By.xpath("/html/body/div[4]/div/div/div[3]/div[9]/div/div[1]/a/img")).isDisplayed();
		
		boolean productPrice = driver.findElement(By.xpath("/html/body/div[4]/div/div/div[3]/div[9]/div/div[2]/p[2]")).isDisplayed();
		
		System.out.println("\n Is Product Name displayed status = " + productName +
						   "\n Is Product Image displayed status = " + productImage +
						   "\n Is Product Price displayed status = " + productPrice);
		
		BaseTest.tearDown(driver);
	}
}
